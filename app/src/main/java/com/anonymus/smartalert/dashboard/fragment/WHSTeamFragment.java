package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class WHSTeamFragment extends Fragment implements View.OnClickListener {

    private Button mButtonMessage;
    private Button mButtonRepeat;
    private TextView mTextMenu;

    public WHSTeamFragment() {
        // Required empty public constructor
    }

    public static WHSTeamFragment newInstance() {
        Bundle args = new Bundle();
        WHSTeamFragment fragment = new WHSTeamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_whs_team, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        findView(rootView);
    }

    private void findView(View rootView) {
        mButtonMessage = (Button) rootView.findViewById(R.id.button_message);
        mButtonRepeat  = (Button) rootView.findViewById(R.id.button_repeat);
        mTextMenu      = (TextView) rootView.findViewById(R.id.text_menu);

        mButtonMessage.setOnClickListener(this);
        mButtonRepeat.setOnClickListener(this);
        mTextMenu.setOnClickListener(this);

    }



    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("WHS Team"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("WHS Team"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_message : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(WhsMainMessageFragment.newInstance()));
                break;
            }
            case R.id.button_repeat : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(HistoryFragment.newInstance()));
                break;
            }
            case R.id.text_menu : {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(WHSTeamSelectedFragment.newInstance()));
                break;
            }
        }
    }
}
