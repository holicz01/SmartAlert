package com.anonymus.smartalert;


import android.os.Bundle;
import android.support.v4.app.Fragment;

public class FragmentTemplate extends Fragment {


    public FragmentTemplate() {
        // Required empty public constructor
    }

    public static FragmentTemplate newInstance() {
        Bundle args = new Bundle();
        FragmentTemplate fragment = new FragmentTemplate();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_mobile_verify_code, container, false);
//        ButterKnife.bind(this, rootView);
//        initInstances();
//        return rootView;
//    }

    private void initInstances() {

    }
}
