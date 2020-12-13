package com.student.crimnalalert.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
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
import com.student.crimnalalert.ADMIN.MainActivityForAdmin;
import com.student.crimnalalert.MainActivity;
import com.student.crimnalalert.R;

public class layout_login_admin extends Fragment {
    View view;
    EditText email,password;
    TextView forgotpassword,dont_have_an_account;
    FrameLayout frameLayout;
    Button login;
    ImageView close;
    ProgressBar progressBar;

    private String emailpattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_layout_login_admin,container,false);

        email=view.findViewById(R.id.et_loginemail);
        password=view.findViewById(R.id.et_loginpassword);
        forgotpassword=view.findViewById(R.id.tv_forgotpassword);
        dont_have_an_account=view.findViewById(R.id.tv_dont_have_an_account);
        login=view.findViewById(R.id.btn_login);

        close=view.findViewById(R.id.btn_login_close);

        progressBar=view.findViewById(R.id.progressid);
        frameLayout=getActivity().findViewById(R.id.mainframeid1);

        firebaseAuth=FirebaseAuth.getInstance();

        return view;
    }

    private void chekEmailAndPassword() {
        if(email.getText().toString().matches(emailpattern)){
            if(password.getText().toString().length()>=8){

                progressBar.setVisibility(view.VISIBLE);
                login.setEnabled(false);
                login.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    MainIntent();
                                }
                                else {
                                    progressBar.setVisibility(view.INVISIBLE);
                                    login.setEnabled(true);
                                    login.setTextColor(Color.rgb(255,255,255));

                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
            else{
                Toast.makeText(getActivity(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getActivity(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
        }
    }

    private void MainIntent() {
        Intent mainintent=new Intent(getActivity(), MainActivityForAdmin.class);
//        mainintent.putExtra("email",email.getText().toString());
        startActivity(mainintent);
        getActivity().finish();
    }

    private void chekinputs() {
        if(!TextUtils.isEmpty(email.getText().toString())){
            if(!TextUtils.isEmpty(password.getText().toString())){
                login.setEnabled(true);
                login.setTextColor(Color.rgb(255,255,255));

            }else {
                login.setEnabled(false);
                login.setTextColor(Color.argb(50,255,255,255));
            }

        }else{
            login.setEnabled(false);
            login.setTextColor(Color.argb(50,255,255,255));
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dont_have_an_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setfragment(new layout_register_admin());
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                chekinputs();

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
                chekinputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chekEmailAndPassword();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainIntent();
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setfragment(new layout_forgot());
            }
        });


    }

    private void setfragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}