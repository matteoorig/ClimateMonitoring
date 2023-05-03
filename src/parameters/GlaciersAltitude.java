package parameters;

public class GlaciersAltitude extends Parameter {

    public GlaciersAltitude() {
        super();
    }

    public GlaciersAltitude(int value, byte score, String description) {
        super(value, score, description);
    }

    @Override
    public String toString() {
        return "GlaciersAltitude{" +
                "value=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
