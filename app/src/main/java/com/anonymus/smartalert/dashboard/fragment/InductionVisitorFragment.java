package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dialog.CallDialog;
import com.anonymus.smartalert.dialog.QrDialog;
import com.anonymus.smartalert.dialog.VisitorDialog;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class InductionVisitorFragment extends Fragment {

    VisitorDialog visitorDialog;
    QrDialog qrDialog;

    public InductionVisitorFragment() {
        // Required empty public constructor
    }

    public static InductionVisitorFragment newInstance() {
        Bundle args = new Bundle();
        InductionVisitorFragment fragment = new InductionVisitorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_induction_visition, container, false);

        visitorDialog = VisitorDialog.newInstance();
        qrDialog = QrDialog.newInstance();

        ImageView a0  = (ImageView) rootView.findViewById(R.id.a0);

        a0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrDialog.show(getChildFragmentManager(),"qr");
            }
        });
        LinearLayout a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitorDialog.show(getChildFragmentManager(),"visitor");
            }
        });

        LinearLayout a2 = (LinearLayout) rootView.findViewById(R.id.a2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitorDialog.show(getChildFragmentManager(),"visitor");
            }
        });

        LinearLayout a3 = (LinearLayout) rootView.findViewById(R.id.a3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallDialog.newInstance().show(getChildFragmentManager(), "call");
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Visitor"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Visitor"));
    }


}
