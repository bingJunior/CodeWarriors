package com.student.crimnalalert.ADMIN;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.student.crimnalalert.Modal.filterMissPersonSearch;
import com.student.crimnalalert.R;
import com.student.crimnalalert.filtermisspersonAdapter;

public class MainActivityForAdmin extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapter;
    filtermisspersonAdapter obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_admin);

        recyclerView=findViewById(R.id.recyclerid1);

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);

            db = FirebaseFirestore.getInstance();
            Query query = db.collection("MissingPersonReport");

            FirestoreRecyclerOptions<filterMissPersonSearch> response = new FirestoreRecyclerOptions.Builder<filterMissPersonSearch>()
                    .setQuery(query, filterMissPersonSearch.class)
                    .build();

            obj=new filtermisspersonAdapter(response);

            recyclerView.setAdapter(obj);
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