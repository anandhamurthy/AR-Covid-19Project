package com.arcovid19project.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.arcovid19project.MedicalStoresActivity;
import com.arcovid19project.Models.HealthCareList;
import com.arcovid19project.R;
import com.arcovid19project.ShowMapActivity;

import java.util.ArrayList;
import java.util.List;

public class HealthCareListAdapter extends RecyclerView.Adapter<HealthCareListAdapter.ImageViewHolder> {


    private Context mContext;
    private List<HealthCareList> mHealthCareList;

    public HealthCareListAdapter(Context context, List<HealthCareList> mHealthCareList) {
        mContext = context;
        this.mHealthCareList = mHealthCareList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_health_care_list, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final HealthCareList healthCareList = mHealthCareList.get(position);

        holder.Name.setText(healthCareList.getName());
        holder.Address.setText(healthCareList.getAddress());

        holder.Phone_Number.setText(healthCareList.getPhone_number());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder =
                        new AlertDialog.Builder(mContext, R.style.DialogTheme);
                builder.setTitle("See Location");
                builder.setMessage("Do you want to know location ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(mContext, ShowMapActivity.class);
                        intent.putExtra("place", healthCareList.getAddress());
                        mContext.startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mHealthCareList.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView Name, Address, Phone_Number;

        public ImageViewHolder(View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.name);
            Address = itemView.findViewById(R.id.address);
            Phone_Number = itemView.findViewById(R.id.phone_number);

        }
    }

}