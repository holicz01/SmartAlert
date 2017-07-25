package com.anonymus.smartalert.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.anonymus.smartalert.R;

/**
 * Created by holicz01 on 6/24/2017 AD.
 */

public class EvaDailog extends android.support.v4.app.DialogFragment {

    private int id;

    public static EvaDailog newInstance(int id) {
        Bundle args = new Bundle();
        EvaDailog fragment = new EvaDailog();
        args.putInt("id",id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id =getArguments().getInt("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_eva, container, false);
        ImageView b1 = (ImageView) rootView.findViewById(R.id.btn01);
        ImageView b2  = (ImageView) rootView.findViewById(R.id.btn02);
        ImageView b3 = (ImageView) rootView.findViewById(R.id.btn03);

        switch (id)
        {
            case R.drawable.ic_01 : {
                b1.setBackgroundResource(id);
                break;
            }
            case R.drawable.ic_02 : {
                b2.setBackgroundResource(id);
                break;
            }
            case R.drawable.ic_03 : {
                b3.setBackgroundResource(id);
                break;
            }
        }
        return rootView;
    }
}
