package parameters;

import java.io.Serializable;

public class GlaciersAltitude implements Serializable {

    private int value; // (Km/h);
    private byte score; // from 1 to 5
    private String description;

    public GlaciersAltitude() {
    }

    public GlaciersAltitude(int value, byte score, String description) {
        this.value = value;
        this.score = score;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public byte getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GlaciersAltitude{" +
                "value=" + value +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
