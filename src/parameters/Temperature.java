package parameters;

import java.io.Serializable;

public class Temperature implements Serializable {

    private int temperature; // (Km/h);
    private byte score; // from 1 to 5
    private String description;

    public Temperature() {
    }

    public Temperature(int temperature, byte score, String description) {
        this.temperature = temperature;
        this.score = score;
        this.description = description;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
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
        return "Temperature{" +
                "temperature=" + temperature +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
