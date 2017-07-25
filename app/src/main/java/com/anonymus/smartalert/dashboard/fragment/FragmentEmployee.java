package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

public class FragmentEmployee extends Fragment {


    public FragmentEmployee() {
        // Required empty public constructor
    }

    public static FragmentEmployee newInstance() {
        Bundle args = new Bundle();
        FragmentEmployee fragment = new FragmentEmployee();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        LinearLayout a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(Efragment.newInstance()));
            }
        });
        return rootView;
    }

    private void initInstances() {

    }
}
