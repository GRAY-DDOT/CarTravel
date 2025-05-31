package car;

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
        setMode(isModeOn);
    }

    @Override
    public void setMode(boolean isOn) {
        this.isModeOn = isOn;
        if (isOn) {
            this.velocity = (int) (this.velocity * 1.1); // 모드 ON 시 속도 증가
            this.seatsNumber = MODE_ON_SEATS_NUMBER; // 좌석 수 증가
        } else {
            this.velocity = VELOCITY; // 기본 속도로 복구
            this.seatsNumber = SEATS_NUMBER; // 좌석 수 복구
        }
        airconOn(isOn);
        musicOn(isOn);
    }


    @Override
    public void airconOn(boolean isOn) {
        if (isOn) {
            System.out.println(this.name + ": 에어컨 ON");
        } else {
            System.out.println(this.name + ": 에어컨 OFF");
        }
    }

    @Override
    public void musicOn(boolean isOn) {
        if (isOn) {
            System.out.println(this.name + ": 오디오 ON");
        } else {
            System.out.println(this.name + ": 오디오 OFF");
        }
    }
}
