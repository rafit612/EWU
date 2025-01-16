package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GradingSystemActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt1,txt2,txt3,txt4;
    TextView txt5,txt6,txt7,txt8;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    LinearLayout table1,table2,table3,table4,table5,table6,table7,table8;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grading_system);
        txt1=findViewById(R.id.gts4);
        txt2=findViewById(R.id.gts5);
        txt3=findViewById(R.id.gView6);
        txt4=findViewById(R.id.gts2);
        txt5=findViewById(R.id.gts6);
        txt6=findViewById(R.id.gts);
        txt7=findViewById(R.id.gts1);
        txt8=findViewById(R.id.gtextView7);
        img1 =findViewById(R.id.gimageView6);
        img2 =findViewById(R.id.gimageView8);
        img3 =findViewById(R.id.gimageView1);
        img4 =findViewById(R.id.gimageView4);
        img5 =findViewById(R.id.gimageView9);
        img6 =findViewById(R.id.gimageView2);
        img7 =findViewById(R.id.gimageView3);
        img8 =findViewById(R.id.gimageView5);

        cardView = findViewById(R.id.g_main_list);
        table1 = findViewById(R.id.gtb7);
        table2 = findViewById(R.id.gtb8);
        table3 = findViewById(R.id.gtb1);
        table4 = findViewById(R.id.gtb5);
        table5 = findViewById(R.id.gtb9);
        table6 = findViewById(R.id.gtb2);
        table7 = findViewById(R.id.gtb3);
        table8 = findViewById(R.id.gtb6);


        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt4.setOnClickListener(this);
        txt5.setOnClickListener(this);
        txt6.setOnClickListener(this);
        txt7.setOnClickListener(this);
        txt8.setOnClickListener(this);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);

        Toast.makeText(GradingSystemActivity.this, "Click Item To see Detail", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        if ((v.getId() == R.id.gts4)||(v.getId() == R.id.gimageView6)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
            (table7.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table1.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table1.setVisibility(View.VISIBLE);
                img1.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
            }
        }
        if ((v.getId() == R.id.gts5)||(v.getId() == R.id.gimageView9)) {
            if ((table1.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
                    (table7.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table2.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.VISIBLE);
                img2.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
            }

        }
        if ((v.getId() == R.id.gView6)||(v.getId() == R.id.gimageView1)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table1.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
                    (table7.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table3.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table3.setVisibility(View.VISIBLE);
                img3.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
            }
        }
        if ((v.getId() == R.id.gts2)||(v.getId() == R.id.gimageView4)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table1.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
                    (table7.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table4.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table4.setVisibility(View.VISIBLE);
                img4.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
            }
        }
        if ((v.getId() == R.id.gts6)||(v.getId() == R.id.gimageView9)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table1.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
                    (table7.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table5.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table5.setVisibility(View.VISIBLE);
                img5.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
            }
        }
        if ((v.getId() == R.id.gts)||(v.getId() == R.id.gimageView2)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table1.getVisibility()==View.VISIBLE)||
                    (table7.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table6.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table6.setVisibility(View.VISIBLE);
                img6.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
            }
        }
        if ((v.getId() == R.id.gts1)||(v.getId() == R.id.gimageView3)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
                    (table1.getVisibility()==View.VISIBLE)||(table8.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
            if (table7.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table7.setVisibility(View.VISIBLE);
                img7.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
            }
        }
        if ((v.getId() == R.id.gtextView7)||(v.getId() == R.id.gimageView5)) {
            if ((table2.getVisibility()==View.VISIBLE)||(table3.getVisibility()==View.VISIBLE)||
                    (table4.getVisibility()==View.VISIBLE)||(table5.getVisibility()==View.VISIBLE)||(table6.getVisibility()==View.VISIBLE)||
                    (table7.getVisibility()==View.VISIBLE)||(table1.getVisibility()==View.VISIBLE)) {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table2.setVisibility(View.GONE);
                img2.setBackgroundResource(R.drawable.expand);
                table3.setVisibility(View.GONE);
                img3.setBackgroundResource(R.drawable.expand);
                table4.setVisibility(View.GONE);
                img4.setBackgroundResource(R.drawable.expand);
                table5.setVisibility(View.GONE);
                img5.setBackgroundResource(R.drawable.expand);
                table6.setVisibility(View.GONE);
                img6.setBackgroundResource(R.drawable.expand);
                table7.setVisibility(View.GONE);
                img7.setBackgroundResource(R.drawable.expand);
                table1.setVisibility(View.GONE);
                img1.setBackgroundResource(R.drawable.expand);
            }
            if (table8.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table8.setVisibility(View.VISIBLE);
                img8.setBackgroundResource(R.drawable.collapse);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                table8.setVisibility(View.GONE);
                img8.setBackgroundResource(R.drawable.expand);
            }
        }
    }
}