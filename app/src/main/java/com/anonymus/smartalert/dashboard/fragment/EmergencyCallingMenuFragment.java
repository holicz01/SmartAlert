package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class EmergencyCallingMenuFragment extends Fragment implements View.OnClickListener {

    public EmergencyCallingMenuFragment() {
        // Required empty public constructor
    }

    public static EmergencyCallingMenuFragment newInstance() {
        Bundle args = new Bundle();
        EmergencyCallingMenuFragment fragment = new EmergencyCallingMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emergency_calling_menu, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {

        Button a1 = (Button) rootView.findViewById(R.id.btn_1);
        Button a2 = (Button) rootView.findViewById(R.id.btn_2);
        Button a3 = (Button) rootView.findViewById(R.id.btn_3);
        Button a4 = (Button) rootView.findViewById(R.id.btn_4);

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingChooseFragment.newInstance("Location","Description","Comment","Number of Person Effect","Fire Calling Report")));
                break;
            }
            case R.id.btn_2 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingChooseFragment.newInstance("Location","Description","Comment","Number of Person Effect Person Effect","Ambulance Calling Report")));
                break;
            }
            case R.id.btn_3 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingChooseFragment.newInstance("Location","Description","Comment","Number of Person Effect","Police Calling Report")));
                break;
            }case R.id.btn_4 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingChooseFragment.newInstance("Location","Description","Comment","Number of Person Effect","Security Calling Report")));
                break;
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Emergency Calling"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Emergency Calling"));
    }
}
