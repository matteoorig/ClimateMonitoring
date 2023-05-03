package parameters;


public class Pression extends Parameter {

    public Pression() {
        super();
    }

    public Pression(int pression, byte score, String description) {
        super(pression, score, description);
    }

    @Override
    public String toString() {
        return "Pression{" +
                "pression=" + getValue() +
                ", score=" + getScore() +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
