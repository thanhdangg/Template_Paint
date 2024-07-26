package com.example.newproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newproject.model.TemplateCategory;

import java.util.List;

public class TemplateViewModel  extends ViewModel {
    private TemplateRepository repository;
    private MutableLiveData<List<TemplateCategory>> templatesData;
    public TemplateViewModel() {
        repository = new TemplateRepository();
        templatesData = repository.getTemplates();
    }
    public LiveData<List<TemplateCategory>> getTemplates() {
        return templatesData;
    }
}
