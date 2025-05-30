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
    protected int velocity; // 속도
    protected int fuelEfficiency; // 연비
    protected int fuelCapacity; // 연료탱크 크기
    protected int seatsNumber; // 좌석 수
    protected boolean isModeOn; // 모드 상태 (on/off)
    protected String name; // 차량 이름

    public Car(int velocity, int fuelEfficiency, int fuelCapacity, int seatsNumber, String name) {
        this.velocity = velocity;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
        this.seatsNumber = seatsNumber;
        this.name = name;
    }



    public int totalMovement(int distance) {
        return distance / fuelEfficiency;
    }

    public int totalRefuel(int distance) {
        return (distance / fuelEfficiency + fuelCapacity - 1) / fuelCapacity;
    }

    public double totalCost(int distance, double fuelPrice) {
        return (distance / fuelEfficiency) * fuelPrice;
    }

    public double totalTravelTime(int distance) {
        return (double) distance / velocity;
    }
}
