package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class FireFragment extends Fragment {


    public FireFragment() {
        // Required empty public constructor
    }

    public static FireFragment newInstance() {
        Bundle args = new Bundle();
        FireFragment fragment = new FireFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fire, container, false);

        LinearLayout a1;
        LinearLayout a2;
        LinearLayout a3;


        a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        a2 = (LinearLayout) rootView.findViewById(R.id.a2);
        a3 = (LinearLayout) rootView.findViewById(R.id.a3);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FireSelectFragment.newInstance("Powder ABE")));
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FireSelectFragment.newInstance("Foam")));
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FireSelectFragment.newInstance("Powder BE")));
            }
        });
        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Fire Extinguisher"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Fire Extinguisher"));
    }
}
