package car;

import mode.Aircon;
import mode.AutoDrive;

public class Bus extends Car implements Aircon, AutoDrive {

    int region, passenger, weather;

    public void setRegion(int region) {
        this.region = region;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }


    // 버스 속성값 정의
    private static int velocity = 150;    //속도
    private static int fuelEfficiency = 5;  //연비
    private static int fuelCapacity = 100;    //
    private static int seatsNumber = 20;

    //    public car.Car(int velocity, int fuelEfficiency, int fuelCapacity, int seatsNumber) {
    public Bus(String name) {
        // 고정값을 부모 생성자에 전달
        super(velocity, fuelEfficiency, fuelCapacity, seatsNumber);
        this.name = name;
    }

    /**
     * 모드 설정 메소드
     *
     * @param isOn 모드 상태 (on/off)
     */
    @Override
    public void setMode(boolean isOn) {
        if (isOn) fuelCapacity += 30;
        this.isModeOn = isOn;
    }


    /**
     * 버스의 현재 속도를 반환하는 메소드
     *
     * @return 현재 속도
     */
    @Override
    public void airconOn(boolean isOn) {
        if (isOn) {
            System.out.println(this.name + ": 에어컨 ON");
        } else {
            System.out.println(this.name + ": 에어컨 OFF");
        }
    }

    /**
     * 자율주행 모드 설정 메소드
     *
     * @param isOn 자율주행 모드 상태 (on/off)
     */
    @Override
    public void autoDriveOn(boolean isOn) {
        if (isOn) System.out.println(this.name + ": 자율주행 ON");
        else System.out.println(this.name + ": 자율주행 OFF");
    }
}
