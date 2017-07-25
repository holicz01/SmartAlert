package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dialog.ImageDialog;

public class FragmentNotiFloor extends Fragment  {


    public FragmentNotiFloor() {
        // Required empty public constructor
    }

    public static FragmentNotiFloor newInstance() {
        Bundle args = new Bundle();
        FragmentNotiFloor fragment = new FragmentNotiFloor();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notfi_floor, container, false);

        TextView a1 = (TextView) rootView.findViewById(R.id.a1);
        TextView a2 = (TextView) rootView.findViewById(R.id.a2);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageDialog.newInstance(R.drawable.d_01).show(getChildFragmentManager(), "im");
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageDialog.newInstance(R.drawable.d_01).show(getChildFragmentManager(), "im");
            }
        });

        initInstances();
        return rootView;
    }

    private void initInstances() {

    }


}
