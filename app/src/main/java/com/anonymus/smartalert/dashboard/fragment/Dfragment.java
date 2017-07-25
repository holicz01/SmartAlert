package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.network.HttpManager;
import com.anonymus.smartalert.utils.MainBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dfragment extends Fragment {


    public Dfragment() {
        // Required empty public constructor
    }

    public static Dfragment newInstance() {
        Bundle args = new Bundle();
        Dfragment fragment = new Dfragment();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.asd, container, false);
        initInstances();
        return rootView;
    }

    private void initInstances() {
        Call call = HttpManager.getInstance().getService().getData();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Toast.makeText(getContext(),"200",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
