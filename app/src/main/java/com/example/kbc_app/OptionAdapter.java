package com.example.kbc_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OptionAdapter extends RecyclerView.Adapter {


    List<Options> optionsList;

    Context context;

    public OptionAdapter(Context context, List<Options> optionsList) {
        this.optionsList = optionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.options_item, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        ((ItemHolder) holder).radio_option.setText(optionsList.get(position).getOptions());

        ((ItemHolder) holder).radio_option.setChecked(optionsList.get(position)
                .isCheck());

        ((ItemHolder) holder).radio_option.setOnClickListener(view -> {
            for (int i = 0; i < optionsList.size(); i++) {
                optionsList.get(i).setCheck(false); //
                ((ItemHolder) holder).radio_option.setChecked(false);// Clear all other selections

            }
            for (int i = 0; i < optionsList.size(); i++) {
                if (!optionsList.get(i)
                        .isCheck()) {
                    optionsList.get(position).setCheck(true); // Set current item as checked
                    ((ItemHolder) holder).radio_option.setChecked(true);

                }
            }

            notifyDataSetChanged(); // Refresh the view

        });
    }

    @Override
    public int getItemCount() {
        return optionsList.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {
        RadioButton radio_option;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            radio_option = itemView.findViewById(R.id.radio_option);
        }
    }

}
