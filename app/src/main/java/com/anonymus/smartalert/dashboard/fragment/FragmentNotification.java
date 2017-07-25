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

public class FragmentNotification extends Fragment implements View.OnClickListener {


    public FragmentNotification() {
        // Required empty public constructor
    }

    public static FragmentNotification newInstance() {
        Bundle args = new Bundle();
        FragmentNotification fragment = new FragmentNotification();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        Button a1 = (Button) rootView.findViewById(R.id.a1);
        Button a2 = (Button) rootView.findViewById(R.id.a2);

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        initInstances();
        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a1 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FragmentNotiProceduceMain.newInstance()));

                break;
            }
            case R.id.a2 : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FragmentHelpNotification.newInstance()));
                break;

            }
        }
    }
}
