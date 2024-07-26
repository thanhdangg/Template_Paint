package com.example.newproject.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.newproject.model.TemplateCategory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplateRepository {
    private ApiService apiService;
    public TemplateRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }
    public MutableLiveData<List<TemplateCategory>> getTemplates() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MutableLiveData<List<TemplateCategory>> templatesData = new MutableLiveData<>();
        executorService.execute((new Runnable() {
            @Override
            public void run() {
                apiService.getTemplates().enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<TemplateCategory> data = response.body().getData();
                            templatesData.postValue(data);
                            Log.d("TemplateRepository", "onResponse isSuccessful: " + response.body().getData());
                        }
                        else{
                            Log.d("TemplateRepository", "onResponse: " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.e("TemplateRepository", "API call failed", t);

                    }
                });
            }
        }));
        return templatesData;
    }
}
