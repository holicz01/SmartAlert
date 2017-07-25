package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskObserverFragment extends Fragment {

    @BindView(R.id.btn_start)
    Button btn_start;
    public TaskObserverFragment() {
        // Required empty public constructor
    }

    public static TaskObserverFragment newInstance() {
        Bundle args = new Bundle();
        TaskObserverFragment fragment = new TaskObserverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_task, container, false);
        ButterKnife.bind(this,rootView);
        initInstances();
        return rootView;
    }

    private void initInstances() {
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(TaskObserverQuestionFragment.newInstance()));
            }
        });
    }
}
