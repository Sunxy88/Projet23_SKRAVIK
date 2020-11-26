package fr.imtatlantique.projet23.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Data {

    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss", timezone = "CET")
    private Date date;

    private Double latitude;

    private Double longitude;

    private Double surfSpeed;

    private Double speedOverGnd;

    private Double surfHeading;

    private Double headingOverGround;

    private Double loch;

    private Double depth;

    private Double aws;

    private Double tws;

    private Double twd;

    private Double airTempearture;

    private Double pression;

    private Double humidity;

    private Double sunPower;

    private Double waterTemperature;

    private Double salinity;

    private Double o2Conc;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getSurfSpeed() {
        return surfSpeed;
    }

    public void setSurfSpeed(Double surfSpeed) {
        this.surfSpeed = surfSpeed;
    }

    public Double getSpeedOverGnd() {
        return speedOverGnd;
    }

    public void setSpeedOverGnd(Double speedOverGnd) {
        this.speedOverGnd = speedOverGnd;
    }

    public Double getSurfHeading() {
        return surfHeading;
    }

    public void setSurfHeading(Double surfHeading) {
        this.surfHeading = surfHeading;
    }

    public Double getHeadingOverGround() {
        return headingOverGround;
    }

    public void setHeadingOverGround(Double headingOverGround) {
        this.headingOverGround = headingOverGround;
    }

    public Double getLoch() {
        return loch;
    }

    public void setLoch(Double loch) {
        this.loch = loch;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getAws() {
        return aws;
    }

    public void setAws(Double aws) {
        this.aws = aws;
    }

    public Double getTws() {
        return tws;
    }

    public void setTws(Double tws) {
        this.tws = tws;
    }

    public Double getTwd() {
        return twd;
    }

    public void setTwd(Double twd) {
        this.twd = twd;
    }

    public Double getAirTempearture() {
        return airTempearture;
    }

    public void setAirTempearture(Double airTempearture) {
        this.airTempearture = airTempearture;
    }

    public Double getPression() {
        return pression;
    }

    public void setPression(Double pression) {
        this.pression = pression;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSunPower() {
        return sunPower;
    }

    public void setSunPower(Double sunPower) {
        this.sunPower = sunPower;
    }

    public Double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public Double getSalinity() {
        return salinity;
    }

    public void setSalinity(Double salinity) {
        this.salinity = salinity;
    }

    public Double getO2Conc() {
        return o2Conc;
    }

    public void setO2Conc(Double o2Conc) {
        this.o2Conc = o2Conc;
    }

    @Override
    public String toString() {
        return "Data{" +
                "date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", surfSpeed=" + surfSpeed +
                ", speedOverGnd=" + speedOverGnd +
                ", surfHeading=" + surfHeading +
                ", headingOverGround=" + headingOverGround +
                ", loch=" + loch +
                ", depth=" + depth +
                ", aws=" + aws +
                ", tws=" + tws +
                ", twd=" + twd +
                ", airTempearture=" + airTempearture +
                ", pression=" + pression +
                ", humidity=" + humidity +
                ", sunPower=" + sunPower +
                ", waterTemperature=" + waterTemperature +
                ", salinity=" + salinity +
                ", o2Conc=" + o2Conc +
                '}';
    }
}
