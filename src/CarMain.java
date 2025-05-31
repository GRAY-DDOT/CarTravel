import constansts.Destination;
import view.InputView;
import view.OutputView;

import static constansts.InputViewMessage.*;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int destination = Destination.getDistanceById(inputView.getInt(INPUT_DESTINATION));
        int passengers = inputView.getInt(INPUT_PASSENGERS);
        int carType = inputView.getInt(INPUT_CAR_TYPE);
        boolean isModeOn = inputView.getBoolean(INPUT_MODE);
        int weatherCondition = inputView.getInt(INPUT_WEATHER_CONDITION);

        Car car = selectCarImpl(result.carType(), result.isModeOn());

        int totalMovement = car.totalMovement(inputDTO.passengers());
        int totalDistance = car.totalDistance(inputDTO.destination(), totalMovement);
        int totalFuel = car.totalFuel(totalDistance);
        int totalRefuel = car.countRefuel(totalFuel);
        int totalCost = car.totalCost(totalFuel);
        int totalTravelTime = car.totalTravelTime(inputDTO.destination(), totalMovement, inputDTO.weatherCondition());

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
