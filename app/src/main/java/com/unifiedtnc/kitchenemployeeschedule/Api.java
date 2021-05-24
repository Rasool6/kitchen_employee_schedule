package com.unifiedtnc.kitchenemployeeschedule;

import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.InerstTaskResponse;
import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.LoginResponse;
import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.RegisterResponse;
import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.TaskResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    @FormUrlEncoded
    @POST("get_user_signup.php")
    Call<RegisterResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
             );

    @FormUrlEncoded
    @POST("get_login.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
             );

//    @GET("get_task_data.php")

    @GET("get_task_data.php")
    Call<TaskResponce> getTaskData(
             @Query("kitchen") String str_ketchen,
            @Query("day")  String str_day
    );

    @FormUrlEncoded
    @POST("add_complete_task.php")
    Call<InerstTaskResponse> add_complete_task(
            @Field("task_id") String task_id,
            @Field("employee") String employ,
            @Field("task_name") String task_name,
            @Field("day") String day
    );


}
