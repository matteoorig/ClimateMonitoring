package parameters;

public class Humidity extends Parameter {

    public Humidity() {
        super();
    }

    public Humidity(int value, byte score, String description) {
        super(value, score, description);
    }

    @Override
    public String toString() {
        return "Humidity{" +
                "humidity=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
