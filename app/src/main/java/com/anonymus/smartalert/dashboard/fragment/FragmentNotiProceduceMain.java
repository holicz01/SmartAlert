package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.login.adapter.pager.LoginAdapter;
import com.anonymus.smartalert.login.fragment.LoginFragment;
import com.anonymus.smartalert.login.fragment.RegisterFragment;

public class FragmentNotiProceduceMain extends Fragment {

    LoginAdapter mLoginAdapter;
    TabLayout mTab;
    ViewPager mPager;

    public FragmentNotiProceduceMain() {
        // Required empty public constructor
    }

    public static FragmentNotiProceduceMain newInstance() {
        Bundle args = new Bundle();
        FragmentNotiProceduceMain fragment = new FragmentNotiProceduceMain();
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
        mLoginAdapter.addFrag(FragmentNotificationAcc.newInstance());
        mLoginAdapter.addFrag(FragmentNotiFloor.newInstance());
        mPager.setAdapter(mLoginAdapter);

        mTab = (TabLayout) rootView.findViewById(R.id.tab_login_main);
        mTab.setupWithViewPager(mPager);

        mTab.getTabAt(0).setText("Accountability");
        mTab.getTabAt(1).setText("Floor Plan");
    }


}
