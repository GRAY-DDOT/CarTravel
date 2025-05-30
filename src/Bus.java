import mode.Aircon;
import mode.AutoDrive;
import mode.Music;
import view.OutputView;

public class Bus extends Car implements Aircon, AutoDrive {
//    OutputView outputView = new OutputView();

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
    private static int fuelEfficiency = 12;  //연비
    private static int fuelCapacity = 45;    //
    private static int seatsNumber = 20;

    //    public Car(int velocity, int fuelEfficiency, int fuelCapacity, int seatsNumber) {
    public Bus(String name) {
        // 고정값을 부모 생성자에 전달
        super(150, 12, fuelCapacity, 20);
        this.name =name;
    }

    @Override
    public void setMode(boolean isOn) {
        if(isOn) fuelCapacity += 30;
        this.isModeOn = isOn;
    }

    @Override
    public String getModeMessageWhenModeOn(String carName, boolean isOn) {
        return Aircon.super.getModeMessageWhenModeOn(carName, isOn)
                + "\n"
                + AutoDrive.super.getModeMessageWhenModeOn(carName, isOn);
    }

//    void viewBus(){
//        int tMovement = totalMovement(passenger);
//
//        outputView.printResult(name, Bus.totalCost, totalRefuel, totalTravelTime);
//        //String carName,int totalCost, int totalRefuel, double totalTravelTime
//    }


//    void viewBus(){
//        System.out.println("총 비용 : ");
//        System.out.println("총 주유 횟수 : " );
//        System.out.println("총 이동시간 : " );
//    }
}
