package com.arcovid19project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcovid19project.CoronaStatusActivity;
import com.arcovid19project.DonateFundsActivity;
import com.arcovid19project.DonateMaterialsActivity;
import com.arcovid19project.EssentialCommoditiesActivity;
import com.arcovid19project.FAQsActivity;
import com.arcovid19project.GovernmentOrdersActivity;
import com.arcovid19project.HealthCaresActivity;
import com.arcovid19project.OfficialDirectoriesActivity;
import com.arcovid19project.OrphanageSupport.FreeFoodActivity;
import com.arcovid19project.HomeTreatmentActivity;
import com.arcovid19project.HospitalAdmissionActivity;
import com.arcovid19project.MedicalStoresActivity;
import com.arcovid19project.Models.Jsons;
import com.arcovid19project.MyHealthStatusActivity;
import com.arcovid19project.OnlineDoctorsActivity;
import com.arcovid19project.OrphanageSupportActivity;
import com.arcovid19project.R;
import com.arcovid19project.TestLabsActivity;
import com.arcovid19project.TweetsActivity;
import com.arcovid19project.VolunteersActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ImageViewHolder> {

    private Context mContext;
    private int[] Image;
    private String[] Title;
    private DatabaseReference mJsonDatabase;

    public MainAdapter(Context context, String[] titles, int[] images) {
        mContext = context;
        Image = images;
        Title = titles;
        mJsonDatabase = FirebaseDatabase.getInstance().getReference().child("Jsons");
        mJsonDatabase.keepSynced(true);
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_grid_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        holder.Title.setText(Title[position]);
        Glide.with(mContext)
                .load(Image[position])
                .into(holder.Image);
        mJsonDatabase = FirebaseDatabase.getInstance().getReference().child("Jsons");
        mJsonDatabase.keepSynced(true);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mJsonDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Jsons jsons = dataSnapshot.getValue(Jsons.class);
                        switch (holder.getAdapterPosition()) {
                            case 0:
                                Intent coronaintent = new Intent(mContext, CoronaStatusActivity.class);
                                coronaintent.putExtra("url", jsons.getCorona());
                                mContext.startActivity(coronaintent);
                                break;
                            case 1:
                                Intent hometreatmentintent = new Intent(mContext, HomeTreatmentActivity.class);
                                hometreatmentintent.putExtra("image_url", jsons.getHome_treatment_images());
                                hometreatmentintent.putExtra("link_url", jsons.getHome_treatment_links());
                                mContext.startActivity(hometreatmentintent);
                                break;

                            case 2:
                                Intent myhealthstatusintent = new Intent(mContext, MyHealthStatusActivity.class);
                                mContext.startActivity(myhealthstatusintent);
                                break;

                            case 3:
                                Intent healthcaresintent = new Intent(mContext, HealthCaresActivity.class);
                                healthcaresintent.putExtra("url", jsons.getHealth_cares());
                                mContext.startActivity(healthcaresintent);
                                break;
                            case 4:
                                Intent medicalstoresintent = new Intent(mContext, MedicalStoresActivity.class);
                                mContext.startActivity(medicalstoresintent);
                                break;

                            case 5:
                                Intent onlinedoctorintent = new Intent(mContext, OnlineDoctorsActivity.class);
                                mContext.startActivity(onlinedoctorintent);
                                break;

                            case 6:
                                Intent hospitaladmissionintent = new Intent(mContext, HospitalAdmissionActivity.class);
                                mContext.startActivity(hospitaladmissionintent);
                                break;

                            case 7:
                                Intent essentialcommoditiesintent = new Intent(mContext, EssentialCommoditiesActivity.class);
                                essentialcommoditiesintent.putExtra("url", jsons.getEssential_commodities());
                                mContext.startActivity(essentialcommoditiesintent);
                                break;

                            case 8:
                                Intent volunteersintent = new Intent(mContext, VolunteersActivity.class);
                                mContext.startActivity(volunteersintent);
                                break;

                            case 9:
                                Intent freefoodintent = new Intent(mContext, FreeFoodActivity.class);
                                mContext.startActivity(freefoodintent);
                                break;

                            case 10:
                                Intent testlabsintent = new Intent(mContext, TestLabsActivity.class);
                                testlabsintent.putExtra("url", jsons.getLab_test());
                                mContext.startActivity(testlabsintent);
                                break;

                            case 11:
                                Intent orphanagesupportintent = new Intent(mContext, OrphanageSupportActivity.class);
                                mContext.startActivity(orphanagesupportintent);
                                break;


                            case 12:
                                Intent epassintent = new Intent(Intent.ACTION_VIEW);
                                epassintent.setData(Uri.parse(jsons.getEpass()));
                                mContext.startActivity(epassintent);
                                break;


                            case 13:
                                Intent donatefundsintent = new Intent(mContext, DonateFundsActivity.class);
                                mContext.startActivity(donatefundsintent);
                                break;

                            case 14:
                                Intent donatematerialsintent = new Intent(mContext, DonateMaterialsActivity.class);
                                mContext.startActivity(donatematerialsintent);
                                break;


                            case 15:
                                Intent governmentordersintent = new Intent(mContext, GovernmentOrdersActivity.class);
                                governmentordersintent.putExtra("url",jsons.getGovernment_orders());
                                mContext.startActivity(governmentordersintent);
                                break;
                            case 16:
                                Intent migrantintent = new Intent(Intent.ACTION_VIEW);
                                migrantintent.setData(Uri.parse(jsons.getMigrant()));
                                mContext.startActivity(migrantintent);
                                break;
                            case 17:
                                Intent officialdirectoriesintent = new Intent(mContext, OfficialDirectoriesActivity.class);
                                officialdirectoriesintent.putExtra("url", jsons.getOfficial_directories());
                                mContext.startActivity(officialdirectoriesintent);
                                break;
                            case 18:
                                Intent educationintent = new Intent(Intent.ACTION_VIEW);
                                educationintent.setData(Uri.parse(jsons.getVocational_education()));
                                mContext.startActivity(educationintent);
                                break;

                            case 19:
                                Intent tweetintent = new Intent(mContext, TweetsActivity.class);
                                tweetintent.putExtra("url", jsons.getTweets());
                                mContext.startActivity(tweetintent);
                                break;
                            case 20:
                                Intent faqintent = new Intent(mContext, FAQsActivity.class);
                                faqintent.putExtra("url", jsons.getFaq());
                                mContext.startActivity(faqintent);
                                break;

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }

    @Override
    public int getItemCount() {
        return Title.length;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView Title;
        public ImageView Image;
        public ImageViewHolder(View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.label);
            Image = itemView.findViewById(R.id.image);
        }
    }
}