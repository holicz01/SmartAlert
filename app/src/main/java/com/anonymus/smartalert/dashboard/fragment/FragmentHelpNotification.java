package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

public class FragmentHelpNotification extends Fragment  {


    public FragmentHelpNotification() {
        // Required empty public constructor
    }

    public static FragmentHelpNotification newInstance() {
        Bundle args = new Bundle();
        FragmentHelpNotification fragment = new FragmentHelpNotification();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification_help, container, false);

        initInstances();
        return rootView;
    }

    private void initInstances() {

    }


}
