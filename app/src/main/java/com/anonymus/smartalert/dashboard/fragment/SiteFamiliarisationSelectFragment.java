package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dialog.ImageDialog;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;
import com.bumptech.glide.Glide;

public class SiteFamiliarisationSelectFragment extends Fragment implements View.OnClickListener {

    public SiteFamiliarisationSelectFragment() {
        // Required empty public constructor
    }

    public static SiteFamiliarisationSelectFragment newInstance() {
        Bundle args = new Bundle();
        SiteFamiliarisationSelectFragment fragment = new SiteFamiliarisationSelectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_site_select, container, false);
        ImageView a1 = (ImageView) rootView.findViewById(R.id.a1);
        ImageView a2 = (ImageView) rootView.findViewById(R.id.a2);
        ImageView a3 = (ImageView) rootView.findViewById(R.id.a3);
        ImageView a4 = (ImageView) rootView.findViewById(R.id.a4);
        ImageView a5 = (ImageView) rootView.findViewById(R.id.a5);
        ImageView a6 = (ImageView) rootView.findViewById(R.id.a6);
        ImageView a7 = (ImageView) rootView.findViewById(R.id.a7);
        ImageView a8 = (ImageView) rootView.findViewById(R.id.a8);
        ImageView a9 = (ImageView) rootView.findViewById(R.id.a9);
        ImageView a10 = (ImageView) rootView.findViewById(R.id.a10);
        ImageView a11 = (ImageView) rootView.findViewById(R.id.a11);
        ImageView a12 = (ImageView) rootView.findViewById(R.id.a12);
        ImageView all = (ImageView) rootView.findViewById(R.id.all);

        Glide.with(this)
                .load(R.drawable.all)
                .into(all);

        Glide.with(this)
                .load(R.drawable.d_01)
                .into(a1);

        Glide.with(this)
                .load(R.drawable.d_02)
                .into(a2);

        Glide.with(this)
                .load(R.drawable.d_03)
                .into(a3);


        Glide.with(this)
                .load(R.drawable.d_04)
                .into(a4);

        Glide.with(this)
                .load(R.drawable.d_05)
                .into(a5);

        Glide.with(this)
                .load(R.drawable.d_06)
                .into(a6);

        Glide.with(this)
                .load(R.drawable.d_07)
                .into(a7);

        Glide.with(this)
                .load(R.drawable.d_08)
                .into(a8);

        Glide.with(this)
                .load(R.drawable.d_09)
                .into(a9);

        Glide.with(this)
                .load(R.drawable.d_10)
                .into(a10);

        Glide.with(this)
                .load(R.drawable.d_11)
                .into(a11);

        Glide.with(this)
                .load(R.drawable.d_12)
                .into(a12);


        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        a5.setOnClickListener(this);
        a6.setOnClickListener(this);
        a7.setOnClickListener(this);
        a8.setOnClickListener(this);
        a9.setOnClickListener(this);
        a10.setOnClickListener(this);
        a11.setOnClickListener(this);
        a12.setOnClickListener(this);

        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Site"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Site"));
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.a1 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_01);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a2 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_02);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a3 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_03);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a4 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_04);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a5 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_05);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a6 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_06);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a7 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_07);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a8: {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_08);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a9 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_09);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a10 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_10);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a11 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_11);
               im.show(getFragmentManager(), "image");
               break;
           }
           case R.id.a12 : {
               ImageDialog im = ImageDialog.newInstance(R.drawable.d_12);
               im.show(getFragmentManager(), "image");
               break;
           }

       }
    }
}

