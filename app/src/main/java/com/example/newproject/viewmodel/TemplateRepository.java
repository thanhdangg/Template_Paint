package com.example.newproject.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.newproject.model.TemplateCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplateRepository {
    private ApiService apiService;
    public TemplateRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }
    public MutableLiveData<List<TemplateCategory>> getTemplates() {
        MutableLiveData<List<TemplateCategory>> templatesData = new MutableLiveData<>();
        apiService.getTemplates().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<TemplateCategory> data = response.body().getData();
                    templatesData.setValue(data);
                    Log.d("TemplateRepository", "onResponse isSuccessful: " + response.body().getData());
                }
                else{
                    // Handle error
                    Log.d("TemplateRepository", "onResponse: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle failure
                Log.e("TemplateRepository", "API call failed", t);

            }
        });
        return templatesData;
    }
}
