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

public class FragmentSafe extends Fragment {


    public FragmentSafe() {
        // Required empty public constructor
    }

    public static FragmentSafe newInstance() {
        Bundle args = new Bundle();
        FragmentSafe fragment = new FragmentSafe();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_safe_compliance, container, false);

        LinearLayout a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        LinearLayout a2 = (LinearLayout) rootView.findViewById(R.id.a2);
        LinearLayout a10 = (LinearLayout) rootView.findViewById(R.id.a10);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(HRFragment.newInstance()));
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(BarcodeScaner.newInstance()));
            }
        });

        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(NodeBFragment.newInstance()));
            }
        });




        return rootView;
    }

    private void initInstances() {

    }
}
