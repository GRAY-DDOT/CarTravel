package constansts;

public enum Destination {
    BUSAN(1, 400),
    DAEJEON(2, 150),
    GANGNEUNG(3, 200),
    GWANGJU(4, 300);

    private final int id;
    private final int distance;

    /**
     * 목적지 열거체 생성자
     *
     * @param id
     * @param distance
     */
    Destination(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    /**
     * 목적지 ID를 입력 받아 해당 목적지의 거리를 반환합니다.
     *
     * @param id
     * @return 목적지의 거리
     */
    public static int getDistanceById(int id) {
        for (Destination destination : Destination.values()) {
            if (destination.id == id) {
                return destination.distance;
            }
        }
        throw new IllegalArgumentException("Invalid destination ID: " + id);
    }
}
