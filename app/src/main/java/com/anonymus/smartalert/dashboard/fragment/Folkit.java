package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymus.smartalert.R;

public class Folkit extends Fragment {


    public Folkit() {
        // Required empty public constructor
    }

    public static Folkit newInstance() {
        Bundle args = new Bundle();
        Folkit fragment = new Folkit();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_safe_equi_select_floklift, container, false);
        initInstances();
        return rootView;
    }

    private void initInstances() {

    }
}
