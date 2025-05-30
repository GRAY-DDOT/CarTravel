package mode;

public interface Aircon {
    default String getModeMessageWhenModeOn(String carName, boolean isOn) {
        if (isOn) {
            return carName + ": 에어컨 ON";
        } else {
            return carName + ": 에어컨 OFF";
        }
    }
}
