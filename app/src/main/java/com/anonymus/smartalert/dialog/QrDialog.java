package com.anonymus.smartalert.dialog;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anonymus.smartalert.R;

/**
 * Created by holicz01 on 6/24/2017 AD.
 */

public class QrDialog extends android.support.v4.app.DialogFragment {

    public static QrDialog newInstance() {
        Bundle args = new Bundle();
        QrDialog fragment = new QrDialog();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diaglod_image_view, container, false);
        ImageView a1 = (ImageView) rootView.findViewById(R.id.a1);

        a1.setBackgroundResource(R.drawable.icon_qr);
        return rootView;
    }


}
