package view;

public class OutputView {
    private final int TIME_CONVERT_FACTOR = 60;
    private final String HEADER_START = "======= ";
    private final String HEADER_END = " =======";
    private final String COST_PREFIX = "총 비용 : ";
    private final String COST_SUFFIX = "원";
    private final String REFUEL_PREFIX = "총 주유 횟수 : ";
    private final String REFUEL_SUFFIX = "회";
    private final String TIME_PREFIX = "총 이동 시간 : ";
    private final String TIME_HOUR_SUFFIX = "시간 ";
    private final String TIME_MINUTE_SUFFIX = "분";


    /**
     * 결과 출력 메서드
     *
     * @param carName         차량 이름
     * @param totalCost       총 비용
     * @param totalRefuel     총 주유 횟수
     * @param totalTravelTime 총 이동 시간 (시, 분 단위)
     */
    public void printResult(String carName, int totalCost, int totalRefuel, int totalTravelTime) {
        System.out.println();
        System.out.println(formatHeader(carName));
        System.out.println(formatTotalCost(totalCost));
        System.out.println(formatTotalRefuel(totalRefuel));
        System.out.println(formatTotalTime(totalTravelTime));
        System.out.println(formatFooter());
    }

    private String formatFooter() {
        return formatHeader("=======");
    }

    private String formatTotalTime(int totalTravelTime) {
        return TIME_PREFIX
                + formatHour(totalTravelTime)
                + formatMinute(totalTravelTime);
    }

    private String formatMinute(int totalTravelTime) {
        return totalTravelTime % TIME_CONVERT_FACTOR + TIME_MINUTE_SUFFIX;
    }

    private String formatHour(int totalTravelTime) {
        return totalTravelTime / TIME_CONVERT_FACTOR + TIME_HOUR_SUFFIX;
    }

    private String formatTotalRefuel(int totalRefuel) {
        return REFUEL_PREFIX + totalRefuel + REFUEL_SUFFIX;
    }

    private String formatTotalCost(int totalCost) {
        return COST_PREFIX + String.format("%,d", totalCost) + COST_SUFFIX;
    }

    private String formatHeader(String carName) {
        return HEADER_START + carName + HEADER_END;
    }
}
