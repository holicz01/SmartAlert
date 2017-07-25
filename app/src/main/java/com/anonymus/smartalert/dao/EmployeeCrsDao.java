package com.anonymus.smartalert.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by holicz01 on 7/24/2017 AD.
 */

public class EmployeeCrsDao {
    @SerializedName("type")
    String type;
    @SerializedName("properties")
    EmployeeProperties employeeProperties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EmployeeProperties getEmployeeProperties() {
        return employeeProperties;
    }

    public void setEmployeeProperties(EmployeeProperties employeeProperties) {
        this.employeeProperties = employeeProperties;
    }
}
