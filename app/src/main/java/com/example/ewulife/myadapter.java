package com.example.ewulife;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
        holder.instructor.setText(model.getInstructor());
        holder.course.setText(model.getCourse());
        holder.day.setText(model.getDay());
        holder.time.setText(model.getDay());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.linearLayout2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.linearLayout2.setVisibility(View.VISIBLE);
                    holder.imageView.setBackgroundResource(R.drawable.collapse);
                } else {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.linearLayout2.setVisibility(View.GONE);
                    holder.imageView.setBackgroundResource(R.drawable.expand);
                }
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_course_row,parent,false);
        return new myviewholder(view);
    }

    static class myviewholder extends RecyclerView.ViewHolder
    {
        TextView instructor,course,day,time;
        LinearLayout linearLayout,linearLayout2;
        CardView cardView;
        ImageView imageView;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            instructor=(TextView)itemView.findViewById(R.id.textView28);
            course=(TextView)itemView.findViewById(R.id.textView22);
            day=(TextView)itemView.findViewById(R.id.textView25);
            time=(TextView)itemView.findViewById(R.id.textView26);
            linearLayout =(LinearLayout)itemView.findViewById(R.id.expand_instructor);
            linearLayout2 =(LinearLayout)itemView.findViewById(R.id.instructor_hide);
            cardView = (CardView)itemView.findViewById(R.id.card2);
            imageView = (ImageView)itemView.findViewById(R.id.imageView420);
        }
    }
}
