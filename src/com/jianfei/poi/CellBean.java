package com.jianfei.poi;

public class CellBean {
    private String name;
    private String lat_gd;
    private String lng_gd;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat_gd() {
        return lat_gd;
    }

    public void setLat_gd(String lat_gd) {
        this.lat_gd = lat_gd;
    }

    public String getLng_gd() {
        return lng_gd;
    }

    public void setLng_gd(String lng_gd) {
        this.lng_gd = lng_gd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CellBean{" +
                "name='" + name + '\'' +
                ", lat_gd='" + lat_gd + '\'' +
                ", lng_gd='" + lng_gd + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
