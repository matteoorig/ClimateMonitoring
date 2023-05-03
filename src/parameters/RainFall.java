package parameters;

public class RainFall extends Parameter {

    public RainFall() {
    }

    public RainFall(int rainfall, byte score, String description) {
        super(rainfall, score, description);
    }

    @Override
    public String toString() {
        return "RainFall{" +
                "rainfall=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
