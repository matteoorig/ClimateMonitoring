package parameters;

import java.io.Serializable;

public class Pression implements Serializable {

    private int pression; // (Km/h);
    private byte score; // from 1 to 5
    private String description;

    public Pression() {
    }

    public Pression(int pression, byte score, String description) {
        this.pression = pression;
        this.score = score;
        this.description = description;
    }

    public int getPression() {
        return pression;
    }

    public void setPression(int pression) {
        this.pression = pression;
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
        return "Pression{" +
                "pression=" + pression +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
