package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class EmergencyCallingChooseFragment extends Fragment  {

    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;


    TextView tv1;

    public EmergencyCallingChooseFragment() {
        // Required empty public constructor
    }

    public static EmergencyCallingChooseFragment newInstance(String text1,String text2,String text3,String text4,String text5) {
        Bundle args = new Bundle();
        EmergencyCallingChooseFragment fragment = new EmergencyCallingChooseFragment();
        args.putString("text1",text1);
        args.putString("text2",text2);
        args.putString("text3",text3);
        args.putString("text4",text4);
        args.putString("text5",text5);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.text1 = getArguments().getString("text1");
        this.text2 = getArguments().getString("text2");
        this.text3 = getArguments().getString("text3");
        this.text4 = getArguments().getString("text4");
        this.text5 = getArguments().getString("text5");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emergency_calling_choose, container, false);
        edt1 = (EditText) rootView.findViewById(R.id.edt_1);
        edt2 = (EditText) rootView.findViewById(R.id.edt_2);
        edt3 = (EditText) rootView.findViewById(R.id.edt_3);
        edt4 = (EditText) rootView.findViewById(R.id.edt_4);

        tv1 = (TextView) rootView.findViewById(R.id.a1);

        tv1.setText(text5);

        edt1.setText(text1);
        edt2.setText(text2);
        edt3.setText(text3);
        edt4.setText(text4);

        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Emergency Calling"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Emergency Calling"));
    }


}
