package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dao.EmployeeDao;
import com.anonymus.smartalert.dao.EmployeeFeatureProperties;
import com.anonymus.smartalert.network.HttpManager;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Efragment extends Fragment {

    @BindView(R.id.emp_no)
    TextView empNo;
    @BindView(R.id.emp_mobile)
    TextView empMobile;
    @BindView(R.id.emp_telephone)
    TextView empTelephone;
    @BindView(R.id.emp_address)
    TextView empAddress;
    @BindView(R.id.emp_email)
    TextView empEmail;
    @BindView(R.id.emp_working_email)
    TextView empWorkingEmail;
    @BindView(R.id.first_emp_name)
    TextView firstEmpName;
    @BindView(R.id.first_emp_relation)
    TextView firstEmpPostion;
    @BindView(R.id.first_emp_email)
    TextView firstEmpEmail;
    @BindView(R.id.frist_emp_home_phone)
    TextView firstEmpHomePhone;
    @BindView(R.id.frist_emp_work_phone)
    TextView firstEmpWorkPhone;
    @BindView(R.id.frist_emp_mobile_phone)
    TextView firstEmpMobilePhone;
    @BindView(R.id.con_name)
    TextView conName;
    @BindView(R.id.con_relation)
    TextView conRelation;
    @BindView(R.id.con_email)
    TextView conEmail;
    @BindView(R.id.con_home_phone)
    TextView conHomePhone;

    public Efragment() {
        // Required empty public constructor
    }

    public static Efragment newInstance() {
        Bundle args = new Bundle();
        Efragment fragment = new Efragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);
        initInstances();
        return rootView;
    }

    private void initInstances() {
        Call<EmployeeDao> call = HttpManager.getInstance().getService().getData();
        call.enqueue(new Callback<EmployeeDao>() {
            @Override
            public void onResponse(Call<EmployeeDao> call, Response<EmployeeDao> response) {
                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                EmployeeDao data = response.body();
                EmployeeFeatureProperties userData = data.getFeature().get(0).getEmployeeFeatureDao();

                if(userData.getEmplayeeNo()!=null)
                    empNo.setText(userData.getEmplayeeNo());
                else
                    empNo.setText("-");


                empMobile.setText(data.getFeature().get(0).getEmployeeFeatureDao().getMobile());
                if (userData.getTelephone() != null)
                    empTelephone.setText(userData.getTelephone());
                else
                    empTelephone.setText("-");

                empAddress.setText(userData.getAddress1() + userData.getAddress2() + userData.getSuburb() + userData.getPostcode());
                empEmail.setText(userData.getEmail());

                if(userData.getWorkEmail() == null)
                    empWorkingEmail.setText("-");
                else
                    empWorkingEmail.setText(userData.getWorkEmail());

                firstEmpName.setText(userData.getConFirstName() + userData.getConLastName());
                firstEmpPostion.setText(userData.getConRelationShip());
                firstEmpEmail.setText(userData.getConEmail());
                firstEmpHomePhone.setText(userData.getConHomePhone());
                firstEmpWorkPhone.setText(userData.getConWorkPhone());
                firstEmpMobilePhone.setText(userData.getConMobile());

                conName.setText(userData.getConFirstName() + userData.getConLastName());
                conRelation.setText(userData.getConRelationShip());
                conEmail.setText(userData.getConEmail());
                conHomePhone.setText(userData.getConHomePhone());
            }

            @Override
            public void onFailure(Call<EmployeeDao> call, Throwable t) {
                Log.d("exid", "fail");
            }
        });
    }
}
