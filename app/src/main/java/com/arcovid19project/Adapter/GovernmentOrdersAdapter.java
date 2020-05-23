package com.arcovid19project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcovid19project.Models.GovernmentOrders;
import com.arcovid19project.R;

import java.util.List;

public class GovernmentOrdersAdapter extends RecyclerView.Adapter<GovernmentOrdersAdapter.ImageViewHolder> {

    private Context mContext;
    private List<GovernmentOrders> mGovernment_Orders;

    public GovernmentOrdersAdapter(Context context, List<GovernmentOrders> list) {
        mContext = context;
        mGovernment_Orders = list;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_government_orders, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final GovernmentOrders governmentOrders = mGovernment_Orders.get(position);

        holder.Date.setText(governmentOrders.getDate());
        holder.Title.setText(governmentOrders.getTitle());
        holder.Link.setText(governmentOrders.getLink());
    }

    @Override
    public int getItemCount() {
        return mGovernment_Orders.size();
    }



    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView Date, Title, Link;
        public ImageViewHolder(View itemView) {
            super(itemView);

            Date = itemView.findViewById(R.id.date);
            Title = itemView.findViewById(R.id.title);
            Link = itemView.findViewById(R.id.link);
        }
    }

}