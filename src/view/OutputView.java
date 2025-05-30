package view;

public class OutputView {
final String LINE_1_START = "=======";
final String LINE_1_END = "=======";
final String LINE_2_START = "총 비용 : ";
final String LINE_2_END = "원";
final String LINE_3_START = "총 주유 횟수 : ";
final String LINE_3_END = "회";
final String LINE_4_START = "총 이동 시간 : ";
final String LINE_4_HOUR = "시간 ";
final String LINE_4_MINUTE = "분";

    public void printResult(String carName,int totalCost, int totalRefuel, double totalTravelTime) {

        System.out.println(LINE_1_START + carName + LINE_1_END);
        System.out.println(LINE_2_START + totalCost + LINE_2_END);
        System.out.println(LINE_3_START + totalRefuel + LINE_3_END);
        System.out.println(LINE_4_START + (int)totalTravelTime / 60 + LINE_4_HOUR +
                (int)totalTravelTime % 60 + LINE_4_MINUTE);
        System.out.println(LINE_1_START + " ======= " + LINE_1_END);
    }


//    총 비용 : 1,100,000원
//    총 주유 횟수 : 19회
//    총 이동 시간 : 14시간 40분
}
