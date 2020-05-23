package com.arcovid19project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcovid19project.Models.EssentialCommodities;
import com.arcovid19project.R;

import java.util.List;

public class EssentialCommoditiesAdapter extends RecyclerView.Adapter<EssentialCommoditiesAdapter.ImageViewHolder>{

    private Context mContext;
    private List<EssentialCommodities> mEssential_Commodities;

    public EssentialCommoditiesAdapter(Context context, List<EssentialCommodities> list) {
        mContext = context;
        mEssential_Commodities = list;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_essential_commodities, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final EssentialCommodities essentialCommodities = mEssential_Commodities.get(position);

        holder.District.setText(essentialCommodities.getDistricts());
        holder.Name.setText(essentialCommodities.getName());
        holder.Contact_Number.setText(essentialCommodities.getContact_numbers());
    }

    @Override
    public int getItemCount() {
        return mEssential_Commodities.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView District, Name, Contact_Number;
        public ImageViewHolder(View itemView) {
            super(itemView);

            District = itemView.findViewById(R.id.district);
            Name = itemView.findViewById(R.id.name);
            Contact_Number = itemView.findViewById(R.id.contact_number);
        }
    }

}