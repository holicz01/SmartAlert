package com.anonymus.smartalert.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by holicz01 on 7/24/2017 AD.
 */

public class EmployeeDao {

    @SerializedName("type")
    String type;
    @SerializedName("crs")
    EmployeeCrsDao crs;
    @SerializedName("features")
    List<EmployeeFeatureDao> feature;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EmployeeCrsDao getCrs() {
        return crs;
    }

    public void setCrs(EmployeeCrsDao crs) {
        this.crs = crs;
    }

    public List<EmployeeFeatureDao> getFeature() {
        return feature;
    }

    public void setFeature(List<EmployeeFeatureDao> feature) {
        this.feature = feature;
    }
}
