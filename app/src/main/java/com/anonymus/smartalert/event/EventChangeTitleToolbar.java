package com.anonymus.smartalert.event;

/**
 * Created by holicz01 on 6/18/2017 AD.
 */

public class EventChangeTitleToolbar {
    private String mTitle;

    public EventChangeTitleToolbar(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
