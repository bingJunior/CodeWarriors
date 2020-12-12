package com.student.crimnalalert;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.student.crimnalalert.Modal.filterMissPersonSearch;

import java.io.ByteArrayOutputStream;

public class filtermisspersonAdapter extends FirestoreRecyclerAdapter<filterMissPersonSearch,filtermisspersonAdapter.myviewholder> {
    private View view;

    public filtermisspersonAdapter(FirestoreRecyclerOptions<filterMissPersonSearch> options) {
        super(options);
    }
    @NonNull
    @Override
    protected void onBindViewHolder(@NonNull myviewholder myviewholder, int i, filterMissPersonSearch filterMissPersonSearch) {

        myviewholder.name.setText(filterMissPersonSearch.getName());
        myviewholder.age.setText(filterMissPersonSearch.getAge());
        myviewholder.gender.setText(filterMissPersonSearch.getGender());
        myviewholder.DOB.setText(filterMissPersonSearch.getYear_of_birth());
        myviewholder.weight.setText(filterMissPersonSearch.getWeight()+"weight");
        myviewholder.height.setText(filterMissPersonSearch.getHeight_to()+"height");
        myviewholder.complexion.setText(filterMissPersonSearch.getComplexion());




         byte[] imageBytes = Base64.decode(filterMissPersonSearch.getPhoto(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        myviewholder.imageView.setImageBitmap(decodedImage);

//        Glide.with(view.getContext())
//                .load(filterMissPersonSearch.getPhoto())
//                .into(myviewholder.imageView);

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_format, parent, false);

        return new myviewholder(view);
    }


public static class myviewholder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name;
        public TextView age;
        public TextView gender;
        public TextView DOB;
        public TextView weight;
        public TextView height;
        public TextView complexion;
        CardView cardView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            gender = itemView.findViewById(R.id.gender);
            DOB = itemView.findViewById(R.id.date);
            weight = itemView.findViewById(R.id.weight);
            height = itemView.findViewById(R.id.height);
            complexion = itemView.findViewById(R.id.complexion);
            cardView=itemView.findViewById(R.id.filtercard);
        }
    }
}



