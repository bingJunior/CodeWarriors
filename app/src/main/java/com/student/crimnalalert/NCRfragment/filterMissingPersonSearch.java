package com.student.crimnalalert.NCRfragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.student.crimnalalert.Modal.filterMissPersonSearch;
import com.student.crimnalalert.R;
import com.student.crimnalalert.filtermisspersonAdapter;

public class filterMissingPersonSearch extends Fragment
{
    private View v;
    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapter;

    filtermisspersonAdapter obj;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.filtermissingpersonsearch,container,false);
        recyclerView=v.findViewById(R.id.recyclerid);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(v.getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        db = FirebaseFirestore.getInstance();
        Query query = db.collection("MissingPersonReport");

        FirestoreRecyclerOptions<filterMissPersonSearch> response = new FirestoreRecyclerOptions.Builder<filterMissPersonSearch>()
                .setQuery(query, filterMissPersonSearch.class)
                .build();

        obj=new filtermisspersonAdapter(response);

        recyclerView.setAdapter(obj);


        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        obj.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        obj.stopListening();
    }
}
