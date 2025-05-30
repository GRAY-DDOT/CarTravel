import view.InputView;
import view.OutputView;

public class CarMain {
    final static String INPUT_DESTINATION = "이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 :";
    final static String INPUT_PASSENGERS = "이동할 승객 수 입력 : ";
    final static String INPUT_CAR_TYPE = "이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ";
    final static String INPUT_MODE = "부가 기능 [1]ON [2]OFF : ";
    final static String INPUT_WEATHER_CONDITION = "날씨 [1]맑음 [2]비 [3]눈 : \n";
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int destination = inputView.getInt(INPUT_DESTINATION);
        int passengers = inputView.getInt(INPUT_PASSENGERS);
        int carType = inputView.getInt(INPUT_CAR_TYPE);
        boolean isModeOn = inputView.getBoolean(INPUT_MODE);
        int weatherCondition = inputView.getInt(INPUT_WEATHER_CONDITION);
        Car car = null;
        switch (carType) {
            case 1: // 스포츠카
//                car = new SportsCar(isModeOn);
                break;
            case 2: // 승용차
                car = new Sedan(isModeOn);
                break;
            case 3: // 버스
//                car = new Bus(isModeOn);
                break;
            default:
                System.out.println("잘못된 차량 선택입니다.");
                return;
        }

    }

}
