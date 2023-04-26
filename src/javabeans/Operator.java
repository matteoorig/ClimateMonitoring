package javabeans;

import java.io.Serializable;

public class Operator implements Serializable {

    private String nickname;
    private String password;
    private String monitoringCenter;

    public Operator(String column, String password, long[] longs) {
    }

    public Operator(String nickname, String password, String centroDiMonitoraggio) {
        this.nickname = nickname;
        this.password = password;
        this.monitoringCenter = centroDiMonitoraggio;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMonitoringCenter() {
        return monitoringCenter;
    }

    public void setMonitoringCenter(String monitoringCenter) {
        this.monitoringCenter = monitoringCenter;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", monitoring center=" + monitoringCenter +
                '}';
    }
}
