package com.hmatewu.ewulife;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class FoodInfoActivity extends AppCompatActivity {
RecyclerView recyclerView1,recyclerView2;
    public FirebaseFirestore fstore;

    FirebaseAuth fAuth;
    public ArrayList<String> arrayList_parent,arrayList_parent2;
    public ArrayAdapter<String> arrayAdapter_parent,arrayAdapter_parent2;


    List<String> cgpa_list = new ArrayList<>();
    public Query query,query2;

    FirestoreRecyclerAdapter adapter,adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);
        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        recyclerView1= findViewById(R.id.infood);
       // recyclerView2= findViewById(R.id.outfood);

        arrayList_parent = new ArrayList<>();
      //  arrayList_parent2 = new ArrayList<>();







        query = fstore.collection("Food_Inside");
        FirestoreRecyclerOptions< FoodAdapter > options = new FirestoreRecyclerOptions.Builder<FoodAdapter>()
                .setQuery(query, FoodAdapter.class).build();



        adapter = new FirestoreRecyclerAdapter<FoodAdapter, ProductViewHolder>(options) {

            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_recycle_layout, parent, false);
                return new ProductViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull ProductViewHolder holder, int positions, @NonNull final FoodAdapter foodAdapter) {

                holder.a1.setText(foodAdapter.getRestaurant());
                holder.a2.setText(foodAdapter.getItem());
                holder.a3.setText(foodAdapter.getPrice());


            }

        };
        recyclerView1.setHasFixedSize(true);

        recyclerView1.setAdapter(adapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView a1,a2,a3;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

                a1 = itemView.findViewById(R.id.textView95);
                a2 = itemView.findViewById(R.id.textView123);
                a3 = itemView.findViewById(R.id.textView124);



        }
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}