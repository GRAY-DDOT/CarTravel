package constansts;

public enum Destination {
    BUSAN(1, 400),
    DAEJEON(2, 150),
    GANGNEUNG(3, 200),
    GWANGJU(4, 300);

    private final int id;
    private final int distance;

    Destination(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public static int getDistanceById(int id) {
        for (Destination destination : Destination.values()) {
            if (destination.id == id) {
                return destination.distance;
            }
        }
        throw new IllegalArgumentException("Invalid destination ID: " + id);
    }
}
