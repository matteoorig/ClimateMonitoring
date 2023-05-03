package parameters;

public abstract class Parameter {

    private int value;
    private byte score;
    private String description;

    public Parameter() {
    }

    public Parameter(int value, byte score, String description) {
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

}



