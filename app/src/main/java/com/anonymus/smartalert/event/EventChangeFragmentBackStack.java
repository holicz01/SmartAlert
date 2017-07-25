package com.anonymus.smartalert.event;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by holicz01 on 6/18/2017 AD.
 */

public class EventChangeFragmentBackStack {
    private Fragment mTargetFragment;

    public EventChangeFragmentBackStack(Fragment mTargetFragment) {
        Log.d("error","error2");
        this.mTargetFragment = mTargetFragment;
    }

    public Fragment getmTargetFragment() {
        return mTargetFragment;
    }

    public void setmTargetFragment(Fragment mTargetFragment) {
        this.mTargetFragment = mTargetFragment;
    }
}
