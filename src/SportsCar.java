import mode.AutoDrive;
import mode.Music;

public class SportsCar extends Car implements Music, AutoDrive {

    public SportsCar() {
        super(250, 8, 30, 2); // 기본 속도 250km/h, 연비 8km/L, 연료탱크 30L, 좌석 2석
        this.name = "포르쉐 911";

    }

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

    @Override
    public void autoDriveOn(boolean isOn) {
        if (isOn) System.out.println(this.name + ": 자율주행 ON");
        else System.out.println(this.name + ": 자율주행 OFF");
    }

    @Override
    public void musicOn(boolean isOn) {
        if (isOn) System.out.println(this.name + ": 오디오 ON");
        else System.out.println(this.name + ": 오디오 OFF");
    }
}
