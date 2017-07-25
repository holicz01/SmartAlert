package com.anonymus.smartalert.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymus.smartalert.R;

/**
 * Created by holicz01 on 6/24/2017 AD.
 */

public class CallDialog extends android.support.v4.app.DialogFragment {

    public static CallDialog newInstance() {
        Bundle args = new Bundle();
        CallDialog fragment = new CallDialog();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_call, container, false);
        return rootView;
    }


}
