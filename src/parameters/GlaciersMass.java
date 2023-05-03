package parameters;

public class GlaciersMass extends Parameter{

    public GlaciersMass() {
        super();
    }

    public GlaciersMass(int value, byte score, String description) {
        super(value, score, description);
    }

    @Override
    public String toString() {
        return "GlaciersMass{" +
                "value=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
