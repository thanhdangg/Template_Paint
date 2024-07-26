package com.example.newproject.viewmodel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("coloring/templates")
    Call<ApiResponse> getTemplates();
}
