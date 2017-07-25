package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymus.smartalert.R;

public class FragmentNotificationAcc extends Fragment  {


    public FragmentNotificationAcc() {
        // Required empty public constructor
    }

    public static FragmentNotificationAcc newInstance() {
        Bundle args = new Bundle();
        FragmentNotificationAcc fragment = new FragmentNotificationAcc();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_acounttabiluty, container, false);

        initInstances();
        return rootView;
    }

    private void initInstances() {

    }


}
