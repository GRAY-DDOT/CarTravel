package car;

import constansts.WeatherCondition;

/*
- 공통 필드:
  - 속도 (int) velocity
  - 연비 (int) fuelEfficiency
  - 연료탱크 크기 (int) fuelCapacity
  - 좌석 수 (int) seatsNumber
  - 차량 이름 (String) name
- 공통 기능:
  - 총 이동 횟수 계산 totalMovement
  - 주유 횟수 계산 totaRefuel
  - 총 비용 계산 totalCost
  - 총 이동 시간 계산 totalTravelTime
- 추상 메서드:
  - setMode(boolean isOn) → 차량별 부과 기능 on/off
*/
public abstract class Car {
    public static final int HOUR_TO_MINUTE_CONVERT_FACTOR = 60;
    protected int velocity; // 속도
    protected int fuelEfficiency; // 연비
    protected int fuelCapacity; // 연료탱크 크기
    protected int seatsNumber; // 좌석 수
    protected boolean isModeOn; // 모드 상태 (on/off)
    protected String name; // 차량 이름
    final protected int FUEL_PRICE = 2000; // 연료 가격 (단위: 원)

    /**
     * 생성자
     *
     * @param velocity       차량 속도 (km/h)
     * @param fuelEfficiency 차량 연비 (km/L)
     * @param fuelCapacity   차량 연료탱크 크기 (L)
     * @param seatsNumber    차량 좌석 수
     */
    public Car(int velocity, int fuelEfficiency, int fuelCapacity, int seatsNumber) {
        this.velocity = velocity;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
        this.seatsNumber = seatsNumber;
    }


    // ceil(승객 수 / 좌석 수)

    /**
     * 총 이동 횟수 계산
     *
     * @param passengers 승객 수
     * @return 총 이동 횟수
     */
    public int totalMovement(int passengers) {
        return (int) Math.ceil((double) passengers / this.seatsNumber);
    }

    //거리 × 횟수

    /**
     * 총 이동 거리 계산
     *
     * @param distance      목적지까지의 거리 (km)
     * @param totalMovement 총 이동 횟수
     * @return 총 이동 거리
     */
    public int totalDistance(int distance, int totalMovement) {
        return distance * totalMovement;
    }

    /**
     * 총 연료 소모량 계산
     *
     * @param totalDistance 총 이동 거리 (km)
     * @return 총 연료 소모량 (L)
     */
    public int totalFuel(int totalDistance) {
        return totalDistance / this.fuelEfficiency;
    }

    /**
     * 주유 횟수 계산
     *
     * @param totalFuel 총 연료 소모량 (L)
     * @return 주유 횟수
     */
    public int countRefuel(int totalFuel) {
        return (int) Math.ceil((double) totalFuel / this.fuelCapacity);
    }

    /**
     * 총 비용 계산
     *
     * @param totalFuel 총 연료 소모량 (L)
     * @return 총 비용 (원)
     */
    public int totalCost(double totalFuel) {
        return (int) Math.ceil(totalFuel * FUEL_PRICE);
    }

    /**
     * 총 이동 시간 계산
     *
     * @param distance         목적지까지의 거리 (km)
     * @param totalMovement    총 이동 횟수
     * @param weatherCondition 날씨 조건 ID
     * @return 총 이동 시간 (분)
     */
    public int totalTravelTime(int distance, int totalMovement, int weatherCondition) {
        return (int) Math.ceil(((double) distance / velocity)
                * totalMovement
                * WeatherCondition.getSpeedFactorById(weatherCondition)
                * HOUR_TO_MINUTE_CONVERT_FACTOR);
    }

    /**
     * 차량 이름 반환
     *
     * @return 차량 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 차량 모드 설정
     *
     * @param isOn 모드 상태 (on/off)
     */
    public abstract void setMode(boolean isOn); // 차량별 부과 기능 on/off
}
