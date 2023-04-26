package javabeans;

import java.io.Serializable;
import java.util.Arrays;

public class MonitoringCenter implements Serializable {

    private String name;
    private String address;
    private long[] areaList;

    public MonitoringCenter() {
    }

    public MonitoringCenter(String name, String address, long[] areaList) {
        this.name = name;
        this.address = address;
        this.areaList = areaList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long[] getAreaList() {
        return areaList;
    }

    public void setAreaList(long[] areaList) {
        this.areaList = areaList;
    }

    @Override
    public String toString() {
        return "MonitoringCenter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", areaList=" + Arrays.toString(areaList) +
                '}';
    }
}
