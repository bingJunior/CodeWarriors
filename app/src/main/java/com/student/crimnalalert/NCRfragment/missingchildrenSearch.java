package com.student.crimnalalert.NCRfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.student.crimnalalert.R;

public class missingchildrenSearch extends Fragment {
    private View v;
    public missingchildrenSearch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.missingchildrensearch,container,false);
        return v;
    }
}