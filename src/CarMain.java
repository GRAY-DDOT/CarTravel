import car.Bus;
import car.Car;
import car.Sedan;
import car.SportsCar;
import view.CarInputDTO;
import view.CarInputHandler;
import view.InputView;
import view.OutputView;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CarInputHandler inputHandler = new CarInputHandler(inputView);
        CarInputDTO inputDTO = inputHandler.collectInput();

        Car car = selectCarImpl(inputDTO.carType(), inputDTO.isModeOn());

        int totalMovement = car.totalMovement(inputDTO.passengers());
        int totalDistance = car.totalDistance(inputDTO.destination(), totalMovement);
        int totalFuel = car.totalFuel(totalDistance);
        int totalRefuel = car.countRefuel(totalFuel);
        int totalCost = car.totalCost(totalFuel);
        int totalTravelTime = car.totalTravelTime(inputDTO.destination(), totalMovement, inputDTO.weatherCondition());

        outputView.printResult(car.getName(), totalCost, totalRefuel, totalTravelTime);
    }

    /**
     * 차량 선택 및 모드 설정을 처리하는 메서드
     *
     * @param carType 차량 종류 (1: 스포츠카, 2: 승용차, 3: 버스)
     * @param isModeOn 모드 상태 (true: ON, false: OFF)
     * @return 선택된 차량 객체
     */
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
