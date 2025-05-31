// src/view/CarInputHandler.java
package view;

import constansts.Destination;

import static constansts.InputViewMessage.*;

public class CarInputHandler {
    private final InputView inputView;

    public CarInputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    /**
     * 자동차 처리를 위해 필요한 입력값을 수집
     *
     * @return CarInputDTO
     */
    public CarInputDTO collectInput() {
        int destination = Destination.getDistanceById(inputView.getInt(INPUT_DESTINATION_MSG));
        int passengers = inputView.getInt(INPUT_PASSENGERS_MSG);
        int carType = inputView.getInt(INPUT_CAR_TYPE_MSG);
        boolean isModeOn = inputView.getBoolean(INPUT_MODE_MSG);
        int weatherCondition = inputView.getInt(INPUT_WEATHER_CONDITION_MSG);

        return new CarInputDTO(destination, passengers, carType, isModeOn, weatherCondition);
    }
}
