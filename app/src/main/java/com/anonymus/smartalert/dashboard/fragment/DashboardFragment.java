package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private ImageView mMenu1;
    private ImageView mMenu2;
    private ImageView mMenu3;
    private ImageView mMenu4;
    private ImageView mMenu5;
    private ImageView mMenu6;
    private ImageView mMenu7;
    private ImageView mMenu8;
    private ImageView mMenu9;
    private ImageView mMenu10;


    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        Bundle args = new Bundle();
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        mMenu1 = (ImageView) rootView.findViewById(R.id.image_menu_1);
        mMenu2 = (ImageView) rootView.findViewById(R.id.image_menu_2);
        mMenu3 = (ImageView) rootView.findViewById(R.id.image_menu_3);
        mMenu4 = (ImageView) rootView.findViewById(R.id.image_menu_4);
        mMenu5 = (ImageView) rootView.findViewById(R.id.image_menu_5);
        mMenu6 = (ImageView) rootView.findViewById(R.id.image_menu_6);
        mMenu7 = (ImageView) rootView.findViewById(R.id.image_menu_7);
        mMenu8 = (ImageView) rootView.findViewById(R.id.image_menu_8);
        mMenu9 = (ImageView) rootView.findViewById(R.id.image_menu_9);
        mMenu10 = (ImageView) rootView.findViewById(R.id.image_menu_10);

        mMenu1.setOnClickListener(this);
        mMenu2.setOnClickListener(this);
        mMenu3.setOnClickListener(this);
        mMenu4.setOnClickListener(this);
        mMenu5.setOnClickListener(this);
        mMenu6.setOnClickListener(this);
        mMenu7.setOnClickListener(this);
        mMenu8.setOnClickListener(this);
        mMenu9.setOnClickListener(this);
        mMenu10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_menu_1: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(SiteFamiliarisationFragment.newInstance()));
                break;
            }
            case R.id.image_menu_2: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(InductionFragment.newInstance()));
                break;
            }
            case R.id.image_menu_3: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(WHSTeamFragment.newInstance()));

                break;
            }
            case R.id.image_menu_4: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FragmentEva.newInstance()));
                break;
            }
            case R.id.image_menu_5: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(EmergencyCallingFragment.newInstance()));
                break;
            }
            case R.id.image_menu_6: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FirstAidFragment.newInstance()));
                break;
            }
            case R.id.image_menu_7: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FireFragment.newInstance()));
                break;
            }
            case R.id.image_menu_8: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FragmentSafe.newInstance()));
                break;
            }
            case R.id.image_menu_9: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(HRFragment.newInstance()));
                break;
            }
            case R.id.image_menu_10: {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(WorkAndSafetyFragment.newInstance()));
                break;
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Home"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Home"));
    }
}
