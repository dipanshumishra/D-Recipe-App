package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    Button btnSignIn;
    MaterialEditText phone_signin,Password_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        try {
            getSupportActionBar().hide();
        }
        catch (Exception e)
        {}
        btnSignIn =findViewById(R.id.btnSignIn_signin);
        Password_signin=findViewById(R.id.Password_signin);
        phone_signin=findViewById(R.id.phone_signin);


        final FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog mDiDialog = new ProgressDialog(SignIn.this);
                mDiDialog.setMessage("Please Wait...");
                mDiDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        if(snapshot.child(phone_signin.getText().toString()).exists()) {
                            mDiDialog.dismiss();
                            User user = snapshot.child(phone_signin.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(Password_signin.getText().toString())) {
                                Toast.makeText(SignIn.this, "Sign in Successfully !!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(SignIn.this,Recipe_main_page.class);
                                startActivity(intent);
                                Intent intent1 = new Intent(SignIn.this,user_profile.class);
                                intent1.putExtra("Firebasenumber",phone_signin.getText().toString());
                                startActivity(intent1);

                            } else {
                                Toast.makeText(SignIn.this, "Sign in Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            mDiDialog.dismiss();
                            Toast.makeText(SignIn.this, "User Does Not Exists !!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}