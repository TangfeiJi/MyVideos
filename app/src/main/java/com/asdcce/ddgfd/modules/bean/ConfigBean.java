package com.asdcce.ddgfd.modules.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigBean {


    /**
     * domain : https://map.daiok.cn/
     * upload_domain : https://map.daiok.cn/upload/
     * share_domain :
     * maintenance : 2
     * maintenance_msg : 系统维护中
     * ele_save_rate : 180
     * version : 1.0.0
     * isForceUpdate : 0
     * updateMessage :
     * updateUrl :
     * position_save_rate : 10
     * switch : 1
     * area_code : ["001","0061","0044","0064"]
     */

    private String domain;
    private String upload_domain;
    private String share_domain;
    private int maintenance;
    private String maintenance_msg;
    private int ele_save_rate;
    private String version;
    private int isForceUpdate;
    private String updateMessage;
    private String updateUrl;
    private long position_save_rate;
    @SerializedName("switch")
    private String switchX;
    private List<String> area_code;

    public long getPosition_save_rate() {
        return position_save_rate;
    }

    public void setPosition_save_rate(long position_save_rate) {
        this.position_save_rate = position_save_rate;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUpload_domain() {
        return upload_domain;
    }

    public void setUpload_domain(String upload_domain) {
        this.upload_domain = upload_domain;
    }

    public String getShare_domain() {
        return share_domain;
    }

    public void setShare_domain(String share_domain) {
        this.share_domain = share_domain;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public String getMaintenance_msg() {
        return maintenance_msg;
    }

    public void setMaintenance_msg(String maintenance_msg) {
        this.maintenance_msg = maintenance_msg;
    }

    public int getEle_save_rate() {
        return ele_save_rate;
    }

    public void setEle_save_rate(int ele_save_rate) {
        this.ele_save_rate = ele_save_rate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getIsForceUpdate() {
        return isForceUpdate;
    }

    public void setIsForceUpdate(int isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }


    public String getSwitchX() {
        return switchX;
    }

    public void setSwitchX(String switchX) {
        this.switchX = switchX;
    }

    public List<String> getArea_code() {
        return area_code;
    }

    public void setArea_code(List<String> area_code) {
        this.area_code = area_code;
    }
}
