package com.anonymus.smartalert.login.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dashboard.fragment.EmergencyCallingFragment;
import com.anonymus.smartalert.dashboard.fragment.SiteFamiliarisationFragment;
import com.anonymus.smartalert.dashboard.fragment.WHSTeamFragment;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.login.adapter.pager.LoginAdapter;
import com.anonymus.smartalert.utils.MainBus;

public class LoginMainFragment extends Fragment {

    LoginAdapter mLoginAdapter;
    TabLayout mTab;
    ViewPager mPager;

    public LoginMainFragment() {
        // Required empty public constructor
    }

    public static LoginMainFragment newInstance() {
        Bundle args = new Bundle();
        LoginMainFragment fragment = new LoginMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        findView(rootView);
    }

    private void findView(View rootView){

        mLoginAdapter = new LoginAdapter(getChildFragmentManager());
        mPager = (ViewPager) rootView.findViewById(R.id.pager_login_main);
        mLoginAdapter.addFrag(LoginFragment.newInstance());
        mLoginAdapter.addFrag(RegisterFragment.newInstance());
        mPager.setAdapter(mLoginAdapter);

        mTab = (TabLayout) rootView.findViewById(R.id.tab_login_main);
        mTab.setupWithViewPager(mPager);

        mTab.getTabAt(0).setText("Login");
        mTab.getTabAt(1).setText("Register");
    }


}
