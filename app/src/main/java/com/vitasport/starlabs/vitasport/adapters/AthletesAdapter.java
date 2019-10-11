package com.vitasport.starlabs.vitasport.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.models.AthletesModel;

import java.util.ArrayList;
import java.util.HashSet;


public class AthletesAdapter extends RecyclerView.Adapter<AthletesAdapter.AthletesViewHolder> {

    public interface IAthletesAdapterListener {
        void onToggle(int position);
        void onSelected(int position, AthletesModel athletes);
    }

    private IAthletesAdapterListener listener;
    private ArrayList<AthletesModel> athletesList;

    public AthletesAdapter() {
        athletesList = new ArrayList<>();
    }

    public void setListener(IAthletesAdapterListener listener) {
        this.listener = listener;
    }

    public void setItemList(ArrayList<AthletesModel> itemList) {
        if (this.athletesList == null)
            this.athletesList = new ArrayList<>();
        this.athletesList.addAll(itemList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AthletesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);
        return new AthletesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AthletesViewHolder viewHolder, int position) {
        viewHolder.bindData(position, athletesList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return athletesList.size();
    }




    class AthletesViewHolder extends RecyclerView.ViewHolder {
        TextView email;

        public AthletesViewHolder(View view) {
            super(view);
            email = view.findViewById(R.id.tvEmail);
        }

        public void bindData(int position, AthletesModel athletes, IAthletesAdapterListener listener) {
            email.setText(athletes.getIdentifier());
            itemView.setOnClickListener(v -> {
                if (listener != null)
                    listener.onSelected(position,athletes);
            });
        }
    }




}