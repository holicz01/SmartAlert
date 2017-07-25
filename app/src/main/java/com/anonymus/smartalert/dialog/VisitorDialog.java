package com.anonymus.smartalert.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.anonymus.smartalert.R;

/**
 * Created by holicz01 on 6/24/2017 AD.
 */

public class VisitorDialog extends android.support.v4.app.DialogFragment {

    public static VisitorDialog newInstance() {
        Bundle args = new Bundle();
        VisitorDialog fragment = new VisitorDialog();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_visitor, container, false);
        ImageButton btn = (ImageButton) rootView.findViewById(R.id.btn);

        return rootView;
    }


}
