package javabeans;

import parameters.*;

import java.io.Serializable;
import java.util.Date;

public class ClimateParameter implements Serializable {

    private long id;
    private String operatorNickname;
    private long areaOfInterest;
    private long date; // timestamp format
    private Wind wind; // (Km/h);
    private Humidity humidity;// (%)
    private Pression pression; // (hPa)
    private Temperature temperature; // (C°)
    private RainFall rainfall; // Precipitazioni (mm)
    private GlaciersAltitude glaciersAltitude; // Altitudine Ghiacciai (m)
    private GlaciersMass glaciersMass;// Massa dei Ghiacciai (Kg)

    public ClimateParameter() {
    }

    public ClimateParameter(long id, String operatorNickname, long areaOfInterest, long date,
                            Wind wind, Humidity humidity, Pression pression, Temperature temperature,
                            RainFall rainfall, GlaciersAltitude glaciersAltitude, GlaciersMass glaciersMass) {
        this.id = id;
        this.operatorNickname = operatorNickname;
        this.areaOfInterest = areaOfInterest;
        this.date = date;
        this.wind = wind;
        this.humidity = humidity;
        this.pression = pression;
        this.temperature = temperature;
        this.rainfall = rainfall;
        this.glaciersAltitude = glaciersAltitude;
        this.glaciersMass = glaciersMass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperatorNickname() {
        return operatorNickname;
    }

    public void setOperatorNickname(String operatorNickname) {
        this.operatorNickname = operatorNickname;
    }

    public long getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(long areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Pression getPression() {
        return pression;
    }

    public void setPression(Pression pression) {
        this.pression = pression;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public RainFall getRainfall() {
        return rainfall;
    }

    public void setRainfall(RainFall rainfall) {
        this.rainfall = rainfall;
    }

    public GlaciersAltitude getGlaciersAltitude() {
        return glaciersAltitude;
    }

    public void setGlaciersAltitude(GlaciersAltitude glaciersAltitude) {
        this.glaciersAltitude = glaciersAltitude;
    }

    public GlaciersMass getGlaciersMass() {
        return glaciersMass;
    }

    public void setGlaciersMass(GlaciersMass glaciersMass) {
        this.glaciersMass = glaciersMass;
    }

    @Override
    public String toString() {
        return "ClimateParameter{" +
                "id=" + id +
                ", operatorNickname='" + operatorNickname + '\'' +
                ", areaOfInterest=" + areaOfInterest +
                ", date=" + new Date(date) +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", pression=" + pression +
                ", temperature=" + temperature +
                ", rainfall=" + rainfall +
                ", glaciersAltitude=" + glaciersAltitude +
                ", glaciersMass=" + glaciersMass +
                '}';
    }
}

