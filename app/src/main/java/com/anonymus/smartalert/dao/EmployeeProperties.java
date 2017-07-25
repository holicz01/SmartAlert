package com.anonymus.smartalert.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by holicz01 on 7/24/2017 AD.
 */

public class EmployeeProperties {
    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
