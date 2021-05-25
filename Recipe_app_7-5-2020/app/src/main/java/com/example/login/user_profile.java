package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class user_profile extends AppCompatActivity {

    Button btn;
    TextView textView3;

    FirebaseDatabase database;
    DatabaseReference ref,ref2,ref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        try {
            getSupportActionBar().hide();
        }
        catch (Exception e)
        {}
        btn = findViewById(R.id.button_sign_out_user_profile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_profile.this,MainActivity.class);
                startActivity(intent);
            }
        });


        textView3 = findViewById(R.id.textView3);


        //bottom navigation working code start
        BottomNavigationView bottomnavigation_user_profile;
        bottomnavigation_user_profile = findViewById(R.id.bottomnavigation_user_profile);

        bottomnavigation_user_profile.setSelectedItemId(R.id.user_profile_navigation);
        bottomnavigation_user_profile.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home_navigation:
                        startActivity(new Intent(getApplicationContext(),Recipe_main_page.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        //bottom navigation working code end

        textView3.setText(getIntent().getStringExtra("phonenumber"));

         String checknumber = getIntent().getStringExtra("Firebasenumber");
        textView3.setText(checknumber);



    }
}