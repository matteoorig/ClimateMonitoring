package parameters;

public class Temperature extends Parameter {

    public Temperature() {
        super();
    }

    public Temperature(int temperature, byte score, String description) {
        super(temperature, score, description);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "temperature=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
