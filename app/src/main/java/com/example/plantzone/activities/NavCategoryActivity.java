package com.example.plantzone.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.plantzone.R;
import com.example.plantzone.adapters.NavCategoryAdapter;
import com.example.plantzone.adapters.NavCategoryDetailedAdapter;
import com.example.plantzone.models.HomeCategory;
import com.example.plantzone.models.NavCategoryDetailedModel;
import com.example.plantzone.models.ViewAllModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NavCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NavCategoryDetailedModel> list;
    NavCategoryDetailedAdapter adapter;
    FirebaseFirestore db;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_category);

        progressBar=findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        db=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.nav_cat_det_rec);
        list= new ArrayList<>();
        adapter=new NavCategoryDetailedAdapter(this,list);
        String type = getIntent().getStringExtra("type");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.setVisibility(View.GONE);

        if (type != null && type.equalsIgnoreCase("bonsai")) {
            db.collection("NavCategoryDetailed").whereEqualTo("type", "bonsai").get().addOnCompleteListener(task -> {

                for (DocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult()).getDocuments()) {

                    NavCategoryDetailedModel navCategoryDetailedModel = documentSnapshot.toObject(NavCategoryDetailedModel.class);
                    list.add(navCategoryDetailedModel);
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            });


        }


        if (type != null && type.equalsIgnoreCase("hanging baskets")) {
            db.collection("NavCategoryDetailed").whereEqualTo("type", "hanging baskets").get().addOnCompleteListener(task -> {

                for (DocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult()).getDocuments()) {

                    NavCategoryDetailedModel navCategoryDetailedModel = documentSnapshot.toObject(NavCategoryDetailedModel.class);
                    list.add(navCategoryDetailedModel);
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            });


        }


    }
}