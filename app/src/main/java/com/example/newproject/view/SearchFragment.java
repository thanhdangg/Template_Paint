package com.example.newproject.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newproject.R;
import com.example.newproject.databinding.FragmentDetailBinding;
import com.example.newproject.databinding.FragmentSearchBinding;
import com.example.newproject.model.Template;
import com.example.newproject.model.TemplateCategory;
import com.example.newproject.viewmodel.CategoryAdapter;
import com.example.newproject.viewmodel.TemplateAdapter;
import com.example.newproject.viewmodel.TemplateViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private TemplateViewModel templateViewModel;
    private FragmentSearchBinding binding;
    private List<Template> templateList = new ArrayList<>();
    private List<String> categoryTypes = new ArrayList<>();
    private TemplateAdapter templateAdapter;
    private CategoryAdapter categoryAdapter;
    public SearchFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        templateViewModel = new ViewModelProvider(this).get(TemplateViewModel.class);

        binding.listTypeCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        categoryAdapter = new CategoryAdapter(categoryTypes, category -> {
            Log.d("DetailFragment", "Category selected: " + category);
            onCategorySelected(category);
        });
        binding.listTypeCategory.setAdapter(categoryAdapter);


        binding.listTemplate.setLayoutManager(new GridLayoutManager(getContext(), 2));
        templateAdapter = new TemplateAdapter(templateList, template -> {
            showImageInPreview(template.getPreviewUrl());
        });
        binding.listTemplate.setAdapter(templateAdapter);

        templateViewModel.getTemplates().observe(getViewLifecycleOwner(), templateCategories -> {
            List<String> types = new ArrayList<>();
            templateList.clear();
            for (TemplateCategory category : templateCategories) {
                types.add(category.getType());
                templateList.addAll(category.getData());
            }
            categoryTypes.clear();
            categoryTypes.addAll(types);
            categoryAdapter.notifyDataSetChanged();
            if (!categoryTypes.isEmpty()) {
                onCategorySelected(categoryTypes.get(0));
            }
        });
    }

    private void onCategorySelected(String category) {
        List<Template> filteredTemplates = filterTemplatesByCategory(category);
        updateTemplateRecyclerView(filteredTemplates);
    }

    private List<Template> filterTemplatesByCategory(String category) {
        List<Template> filteredTemplates = new ArrayList<>();
        if (category == null) {
            return filteredTemplates;
        }
        for (Template template : templateList) {
            String templateType = template.getCategoryName();
            Log.d("DetailFragment", "Template type: " + templateType + " category: " + category + " equal: " + category.equals(templateType));
            if (templateType == null) {
                templateType = "Recommend";
            }
            if (category.equals(templateType)) {
                filteredTemplates.add(template);
                Log.d("DetailFragment", "Template added: " + template.getPreviewUrl());
            }
        }
        return filteredTemplates;
    }

    private void updateTemplateRecyclerView(List<Template> filteredTemplates) {
        templateAdapter.setData(filteredTemplates);
    }

    private void showImageInPreview(String imageUrl) {

    }
}