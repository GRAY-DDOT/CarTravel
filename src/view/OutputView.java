package view;

public class OutputView {
public final String LINE_1_START = "======= ";
public final String LINE_1_END = " =======";
public final String LINE_2_START = "총 비용 : ";
public final String LINE_2_END = "원";
public final String LINE_3_START = "총 주유 횟수 : ";
public final String LINE_3_END = "회";
public final String LINE_4_START = "총 이동 시간 : ";
public final String LINE_4_HOUR = "시간 ";
public final String LINE_4_MINUTE = "분";
    public void printResult(String carName,int totalCost, int totalRefuel, int totalTravelTime) {
        System.out.println();
        System.out.println(LINE_1_START + carName + LINE_1_END);
        System.out.println(LINE_2_START + totalCost + LINE_2_END);
        System.out.println(LINE_3_START + totalRefuel + LINE_3_END);
        System.out.println(LINE_4_START +
                totalTravelTime / 60 + LINE_4_HOUR +
                totalTravelTime % 60 + LINE_4_MINUTE);
        System.out.println(LINE_1_START + "=======" + LINE_1_END);
    }

//    public void printResult(String name, boolean isModeOn, int totalCost, int totalRefuel, int totalTravelTime) {
//
//    }


//    총 비용 : 1,100,000원
//    총 주유 횟수 : 19회
//    총 이동 시간 : 14시간 40분
}
