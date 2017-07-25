package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymus.smartalert.R;

public class H1Fragment extends Fragment {


    public H1Fragment() {
        // Required empty public constructor
    }

    public static H1Fragment newInstance() {
        Bundle args = new Bundle();
        H1Fragment fragment = new H1Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.h1, container, false);
        return rootView;
    }

    private void initInstances() {

    }
}
