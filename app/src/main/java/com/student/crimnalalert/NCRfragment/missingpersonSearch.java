package com.student.crimnalalert.NCRfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.student.crimnalalert.Fragment.layout_login;
import com.student.crimnalalert.MainActivity;
import com.student.crimnalalert.R;

public class missingpersonSearch extends Fragment {
    private View v;
    private Button filter;
    private FrameLayout frameLayout;
    private EditText name,fathername,state;
    public missingpersonSearch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.missingpersonsearch,container,false);
        filter=v.findViewById(R.id.filter_missing_person_search);
        name=v.findViewById(R.id.name);
        fathername=v.findViewById(R.id.fathername);
        state=v.findViewById(R.id.state);

       frameLayout=getActivity().findViewById(R.id.frameid);

//        Intent mainintent=new Intent(getActivity(), MainActivity.class);
//        mainintent.putExtra("name",name.getText().toString());
//        mainintent.putExtra("fathername",name.getText().toString());
//        mainintent.putExtra("",name.getText().toString());
//        startActivity(mainintent);
//        getActivity().finish()

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new filterMissingPersonSearch());
            }
        });
    }

    private void setFragment(filterMissingPersonSearch filterMissingPersonSearch) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),filterMissingPersonSearch);
        fragmentTransaction.commit();
    }

}

