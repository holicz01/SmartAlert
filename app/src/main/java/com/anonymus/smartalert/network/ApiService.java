package com.anonymus.smartalert.network;




import com.anonymus.smartalert.dao.EmployeeDao;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;


/**
 * Created by peem-jirayu on 11/11/2559.
 */

public interface ApiService {

    @GET("contactlist")
    Call<EmployeeDao> getData();

}


