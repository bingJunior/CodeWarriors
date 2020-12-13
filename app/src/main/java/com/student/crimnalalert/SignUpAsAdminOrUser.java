package com.student.crimnalalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.student.crimnalalert.ADMIN.RegisterActivityForAdmin;

public class SignUpAsAdminOrUser extends AppCompatActivity {
  Button Admin,User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_as_admin_or_user);
        Admin=findViewById(R.id.admin);
        User=findViewById(R.id.user);
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), RegisterActivityForAdmin.class);
                startActivity(intent);
                finish();
            }
        });
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Registeractivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}