import mode.Aircon;
import mode.Music;

public class Sedan extends Car implements Aircon, Music {
    final private String NAME = "아우디 A8";
    public Sedan(int velocity, int fuelEfficiency, int fuelCapacity, int seatsNumber) {
        super( velocity, fuelEfficiency, fuelCapacity, seatsNumber);
        this.name = "Sedan";
    }

    @Override
    public void setMode(boolean isOn) {
        this.isModeOn = isOn;
    }


    @Override
    public String getModeMessageWhenModeOn(String carName, boolean isOn) {
        return Aircon.super.getModeMessageWhenModeOn(carName, isOn);
    }
}
