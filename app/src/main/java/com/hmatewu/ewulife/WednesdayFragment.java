package com.hmatewu.ewulife;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;


public class WednesdayFragment extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    Button button,button2;
    RecyclerView recyclerView;

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;
    FirestoreRecyclerAdapter adapter;
    int n=0;
    double a_plus=4;
    double a_minus=3.70;
    double b_plus= 3.30;
    double b =3;
    double b_minus =2.70;
    double c_plus = 2.30;
    double c = 2;
    double c_minus = 1.70;
    double d_plus = 1.30;
    double d = 1;
    double f = 0;
    List<String> cgpa_list = new ArrayList<>();
    public Query query;
    public WednesdayFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_wednesday, container, false);
        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID =fAuth.getCurrentUser().getUid();
        button = v.findViewById(R.id.wfbutton5);
        recyclerView= v.findViewById(R.id.wfrec);

        arrayList_parent = new ArrayList<>();


        query = fstore.collection("class").document(userID).collection("Wednesday");
        FirestoreRecyclerOptions< model2 > options = new FirestoreRecyclerOptions.Builder<model2>()
                .setQuery(query, model2.class).build();

        adapter = new FirestoreRecyclerAdapter<model2, ProductViewHolder>(options) {
            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_sche_recycle, parent, false);
                return new ProductViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int positions, @NonNull final model2 model2) {

                holder.room.setText(model2.getRoom());
                holder.course.setText(model2.getCourse());
                holder.sec.setText(model2.getSection());
                holder.instructor.setText(model2.getInstructor());
                holder.time.setText(model2.getStart());

                holder.drop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DocumentReference documentReference = fstore.collection("class").document(userID).collection("Wednesday").document(model2.getRef());
                        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){

                                    LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                                    View layout1 = inflater1.inflate(R.layout.custom_delete_toast,(ViewGroup)v.findViewById(R.id.del));
                                    final Toast toast = new Toast(getActivity());
                                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                                    toast.setDuration((Toast.LENGTH_SHORT));
                                    toast.setView(layout1);

                                    toast.show();
                                   // Toast.makeText(getActivity(), "deleted", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    LayoutInflater inflater = getLayoutInflater();                             ///custom toast//
                                    View layout = inflater.inflate(R.layout.custom_error_admin_toast,(ViewGroup)v.findViewById(R.id.errorad));
                                    final Toast toast1 = new Toast(getActivity());
                                    toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                                    toast1.setDuration((Toast.LENGTH_SHORT));
                                    toast1.setView(layout);
                                    toast1.show();
                                    Toast.makeText(getActivity(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                });


            }
        };




        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddClassActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView course,sec,instructor,time,room;
        LinearLayout linearLayout;
        EditText editText;

        Button drop,end;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            room = itemView.findViewById(R.id.textView62);
            course = itemView.findViewById(R.id.textView57);
            sec = itemView.findViewById(R.id.textView61);
            instructor = itemView.findViewById(R.id.textView64);
            time = itemView.findViewById(R.id.textView60);

            drop = itemView.findViewById(R.id.button8);


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