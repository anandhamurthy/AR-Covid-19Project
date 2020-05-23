package com.arcovid19project.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.arcovid19project.MedicalStoresActivity;
import com.arcovid19project.Models.HealthCareList;
import com.arcovid19project.Models.Official_Directories;
import com.arcovid19project.R;

import java.util.List;

public class OfficialDirectoriesAdapter extends RecyclerView.Adapter<OfficialDirectoriesAdapter.ImageViewHolder> {


    private Context mContext;
    private List<Official_Directories> mOfficialDirectoriesList;

    public OfficialDirectoriesAdapter(Context context, List<Official_Directories> mHealthCareList) {
        mContext = context;
        this.mOfficialDirectoriesList = mHealthCareList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_official_directories, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final Official_Directories official_directories = mOfficialDirectoriesList.get(position);

        holder.District.setText(official_directories.getName());
        holder.Dc.setText(official_directories.getDc());

        holder.Si.setText(official_directories.getSi());
        holder.Dmos.setText(official_directories.getDmos());

    }

    @Override
    public int getItemCount() {
        return mOfficialDirectoriesList.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView District, Dc, Si, Dmos;

        public ImageViewHolder(View itemView) {
            super(itemView);

            District = itemView.findViewById(R.id.district);
            Dc = itemView.findViewById(R.id.dc);
            Si = itemView.findViewById(R.id.si);
            Dmos = itemView.findViewById(R.id.dmos);

        }
    }

}