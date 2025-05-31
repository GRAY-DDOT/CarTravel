package car;

import mode.AutoDrive;
import mode.Music;

public class SportsCar extends Car implements Music, AutoDrive {

    /**
     * 스포츠카 클래스 생성자
     * 기본 속도 250km/h, 연비 8km/L, 연료탱크 30L, 좌석 2석으로 초기화
     */
    public SportsCar() {
        super(250, 8, 30, 2); // 기본 속도 250km/h, 연비 8km/L, 연료탱크 30L, 좌석 2석
        this.name = "포르쉐 911";

    }

    /**
     * 모드 상태에 따라 속도 조정 및 기능 활성화
     *
     * @param isOn 모드 상태 (true: on, false: off)
     */
    @Override
    public void setMode(boolean isOn) {
        this.isModeOn = isOn;
        if (isOn) {
            this.velocity = (int) (this.velocity * 1.2);
        } else {
            this.velocity = 250; // 기본 속도 복구
        }

        musicOn(isOn);
        autoDriveOn(isOn);
    }

    /**
     * 스포츠카의 현재 속도를 반환
     *
     * @return 현재 속도
     */
    @Override
    public void autoDriveOn(boolean isOn) {
        if (isOn) System.out.println(this.name + ": 자율주행 ON");
        else System.out.println(this.name + ": 자율주행 OFF");
    }

    /**
     * 음악 기능을 켜거나 끄는 메소드
     *
     * @param isOn 음악 상태 (true: ON, false: OFF)
     */
    @Override
    public void musicOn(boolean isOn) {
        if (isOn) System.out.println(this.name + ": 오디오 ON");
        else System.out.println(this.name + ": 오디오 OFF");
    }
}
