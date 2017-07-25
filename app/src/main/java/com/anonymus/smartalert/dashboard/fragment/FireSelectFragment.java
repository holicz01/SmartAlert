package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

import org.w3c.dom.Text;

public class FireSelectFragment extends Fragment {

    String name;
    TextView t1;
    public FireSelectFragment() {
        // Required empty public constructor
    }

    public static FireSelectFragment newInstance(String name) {
        Bundle args = new Bundle();
        FireSelectFragment fragment = new FireSelectFragment();
        args.putString("name",name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fire_selected, container, false);

        t1 = (TextView) rootView.findViewById(R.id.t1);
        t1.setText(name);
        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Fire Extinguisher"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Fire Extinguisher"));
    }
}
