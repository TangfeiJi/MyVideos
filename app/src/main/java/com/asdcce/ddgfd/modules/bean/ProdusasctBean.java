package com.asdcce.ddgfd.modules.bean;

import android.content.Context;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import java.io.Serializable;

public class ProdusasctBean implements Serializable {


    /**
     * id : 2
     * pname : test-product
     * logo : test.img
     * grade : 5.2
     * icon :
     * maximum_amount : 1000
     * min_algorithm : 0.100
     * interest_algorithm : 1
     * fastest_time : two minutes
     * introduction : Get cash loans in as little as one hour,100%online & bad credit od OK
     * link : test.com
     */


    private String id;
    private String pname;
    private String logo;
    private String grade;
    private String icon;
    private String maximum_amount;
    private String min_algorithm;
    private int interest_algorithm;
    private String fastest_time;
    private String introduction;
    private String link;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMaximum_amount() {
        return maximum_amount;
    }

    public void setMaximum_amount(String maximum_amount) {
        this.maximum_amount = maximum_amount;
    }

    public String getMin_algorithm() {
        return min_algorithm;
    }

    public void setMin_algorithm(String min_algorithm) {
        this.min_algorithm = min_algorithm;
    }

    public int getInterest_algorithm() {
        return interest_algorithm;
    }

    public void setInterest_algorithm(int interest_algorithm) {
        this.interest_algorithm = interest_algorithm;
    }

    public String getFastest_time() {
        return fastest_time;
    }

    public void setFastest_time(String fastest_time) {
        this.fastest_time = fastest_time;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
