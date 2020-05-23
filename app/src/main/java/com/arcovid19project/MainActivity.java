package com.arcovid19project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.arcovid19project.Adapter.MainAdapter;
import com.arcovid19project.Login.LoginActivity;
import com.arcovid19project.Login.ProfileActivity;
import com.arcovid19project.Models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mUsersDatabase;
    private RecyclerView Grid_List;
    private FirebaseAuth mAuth;
    private ImageView Profile, Menu;

    String[] web = {
            "Corona Status",
            "Home Treatment",
            "My Health Status",
            "Health Care for COVID-19",
            "Medical stores",
            "Doctor Online Appointment",
            "Hospital Admissions",
            "Essential Commodities",
            "Volunteers & Donors",
            "Food Supply",
            "Labs for Test",
            "Support Orphans & Vulnerable",
            "E-Pass",
            "Donate Funds",
            "Donate Relief Material",
            "Government Orders",
            "Migrant People",
            "Official Directories",
            "Vocational Education",
            "Tweets",
            "FAQs"

    } ;
    int[] imageId = {
            R.drawable.status,
            R.drawable.home_treatment,
            R.drawable.health_status,
            R.drawable.health_care,
            R.drawable.medical_stores,
            R.drawable.doctors,
            R.drawable.hospitals,
            R.drawable.essential_commodities,
            R.drawable.volunteers,
            R.drawable.food,
            R.drawable.testlabs,
            R.drawable.support,
            R.drawable.epass,
            R.drawable.donate,
            R.drawable.relief_materials,
            R.drawable.government_orders,
            R.drawable.people,
            R.drawable.official_directories,
            R.drawable.education,
            R.drawable.tweet,
            R.drawable.faq

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        Grid_List = findViewById(R.id.grid_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, LinearLayoutManager.VERTICAL,false);
        Grid_List.setLayoutManager(gridLayoutManager);

        MainAdapter mainAdapter = new MainAdapter(MainActivity.this, web, imageId);
        Grid_List.setAdapter(mainAdapter);

        Profile = findViewById(R.id.toolbar_profile);
        Menu = findViewById(R.id.toolbar_menu);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("access","true");
                startActivity(intent);
            }
        });



        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.logout:
                                FirebaseAuth.getInstance().signOut();
                                sendToLogin();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.inflate(R.menu.menu_main);
                popupMenu.show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mCurrentUser = mAuth.getCurrentUser();

        if (mCurrentUser == null) {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
        else{
            FirebaseAuth auth = FirebaseAuth.getInstance();
            mUsersDatabase = FirebaseDatabase.getInstance().getReference("Users").child(auth.getCurrentUser().getUid());
            mUsersDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Users user = dataSnapshot.getValue(Users.class);
                    if (user.getVerified().equals("false")) {
                        Intent setupIntent = new Intent(MainActivity.this, ProfileActivity.class);
                        setupIntent.putExtra("access","false");
                        setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(setupIntent);
                        finish();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    private void sendToLogin() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}
