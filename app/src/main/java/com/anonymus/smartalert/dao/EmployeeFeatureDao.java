package com.anonymus.smartalert.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by holicz01 on 7/24/2017 AD.
 */

public class EmployeeFeatureDao {
    @SerializedName("type")
    String type;
    @SerializedName("geometry")
    String geometry;

    @SerializedName("properties")
   EmployeeFeatureProperties employeeFeatureDao;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public EmployeeFeatureProperties getEmployeeFeatureDao() {
        return employeeFeatureDao;
    }

    public void setEmployeeFeatureDao(EmployeeFeatureProperties employeeFeatureDao) {
        this.employeeFeatureDao = employeeFeatureDao;
    }
}
