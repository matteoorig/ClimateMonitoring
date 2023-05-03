package parameters;

public class Wind extends Parameter {

    public Wind() {
        super();
    }

    public Wind(int wind, byte score, String description) {
        super(wind, score, description);
    }

    @Override
    public String toString() {
        return "Wind{" +
                "wind=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
