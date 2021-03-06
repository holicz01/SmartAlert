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

public class SiteFamiliarisationFragment extends Fragment {

    public SiteFamiliarisationFragment() {
        // Required empty public constructor
    }

    public static SiteFamiliarisationFragment newInstance() {
        Bundle args = new Bundle();
        SiteFamiliarisationFragment fragment = new SiteFamiliarisationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_site_familiarisation, container, false);

        LinearLayout a1;
        LinearLayout a2;


        a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        a2 = (LinearLayout) rootView.findViewById(R.id.a2);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(SiteFamiliarisationSelectFragment.newInstance()));
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(SiteFamiliarisationSelectFragment.newInstance()));
            }
        });

        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Site"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Site"));
    }
}
