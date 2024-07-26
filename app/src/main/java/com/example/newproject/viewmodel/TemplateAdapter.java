package com.example.newproject.viewmodel;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newproject.R;
import com.example.newproject.model.Template;

import java.util.List;

public class TemplateAdapter extends RecyclerView.Adapter<TemplateAdapter.TemplateViewHolder> {

    private List<Template> templates;
    private final OnTemplateClickListener onTemplateClickListener;

    public interface OnTemplateClickListener {
        void onTemplateClick(Template template);
    }

    public TemplateAdapter(List<Template> templates, OnTemplateClickListener onTemplateClickListener) {
        this.templates = templates;
        this.onTemplateClickListener = onTemplateClickListener;
    }

    @NonNull
    @Override
    public TemplateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_item, parent, false);
        return new TemplateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateViewHolder holder, int position) {
        Template template = templates.get(position);
        String imageUrl = template.getPreviewUrl();

        if (imageUrl == null || imageUrl.isEmpty()) {
            holder.imageView.setImageResource(R.drawable.placeholder);
            Log.d("TemplateAdapter", "imageUrl: null");

        } else {
            Log.d("TemplateAdapter", "imageUrl: " + imageUrl);
            Glide.with(holder.itemView.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder) // Drawable placeholder
                    .error(R.drawable.error) // Drawable error
                    .into(holder.imageView);
        }

        holder.itemView.setOnClickListener(v -> {
            if (onTemplateClickListener != null) {
                onTemplateClickListener.onTemplateClick(template);
            }
        });
    }

    @Override
    public int getItemCount() {
        return templates.size();
    }

    public void setData(List<Template> newTemplates) {
        this.templates = newTemplates;
        notifyDataSetChanged();
    }

    static class TemplateViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        TemplateViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.template_image);
        }
    }
}
