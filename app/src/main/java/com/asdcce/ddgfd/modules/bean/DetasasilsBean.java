package com.asdcce.ddgfd.modules.bean;

import android.content.Context;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

public class DetasasilsBean {
    /**
     * id : 2
     * pname : test-product
     * logo : test.img
     * minimum_amount : 100
     * maximum_amount : 1000
     * min_cycle : 7
     * max_cycle : 365
     * fastest_time : two minutes
     * explain : 1.Age range 18-50 years oid 2.Identity card #.Cell-phone number
     * link : test.com
     */

    private String id;
    private String pname;
    private String logo;
    private String minimum_amount;
    private String maximum_amount;
    private String min_cycle;
    private String max_cycle;
    private String fastest_time;
    private String explain;
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

    public String getMinimum_amount() {
        return minimum_amount;
    }

    public void setMinimum_amount(String minimum_amount) {
        this.minimum_amount = minimum_amount;
    }

    public String getMaximum_amount() {
        return maximum_amount;
    }

    public void setMaximum_amount(String maximum_amount) {
        this.maximum_amount = maximum_amount;
    }

    public String getMin_cycle() {
        return min_cycle;
    }

    public void setMin_cycle(String min_cycle) {
        this.min_cycle = min_cycle;
    }

    public String getMax_cycle() {
        return max_cycle;
    }

    public void setMax_cycle(String max_cycle) {
        this.max_cycle = max_cycle;
    }

    public String getFastest_time() {
        return fastest_time;
    }

    public void setFastest_time(String fastest_time) {
        this.fastest_time = fastest_time;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
