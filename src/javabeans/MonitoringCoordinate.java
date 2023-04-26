package javabeans;

import java.io.Serializable;

public class MonitoringCoordinate implements Serializable {

    private long geonameId;
    private double latitude;
    private double longitude;
    private String danomination;
    private String countryCode;

    public MonitoringCoordinate() {
    }

    public MonitoringCoordinate(long geonameId, double latitude, double longitude, String danomination, String countryCode) {
        this.geonameId = geonameId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.danomination = danomination;
        this.countryCode = countryCode;
    }

    public long getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(long geonameId) {
        this.geonameId = geonameId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDanomination() {
        return danomination;
    }

    public void setDanomination(String danomination) {
        this.danomination = danomination;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "MonitoringCoordinate{" +
                "geonameId=" + geonameId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", danomination='" + danomination + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
