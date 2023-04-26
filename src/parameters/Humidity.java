package parameters;

import java.io.Serializable;

public class Humidity implements Serializable {
    private int humidity; // (Km/h);
    private byte score; // from 1 to 5
    private String description;

    public Humidity() {
    }

    public Humidity(int humidity, byte score, String description) {
        this.humidity = humidity;
        this.score = score;
        this.description = description;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
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
        return "Humidity{" +
                "humidity=" + humidity +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
