package com.student.crimnalalert.ADMIN;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.student.crimnalalert.Fragment.layout_register;
import com.student.crimnalalert.Fragment.layout_register_admin;
import com.student.crimnalalert.R;

public class RegisterActivityForAdmin extends AppCompatActivity {
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_for_admin2);
        frameLayout=findViewById(R.id.mainframeid1);
        setfragment(new layout_register_admin());
    }
    private void setfragment(Fragment fragment) {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayout.getId(),fragment);
        ft.commit();

    }
}