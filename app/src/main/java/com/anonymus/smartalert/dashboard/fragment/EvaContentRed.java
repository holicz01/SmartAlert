package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dialog.EvaDailog;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class EvaContentRed extends Fragment {


    public EvaContentRed() {
        // Required empty public constructor
    }

    public static EvaContentRed newInstance() {
        Bundle args = new Bundle();
        EvaContentRed fragment = new EvaContentRed();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_eva_content, container, false);

        LinearLayout a0 = (LinearLayout) rootView.findViewById(R.id.a0);

        a0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaDailog.newInstance(R.drawable.ic_03).show(getChildFragmentManager(),"qr");
            }
        });
        LinearLayout a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaDailog.newInstance(R.drawable.ic_03).show(getChildFragmentManager(),"visitor");
            }
        });

        LinearLayout a2 = (LinearLayout) rootView.findViewById(R.id.a2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaDailog.newInstance(R.drawable.ic_03).show(getChildFragmentManager(),"visitor");
            }
        });

        LinearLayout a3 = (LinearLayout) rootView.findViewById(R.id.a3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvaDailog.newInstance(R.drawable.ic_03).show(getChildFragmentManager(), "call");
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Evacuation"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Evacuation"));
    }

}

