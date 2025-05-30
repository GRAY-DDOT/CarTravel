package mode;

public interface Music {
    default String getModeMessageWhenModeOn(String carName, boolean isOn) {
        if (isOn) {
            return carName + ": 오디오 ON";
        } else {
            return carName + ": 오디오 OFF";
        }
    }
}
