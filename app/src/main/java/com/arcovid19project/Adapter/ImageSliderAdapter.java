package com.arcovid19project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arcovid19project.HomeTreatmentActivity;
import com.arcovid19project.ImageDetailedActivity;
import com.arcovid19project.Models.Image_Slider;
import com.arcovid19project.R;
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderAdapter extends
        SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<Image_Slider> mSliderItems;

    public ImageSliderAdapter(Context context, List<Image_Slider> image_sliders) {
        this.context = context;
        this.mSliderItems=image_sliders;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_slider, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        final Image_Slider sliderItem = mSliderItems .get(position);
        Glide.with(context)
                .load(sliderItem.getImage())
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(viewHolder.image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sliderItem.getImage().isEmpty()) {
                    Intent intent = new Intent(context, ImageDetailedActivity.class);
                    intent.putExtra("image", sliderItem.getImage());
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context, "Loading..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView image;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            this.itemView = itemView;
        }
    }

}