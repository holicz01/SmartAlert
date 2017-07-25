package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

public class FirstAidFragment extends Fragment {


    public FirstAidFragment() {
        // Required empty public constructor
    }

    public static FirstAidFragment newInstance() {
        Bundle args = new Bundle();
        FirstAidFragment fragment = new FirstAidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_aid, container, false);

        LinearLayout a1;
        LinearLayout a2;


        a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        a2 = (LinearLayout) rootView.findViewById(R.id.a2);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FirstAidSelectFragment.newInstance("First And Kit")));
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(FirstAidSelectFragment.newInstance("Defibrillator")));
            }
        });


        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("First Aid"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("First Aid"));
    }
}
