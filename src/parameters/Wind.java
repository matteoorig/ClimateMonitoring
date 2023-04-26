package parameters;

import java.io.Serializable;

public class Wind implements Serializable {

    private float wind; // (Km/h);
    private byte score; // from 1 to 5
    private String description;

    public Wind() {
    }

    public Wind(float wind, byte score, String description) {
        this.wind = wind;
        this.score = score;
        this.description = description;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
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
        return "Wind{" +
                "wind=" + wind +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
