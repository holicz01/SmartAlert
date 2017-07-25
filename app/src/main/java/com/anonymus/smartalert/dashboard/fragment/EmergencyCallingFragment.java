package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class EmergencyCallingFragment extends Fragment implements View.OnClickListener {

    ImageView a1;
    ImageView a2;
    ImageView a3;
    ImageView a4;

    public EmergencyCallingFragment() {
        // Required empty public constructor
    }

    public static EmergencyCallingFragment newInstance() {
        Bundle args = new Bundle();
        EmergencyCallingFragment fragment = new EmergencyCallingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emergency_calling, container, false);
        a1 = (ImageView) rootView.findViewById(R.id.a1);
        a2 = (ImageView) rootView.findViewById(R.id.a2);
        a3 = (ImageView) rootView.findViewById(R.id.a3);
        a4 = (ImageView) rootView.findViewById(R.id.a4);

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        return rootView;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a1 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingMenuFragment.newInstance()));
                break;
            }
            case R.id.a2 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingMenuFragment.newInstance()));
                break;
            }
            case R.id.a3 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingMenuFragment.newInstance()));
                break;
            }case R.id.a4 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingMenuFragment.newInstance()));
                break;
            }

        }
    }
}
