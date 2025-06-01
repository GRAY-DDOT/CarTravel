package constansts;

public enum WeatherCondition {
    SUNNY(1, 1.0), // 맑음
    RAINY(2, 1.2), // 비
    SNOWY(3, 1.4); // 눈

    private final int id;
    private final double speedFactor;

    /**
     * WeatherCondition 생성자
     *
     * @param id 날씨 조건 ID
     * @param speedFactor 속도 계수
     */
    WeatherCondition(int id, double speedFactor) {
        this.id = id;
        this.speedFactor = speedFactor;
    }

    public int getId() {
        return id;
    }

    /**
     * 날씨 조건 ID에 해당하는 속도 계수를 반환
     *
     * @param id 날씨 조건 ID
     * @return 속도 계수
     */
    public static double getSpeedFactorById(int id) {
        for (WeatherCondition condition : WeatherCondition.values()) {
            if (condition.id == id) {
                return condition.speedFactor;
            }
        }
        throw new IllegalArgumentException("Invalid weather condition ID: " + id);
    }
}
