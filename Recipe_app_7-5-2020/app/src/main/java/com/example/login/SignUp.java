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

public class SignUp extends AppCompatActivity {

    MaterialEditText Phone_signup ,Name_signup,Password_signup;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        try {
            getSupportActionBar().hide();
        }
        catch (Exception e)
        {}
        Phone_signup =findViewById(R.id.phone_signup);
        Name_signup =findViewById(R.id.Name_signup);
        Password_signup =findViewById(R.id.Password_signup);
        btnSignUp =findViewById(R.id.btnSignUp_signup);

        final FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog mDiDialog = new ProgressDialog(SignUp.this);
                mDiDialog.setMessage("Please Wait...");
                mDiDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        if(snapshot.child(Phone_signup.getText().toString()).exists()){
                            mDiDialog.dismiss();
                            Toast.makeText(SignUp.this, "This Phone Number is Already Registered !!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            mDiDialog.dismiss();
                            User user = new User(Name_signup.getText().toString(),Password_signup.getText().toString());
                            table_user.child(Phone_signup.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Sign Up Successfull!!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUp.this,Recipe_main_page.class);
                            startActivity(intent);
                            Intent intent1 = new Intent(SignUp.this,user_profile.class);
                            intent1.putExtra("phonenumber",Phone_signup.getText().toString());
                            intent1.putExtra("username",Name_signup.getText().toString());
                            startActivity(intent1);
                            finish();
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