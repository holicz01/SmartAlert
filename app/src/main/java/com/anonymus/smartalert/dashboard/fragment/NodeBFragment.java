package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragment;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

public class NodeBFragment extends Fragment {


    public NodeBFragment() {
        // Required empty public constructor
    }

    public static NodeBFragment newInstance() {
        Bundle args = new Bundle();
        NodeBFragment fragment = new NodeBFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_node_b, container, false);
        TextView a2 = (TextView) rootView.findViewById(R.id.a2);
        TextView a3 = (TextView) rootView.findViewById(R.id.a3);
        TextView a1 = (TextView) rootView.findViewById(R.id.a1);

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(VehicleCheckFragment.newInstance()));
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(H1Fragment.newInstance()));

            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(TaskObserverFragment.newInstance()));
            }
        });
        initInstances();
        return rootView;
    }

    private void initInstances() {

    }
}
