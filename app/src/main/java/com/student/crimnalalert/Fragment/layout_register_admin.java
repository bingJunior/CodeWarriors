package com.student.crimnalalert.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.student.crimnalalert.ADMIN.MainActivityForAdmin;
import com.student.crimnalalert.MainActivity;
import com.student.crimnalalert.Modal.AdminDatabaseHelper;
import com.student.crimnalalert.Modal.UserDatabaseHelper;
import com.student.crimnalalert.R;

public class layout_register_admin extends Fragment {
    View view;

    private EditText name,mobilenumber,email,password,confirmpassword,govt_id;
    private Button register;
    private ImageView registerclose;
    private TextView alredyHaveAnAccount;
    private ProgressBar progressBar_register;
    FrameLayout frameLayout;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    private String emailpattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private String mobilenumerpattern="^[0-9][A-Za-z0-9 -]*$";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //view=layoutInflater.inflate(R.layout.activity_register,container,false);
        view=inflater.inflate(R.layout.activity_layout_register_admin,container,false);
        name=view.findViewById(R.id.et_name);
        mobilenumber=view.findViewById(R.id.et_mobilenumber);
        email=view.findViewById(R.id.et_emailaddress);
        password=view.findViewById(R.id.et_password);
        confirmpassword=view.findViewById(R.id.et_confirmpassword);
        govt_id=view.findViewById(R.id.et_govtid);
        register=view.findViewById(R.id.btn_register);

        registerclose=view.findViewById(R.id.btn_register_close);

        alredyHaveAnAccount=view.findViewById(R.id.tv_already_have_an_account);
        progressBar_register=view.findViewById(R.id.progressid);
        frameLayout=getActivity().findViewById(R.id.mainframeid1);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        database = FirebaseDatabase.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alredyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setfragment(new layout_login_admin());
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        govt_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mobilenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        confirmpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to do send data to firebase
                chekEmailAndPassword();
            }
        });

        registerclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainIntent();
            }
        });
    }


    private void setfragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    @SuppressLint("ResourceAsColor")
    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText())){
            if(!TextUtils.isEmpty(name.getText())){
                if(!TextUtils.isEmpty(password.getText()) && password.length()>=8){
                    if(!TextUtils.isEmpty(confirmpassword.getText())){
                        if(!TextUtils.isEmpty(govt_id.getText())) {
                            register.setEnabled(true);
                            register.setTextColor(Color.rgb(255,255,255));
                        }
                        else
                        {
                            register.setEnabled(false);
                            register.setTextColor(Color.argb(50,255,255,255));
                        }
                        if(!TextUtils.isEmpty(mobilenumber.getText())){
                            // register.setTextColor(R.color.whiteTextColor);
                            register.setEnabled(true);
                            register.setTextColor(Color.rgb(255,255,255));

                        }else{
                            register.setEnabled(false);
                            register.setTextColor(Color.argb(50,255,255,255));
                        }

                    }else{
                        register.setEnabled(false);
                        register.setTextColor(Color.argb(50,255,255,255));
                    }

                }else{
                    register.setEnabled(false);
                    register.setTextColor(Color.argb(50,255,255,255));
                }

            }else{

                register.setEnabled(false);
                register.setTextColor(Color.argb(50,255,255,255));
            }
        }
        else{
            register.setEnabled(false);
            register.setTextColor(Color.argb(50,255,255,255));
        }

    }
    private void chekEmailAndPassword() {
        Drawable erroricon=getResources().getDrawable(R.mipmap.error);
        erroricon.setBounds(0,0,erroricon.getIntrinsicWidth(),erroricon.getIntrinsicHeight());
        if(email.getText().toString().matches(emailpattern)){
            if(password.getText().toString().equals(confirmpassword.getText().toString())){
                if(mobilenumber.getText().toString().matches(mobilenumerpattern)&& mobilenumber.length()==10){
                    progressBar_register.setVisibility(view.VISIBLE);
                    register.setEnabled(false);
                    register.setTextColor(Color.argb(50,255,255,255));

                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){

                                        String NAME=name.getText().toString();
                                        String MOBILENUMBER=mobilenumber.getText().toString();
                                        String EMAIL=email.getText().toString();
                                        String PASSWORD=password.getText().toString();
                                        String GOVT_ID=govt_id.getText().toString();

                                        reference= database.getReference("AdminData");
                                        AdminDatabaseHelper adminDatabaseHelper=new AdminDatabaseHelper(NAME,MOBILENUMBER,EMAIL,PASSWORD,GOVT_ID);
                                        //generate unique key
                                        String uniqueKey = reference.child("AdminData").push().getKey();
                                        reference.child(MOBILENUMBER).setValue(adminDatabaseHelper);

//                                           MainIntent();

                                        setfragment(new layout_register_admin());

                                    }else{
                                        progressBar_register.setVisibility(view.INVISIBLE);
                                        String error=task.getException().getMessage();
                                        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                        register.setEnabled(true);
                                        register.setTextColor(Color.rgb(255,255,255));
                                    }

                                }
                            });

                }
                else{
                    mobilenumber.setError("Invalid number!!!",erroricon);
                }
            }
            else {
                confirmpassword.setError("Password doesn't match",erroricon);
            }
        }else {
            email.setError("Invalid Email !!!!",erroricon);
        }
    }

    private void gologin() {
    }

    private  void MainIntent(){
        Intent intent=new Intent(getActivity(), MainActivityForAdmin.class);
        startActivity(intent);
        getActivity().finish();

    }




}