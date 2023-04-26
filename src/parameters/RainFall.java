package parameters;

import java.io.Serializable;

public class RainFall implements Serializable {

    private int rainfall; // (Km/h);
    private byte score; // from 1 to 5
    private String description;

    public RainFall() {
    }

    public RainFall(int rainfall, byte score, String description) {
        this.rainfall = rainfall;
        this.score = score;
        this.description = description;
    }

    public int getRainfall() {
        return rainfall;
    }

    public void setRainfall(int rainfall) {
        this.rainfall = rainfall;
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
        return "RainFall{" +
                "rainfall=" + rainfall +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
