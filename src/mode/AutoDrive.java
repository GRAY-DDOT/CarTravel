package mode;

public interface AutoDrive {
    default String getModeMessageWhenModeOn(String carName, boolean isOn) {
        if (isOn) {
            return carName + ": 자율주행 ON";
        } else {
            return carName + ": 자율주행 OFF";
        }
    }
}
