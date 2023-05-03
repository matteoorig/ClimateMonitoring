package javabeans;

import java.io.Serializable;

public class Operator implements Serializable {


    private String nickname;
    private String name;
    private String surname;
    private String mail;
    private String fiscalCode;
    private String password;
    private String monitoringCenter;

    public Operator() {
    }

    public Operator(String nickname, String name, String surname, String mail, String fiscalCode,
                    String password, String monitoringCenter) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.fiscalCode = fiscalCode;
        this.password = password;
        this.monitoringCenter = monitoringCenter;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", fiscalCode='" + fiscalCode + '\'' +
                ", password='" + password + '\'' +
                ", monitoringCenter='" + monitoringCenter + '\'' +
                '}';
    }
}
