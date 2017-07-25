package com.anonymus.smartalert.dashboard.fragment;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.acker.simplezxing.activity.CaptureActivity;
import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dashboard.activty.Scan;
import com.anonymus.smartalert.event.EventChangeFragment;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;


public class BarcodeScaner extends Fragment {

    private static final int REQ_CODE_PERMISSION = 0x1111;
    RelativeLayout mViewGroup;
    ImageButton btn;

    public BarcodeScaner() {
        // Required empty public constructor
    }

    public static BarcodeScaner newInstance() {
        Bundle args = new Bundle();
        BarcodeScaner fragment = new BarcodeScaner();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_safe_equi_select_floklift, container, false);
        mViewGroup = (RelativeLayout) rootView.findViewById(R.id.view_group);

        btn = (ImageButton) rootView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragment(FragmentSafe.newInstance()));
            }
        });
        mViewGroup.setVisibility(View.GONE);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Do not have the permission of camera, request it.
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQ_CODE_PERMISSION);
        } else {
            // Have gotten the permission
            startCaptureActivityForResult();
        }

        return rootView;
    }


    private void startCaptureActivityForResult() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(CaptureActivity.KEY_NEED_BEEP, CaptureActivity.VALUE_BEEP);
        bundle.putBoolean(CaptureActivity.KEY_NEED_VIBRATION, CaptureActivity.VALUE_VIBRATION);
        bundle.putBoolean(CaptureActivity.KEY_NEED_EXPOSURE, CaptureActivity.VALUE_NO_EXPOSURE);
        bundle.putByte(CaptureActivity.KEY_FLASHLIGHT_MODE, CaptureActivity.VALUE_FLASHLIGHT_OFF);
        bundle.putByte(CaptureActivity.KEY_ORIENTATION_MODE, CaptureActivity.VALUE_ORIENTATION_AUTO);
        bundle.putBoolean(CaptureActivity.KEY_SCAN_AREA_FULL_SCREEN, CaptureActivity.VALUE_SCAN_AREA_FULL_SCREEN);
        bundle.putBoolean(CaptureActivity.KEY_NEED_SCAN_HINT_TEXT, CaptureActivity.VALUE_SCAN_HINT_TEXT);
        intent.putExtra(CaptureActivity.EXTRA_SETTING_BUNDLE, bundle);
        startActivityForResult(intent, CaptureActivity.REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // User agree the permission
                    startCaptureActivityForResult();
                } else {
                }
            }
            break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CaptureActivity.REQ_CODE:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        if (data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT).equals("1"))
                            mViewGroup.setVisibility(View.VISIBLE);
                        else{
                            MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(VehicleCheckFragment.newInstance()));
                            Log.d("2","2");
                        }
                        break;
                    case Activity.RESULT_CANCELED:
                        getFragmentManager().popBackStack();
                        break;
                }
                break;
        }
    }
}
