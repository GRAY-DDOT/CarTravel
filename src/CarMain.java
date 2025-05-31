import constansts.Destination;
import view.InputView;
import view.OutputView;

public class CarMain {
    final static String INPUT_DESTINATION = "이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ";
    final static String INPUT_PASSENGERS = "이동할 승객 수 입력 : ";
    final static String INPUT_CAR_TYPE = "이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ";
    final static String INPUT_MODE = "부가 기능 [1]ON [2]OFF : ";
    final static String INPUT_WEATHER_CONDITION = "날씨 [1]맑음 [2]비 [3]눈 : ";
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int destination = Destination.getDistanceById(inputView.getInt(INPUT_DESTINATION));
        int passengers = inputView.getInt(INPUT_PASSENGERS);
        int carType = inputView.getInt(INPUT_CAR_TYPE);
        boolean isModeOn = inputView.getBoolean(INPUT_MODE);
        int weatherCondition = inputView.getInt(INPUT_WEATHER_CONDITION);

        Car car = selectCarImpl(carType, isModeOn);

        int totalMovement = car.totalMovement(passengers);
        int totalDistance = car.totalDistance(destination, totalMovement);
        double totalFuel = car.totalFuel(totalDistance);
        int totalRefuel = car.countRefuel(totalFuel);
        int totalCost = car.totalCost(totalFuel);
        int totalTravelTime = car.totalTravelTime(destination, totalMovement, weatherCondition);

        outputView.printResult(car.name, totalCost, totalRefuel, totalTravelTime);
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
