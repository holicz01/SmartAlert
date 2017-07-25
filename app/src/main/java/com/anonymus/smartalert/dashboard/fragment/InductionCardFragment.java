package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class InductionCardFragment extends Fragment {

    RelativeLayout a1;

    public InductionCardFragment() {
        // Required empty public constructor
    }

    public static InductionCardFragment newInstance() {
        Bundle args = new Bundle();
        InductionCardFragment fragment = new InductionCardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_introduction_card, container, false);
         a1 = (RelativeLayout) rootView.findViewById(R.id.a1);
        RelativeLayout a5 ;
        RelativeLayout a6 ;
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(InductionCardSelectFragment.newInstance("#F85A4E",R.drawable.icon_error)));
            }
        });

        a5 = (RelativeLayout) rootView.findViewById(R.id.a5);
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(InductionCardSelectFragment.newInstance("#FCC438",R.drawable.icon_warn)));
            }
        });


        a6 = (RelativeLayout) rootView.findViewById(R.id.a6);
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(InductionCardSelectFragment.newInstance("#7AB648",R.drawable.icon_green)));
            }
        });


        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Induction Card"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Induction Card"));
    }
}
