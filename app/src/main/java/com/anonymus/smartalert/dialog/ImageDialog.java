package com.anonymus.smartalert.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.bumptech.glide.Glide;

/**
 * Created by holicz01 on 6/24/2017 AD.
 */

public class ImageDialog extends android.support.v4.app.DialogFragment {

    int id ;
    public static ImageDialog newInstance(int id) {
        Bundle args = new Bundle();
        ImageDialog fragment = new ImageDialog();
        args.putInt("id",id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diaglod_image_view, container, false);
        ImageView a1 = (ImageView) rootView.findViewById(R.id.a1);

        Glide.with(this)
                .load(id)
                .into(a1);

        return rootView;
    }


}
