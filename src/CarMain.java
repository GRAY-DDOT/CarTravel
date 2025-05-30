import view.InputView;

public class CarMain {
    public static final String LINE_1_START = "=======";
    public static final String LINE_1_END = "=======";
    public static final String LINE_2_START = "총 비용 : ";
    public static final String LINE_2_END = "원";
    public static final String LINE_3_START = "총 주유 횟수 : ";
    public static final String LINE_3_END = "회";
    public static final String LINE_4_START = "총 이동 시간 : ";
    public static final String LINE_4_HOUR = "시간 ";
    public static final String LINE_4_MINUTE = "분";

    final static String INPUT_DESTINATION = "이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ";
    final static String INPUT_PASSENGERS = "이동할 승객 수 입력 : ";
    final static String INPUT_CAR_TYPE = "이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ";
    final static String INPUT_MODE = "부가 기능 [1]ON [2]OFF : ";
    final static String INPUT_WEATHER_CONDITION = "날씨 [1]맑음 [2]비 [3]눈 : ";
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int[] destinationDistances = {
                0, // 0 index is unused
                400, // 부산
                150, // 대전
                200, // 강릉
                300  // 광주
        };
        int[] weatherConditions = {
                0, // 0 index is unused
                1, // 맑음
                2, // 비
                3  // 눈
        };
        int destination = destinationDistances[inputView.getInt(INPUT_DESTINATION)];
        int passengers = inputView.getInt(INPUT_PASSENGERS);
        int carType = inputView.getInt(INPUT_CAR_TYPE);
        boolean isModeOn = inputView.getBoolean(INPUT_MODE);
        int weatherCondition = weatherConditions[inputView.getInt(INPUT_WEATHER_CONDITION)];

        System.out.println();

        Car car = selectCarImpl(carType, isModeOn);

        int totalMovement = car.totalMovement(passengers);
        int totalDistance = car.totalDistance(destination, totalMovement);
        double totalFuel = car.totalFuel(totalDistance);
        int totalRefuel = car.countRefuel(totalFuel);
        int totalCost = car.totalCost(totalFuel);
        int totalTravelTime = car.totalTravelTime(destination, totalMovement, weatherCondition);
        printResult(car.name, totalCost, totalRefuel, totalTravelTime);
    }

    public static void printResult(String carName,int totalCost, int totalRefuel, int totalTravelTime) {
        System.out.println("\n"+LINE_1_START + carName + LINE_1_END);
        System.out.println(LINE_2_START + totalCost + LINE_2_END);
        System.out.println(LINE_3_START + totalRefuel + LINE_3_END);
        System.out.println(LINE_4_START + (int) ((double) totalTravelTime / 60) + LINE_4_HOUR +
                totalTravelTime % 60 + LINE_4_MINUTE);
        System.out.println(LINE_1_START + " ======= " + LINE_1_END);
    }

    private static Car selectCarImpl(int carType, boolean isModeOn) {
        Car car;
        switch (carType) {
            case 1: // 스포츠카
                car = new SportsCar();
                car.setMode(isModeOn);
                return car;
            case 2: // 승용차
                car = new Sedan(isModeOn);
                return car;
            case 3: // 버스
                car = new Bus("타요");
                car.setMode(isModeOn);
                return car;
            default:
                System.out.println("잘못된 차량 선택입니다.");
                throw new IllegalArgumentException("Invalid car type selected.");
        }
    }

}
