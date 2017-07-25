package com.anonymus.smartalert.login.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dashboard.fragment.DashboardFragment;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.login.fragment.LoginFragment;
import com.anonymus.smartalert.login.fragment.LoginMainFragment;
import com.anonymus.smartalert.utils.MainBus;
import com.squareup.otto.Subscribe;


public class LoginActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_container, LoginMainFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().register(this);
    }

    @Subscribe
    public void onEventChangeFragmentBackStack(EventChangeFragmentBackStack data){
        fragmentManager.beginTransaction()
                .replace(R.id.content_container, data.getmTargetFragment())
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void onEventChangeTitleToolbar(EventChangeTitleToolbar data){
        //todo
    }
}
