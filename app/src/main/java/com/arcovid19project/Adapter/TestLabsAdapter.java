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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.arcovid19project.MedicalStoresActivity;
import com.arcovid19project.Models.Test_Labs;
import com.arcovid19project.R;

import java.util.ArrayList;
import java.util.List;

public class TestLabsAdapter extends RecyclerView.Adapter<TestLabsAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Test_Labs> mTest_Labs;

    public TestLabsAdapter(Context context, List<Test_Labs> list) {
        mContext = context;
        mTest_Labs = list;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_lab_test, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final Test_Labs test_labs = mTest_Labs.get(position);

        holder.Lab_Name.setText(test_labs.getName());
        holder.Address.setText(test_labs.getAddress());
        holder.Phone_Number.setText(test_labs.getPhone_number());
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
                        Intent intent = new Intent(mContext, MedicalStoresActivity.class);
                        intent.putExtra("place", test_labs.getAddress());
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
        return mTest_Labs.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView Lab_Name, Address, Phone_Number;
        public ImageViewHolder(View itemView) {
            super(itemView);

            Lab_Name = itemView.findViewById(R.id.lab_name);
            Address = itemView.findViewById(R.id.location);
            Phone_Number = itemView.findViewById(R.id.type);
        }
    }

}