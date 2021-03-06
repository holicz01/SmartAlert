package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragment;
import com.anonymus.smartalert.utils.MainBus;

public class VehicleQuestionFragment extends Fragment {

    Button a1;
    Button a2;
    Button a4;
    TextView a3;
    int i = 1;
    int max = 3;


    public VehicleQuestionFragment() {
        // Required empty public constructor
    }

    public static VehicleQuestionFragment newInstance() {
        Bundle args = new Bundle();
        VehicleQuestionFragment fragment = new VehicleQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vehical_question, container, false);
        a3 = (TextView) rootView.findViewById(R.id.a3);
        a3.setText("" + i + " / " + max);
        a1 = (Button) rootView.findViewById(R.id.a1);
        a4 = (Button) rootView.findViewById(R.id.a4);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                a3.setText("" + i + " / " + max);
                if (i == max) {
                    a1.setEnabled(false);
                    a4.setVisibility(View.VISIBLE);
                }
            }
        });

        a2 = (Button) rootView.findViewById(R.id.a2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (i >= 1) {

                    a1.setEnabled(true);
                    a4.setVisibility(View.GONE);
                    a3.setText("" + i + " / " + max);

                }
                if (i == 0) i = 1 ;
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragment(DashboardFragment.newInstance()));
            }
        });
        return rootView;
    }

    private void initInstances() {

    }
}
