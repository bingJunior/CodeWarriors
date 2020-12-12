package com.student.crimnalalert.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.crimnalalert.NavbarFirAdapter;
import com.student.crimnalalert.NavbarNcrAdapter;
import com.student.crimnalalert.R;

public class Navbar_NCR extends Fragment {
    View v;
    RecyclerView recyclerView;
    public Navbar_NCR() {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.activity_navbar__n_c_r,container,false);
        recyclerView=v.findViewById(R.id.ncrRegister_id);

        NavbarNcrAdapter obj=new NavbarNcrAdapter();
        GridLayoutManager gridLayoutManager=new GridLayoutManager(v.getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(obj);

        return v;
    }

}