package com.anonymus.smartalert.event;

import android.support.v4.app.Fragment;

/**
 * Created by holicz01 on 6/18/2017 AD.
 */

public class EventChangeFragment {
    private Fragment mTargetFragment;

    public EventChangeFragment(Fragment mTargetFragment) {
        this.mTargetFragment = mTargetFragment;
    }

    public Fragment getmTargetFragment() {
        return mTargetFragment;
    }

    public void setmTargetFragment(Fragment mTargetFragment) {
        this.mTargetFragment = mTargetFragment;
    }
}
