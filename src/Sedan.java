import mode.Aircon;
import mode.Music;

public class Sedan extends Car implements Aircon, Music {
    final static private String NAME = "아우디 A8";
    final static private int VELOCITY = 200; // 속도
    final static private int FUEL_EFFICIENCY = 12; // 연비
    final static private int FUEL_CAPACITY = 45; // 연료탱크 크기
    final static private int SEATS_NUMBER = 4; // 좌석 수
    final static private int MODE_ON_SEATS_NUMBER = 5; // 모드 상태 (on)
    //    - 연비: 12km/L
    //    - 속도: 200km/h
    //    - 연료탱크: 45L
    //    - 좌석: 4
    //    - 트렁크 좌석화 (좌석 1석 추가)
    public Sedan(boolean isModeOn) {
        super(VELOCITY, FUEL_EFFICIENCY, FUEL_CAPACITY, SEATS_NUMBER + (isModeOn ? MODE_ON_SEATS_NUMBER : SEATS_NUMBER));
        this.name = NAME;
        this.isModeOn = isModeOn;
    }

    @Override
    public void setMode(boolean isOn) {
        this.isModeOn = isOn;
    }


    @Override
    public String getModeMessageWhenModeOn(String carName, boolean isOn) {
        return Aircon.super.getModeMessageWhenModeOn(carName, isOn)
                + "\n"
                + Music.super.getModeMessageWhenModeOn(carName, isOn);
    }
}
