package com.example.ewulife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CgpaActivity extends AppCompatActivity implements View.OnClickListener {
LinearLayout linearLayout,adcg1,adcg2,adcg3,adcg4,adcg5,adcg6,adcg7,adcg8,adcg9,adcg10,res_la;
Button add_cour,result;
ImageView rem1,rem2,rem3,rem4,rem5,rem6,rem7,rem8,rem9,rem10;
EditText editcg1,editcg2,editcg3,editcg4,editcg5,editcg6,editcg7,editcg8,editcg9,editcg10,manual_cre,manual_cgpa;
Spinner spin1,spin2,spin3,spin4,spin5,spin6,spin7,spin8,spin9,spin10;
TextView cgpa_result;
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

    double g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,gSum,gMan;
    double c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,cSum,cMan;
List<String> cgpa_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        linearLayout = findViewById(R.id.linearLayoutList);
        add_cour = findViewById(R.id.add_button);

        cgpa_result=findViewById(R.id.textView17);
        res_la=findViewById(R.id.result_lay);
        rem2=findViewById(R.id.remove_course2);
        rem3=findViewById(R.id.remove_course3);
        rem4=findViewById(R.id.remove_course4);
        rem5=findViewById(R.id.remove_course5);
        rem6=findViewById(R.id.remove_course6);
        rem7=findViewById(R.id.remove_course7);
        rem8=findViewById(R.id.remove_course8);
        rem9=findViewById(R.id.remove_course9);
        rem10=findViewById(R.id.remove_course10);

        editcg1=findViewById(R.id.cgpa_credit1);
        editcg2=findViewById(R.id.cgpa_credit2);
        editcg3=findViewById(R.id.cgpa_credit3);
        editcg4=findViewById(R.id.cgpa_credit4);
        editcg5=findViewById(R.id.cgpa_credit5);
        editcg6=findViewById(R.id.cgpa_credit6);
        editcg7=findViewById(R.id.cgpa_credit7);
        editcg8=findViewById(R.id.cgpa_credit8);
        editcg9=findViewById(R.id.cgpa_credit9);
        editcg10=findViewById(R.id.cgpa_credit10);

        spin1 = findViewById(R.id.spinner_grade1);
        spin2 = findViewById(R.id.spinner_grade2);
        spin3 = findViewById(R.id.spinner_grade3);
        spin4 = findViewById(R.id.spinner_grade4);
        spin5 = findViewById(R.id.spinner_grade5);
        spin6 = findViewById(R.id.spinner_grade6);
        spin7 = findViewById(R.id.spinner_grade7);
        spin8 = findViewById(R.id.spinner_grade8);
        spin9 = findViewById(R.id.spinner_grade9);
        spin10 = findViewById(R.id.spinner_grade10);

        adcg1 =findViewById(R.id.add_lay1);
        adcg2 =findViewById(R.id.add_lay2);
        adcg3 =findViewById(R.id.add_lay3);
        adcg4 =findViewById(R.id.add_lay4);
        adcg5 =findViewById(R.id.add_lay5);
        adcg6 =findViewById(R.id.add_lay6);
        adcg7 =findViewById(R.id.add_lay7);
        adcg8 =findViewById(R.id.add_lay8);
        adcg9 =findViewById(R.id.add_lay9);
        adcg10 =findViewById(R.id.add_lay10);

         result =findViewById(R.id.result_button);
         manual_cre = findViewById(R.id.manual_credit);
         manual_cgpa = findViewById(R.id.cgpa);


        rem2.setOnClickListener(this);
        rem3.setOnClickListener(this);
        rem4.setOnClickListener(this);
        rem5.setOnClickListener(this);
        rem6.setOnClickListener(this);
        rem7.setOnClickListener(this);
        rem8.setOnClickListener(this);
        rem9.setOnClickListener(this);
        rem10.setOnClickListener(this);
        add_cour.setOnClickListener(this);
        result.setOnClickListener(this);
        cgpa_list.add("Select Grade");
        cgpa_list.add("A+");
        cgpa_list.add("A");
        cgpa_list.add("A-");
        cgpa_list.add("B+");
        cgpa_list.add("B");
        cgpa_list.add("B-");
        cgpa_list.add("C+");
        cgpa_list.add("C");
        cgpa_list.add("C-");
        cgpa_list.add("D+");
        cgpa_list.add("D");
        cgpa_list.add("F");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cgpa_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(arrayAdapter);

        spin2.setAdapter(arrayAdapter);
        spin3.setAdapter(arrayAdapter);
        spin4.setAdapter(arrayAdapter);
        spin5.setAdapter(arrayAdapter);
        spin6.setAdapter(arrayAdapter);
        spin7.setAdapter(arrayAdapter);
        spin8.setAdapter(arrayAdapter);
        spin9.setAdapter(arrayAdapter);
        spin10.setAdapter(arrayAdapter);
        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          //  @Override
           // public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // string tutorialsName = parent.getItemAtPosition(position).toString();
               // Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
           // }
            //@Override
          //  public void onNothingSelected(AdapterView <?> parent) {
          //  }
       // });
    }

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.add_button){
            if(n>9){
                n=9;
            }
            n++;
            if(n==1){
                adcg2.setVisibility(View.VISIBLE);
            }
            if(n==2){
                adcg3.setVisibility(View.VISIBLE);
            }
            if(n==3){
                adcg4.setVisibility(View.VISIBLE);
            }
            if(n==4){
                adcg5.setVisibility(View.VISIBLE);
            }
            if(n==5){
                adcg6.setVisibility(View.VISIBLE);
            }
            if(n==6){
                adcg7.setVisibility(View.VISIBLE);
            }
            if(n==7){
                adcg8.setVisibility(View.VISIBLE);
            }
            if(n==8){
                adcg9.setVisibility(View.VISIBLE);
            }if(n==9){
                adcg10.setVisibility(View.VISIBLE);
               add_cour.setVisibility(View.GONE);
            }

        }
        if((v.getId()==R.id.remove_course2)||(v.getId()==R.id.remove_course3)||(v.getId()==R.id.remove_course4)||(v.getId()==R.id.remove_course5)
           ||(v.getId()==R.id.remove_course7)||(v.getId()==R.id.remove_course8)||(v.getId()==R.id.remove_course6)||(v.getId()==R.id.remove_course9)||(v.getId()==R.id.remove_course10)){

            if(n==1){
                adcg2.setVisibility(View.GONE);
            }
            if(n==2){
                adcg3.setVisibility(View.GONE);
            }
            if(n==3){
                adcg4.setVisibility(View.GONE);
            }
            if(n==4){
                adcg5.setVisibility(View.GONE);
            }
            if(n==5){
                adcg6.setVisibility(View.GONE);
            }
            if(n==6){
                adcg7.setVisibility(View.GONE);
            }
            if(n==7){
                adcg8.setVisibility(View.GONE);
            }
            if(n==8){
                adcg9.setVisibility(View.GONE);
                add_cour.setVisibility(View.VISIBLE);
            }if(n==9){
                adcg10.setVisibility(View.GONE);
                add_cour.setVisibility(View.VISIBLE);
            }
            n--;
        }


        if(v.getId()==R.id.result_button){

            String man1=manual_cre.getText().toString();

            if(TextUtils.isEmpty(man1)){
                man1="0";
            }
            cMan=Double.parseDouble(man1);
            if(cMan > 200 || cMan < 0){
                manual_cgpa.setError("Enter Credit <200 and >0 ");
                return;
            }
           String man2=manual_cgpa.getText().toString();

            if(TextUtils.isEmpty(man2)){
                man2="0";
            }
            gMan=Double.parseDouble(man2);
            if((gMan>4)||(gMan<0)){
                manual_cgpa.setError("Enter Credit <=4 and >=0 ");
                return;
            }
            final double crossT=cMan*gMan;
            if(n==0){

                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                     g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                 g1=c;
                }
                if(letter_grade1.equals("C-")){
                     g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                     g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                     g1=d;
                }
                if(letter_grade1.equals("F")){
                     g1=f;
                }
                c1=Double.parseDouble(credit1);
                cSum=c1*g1;

                gSum=(crossT+cSum)/(cMan+c1);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();

                
            }
            if(n==1){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Reason");
                    return;
                }
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }

                // convert letter grade to cgpa

                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                     g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                     g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                     g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                     g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                     g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                     g1=c;
                }
                if(letter_grade1.equals("C-")){
                     g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                     g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                     g1=d;
                }
                if(letter_grade1.equals("F")){
                     g1=f;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Reason");
                    return;
                }
                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // convert letter grade to cgpa
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                     g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                     g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                     g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                     g2=b;
                }
                if(letter_grade2.equals("B-")){
                     g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                     g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                     g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                     g2=d;
                }
                if(letter_grade2.equals("F")){
                     g2=f;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                cSum=(c1*g1)+(c2*g2);

                gSum=(crossT+cSum)/(cMan+c1+c2);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();

            }
            if(n==2){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // convert grade to cgpa

                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // convert letter grade to cgpa
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // convert letter grade to cgpa
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                cSum=(c1*g1)+(c2*g2)+(c3*g3);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                gSum=(crossT+cSum)/(cMan+c1+c2+c3);

                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();

            }
            if(n==3){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // convert grade to cgpa

                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // convert grade to cgpa

                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();

            }
            if(n==4){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String credit5=editcg5.getText().toString();
                if(TextUtils.isEmpty(credit5)){
                    editcg5.setError("Enter Credit");
                    return;
                }
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }

                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }

                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }

                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                final String letter_grade5 = spin5.getSelectedItem().toString();
                if (letter_grade5.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade5.equals("A+"))||(letter_grade5.equals("A"))){
                    g5=a_plus;
                }
                if(letter_grade5.equals("A-")){
                    g5=a_minus;
                }
                if(letter_grade5.equals("B+")){
                    g5=b_plus;
                }
                if(letter_grade5.equals("B")){
                    g5=b;
                }
                if(letter_grade5.equals("B-")){
                    g5=b_minus;
                }
                if(letter_grade5.equals("C+")){
                    g5=c_plus;
                }
                if(letter_grade5.equals("C")){
                    g5=c;
                }
                if(letter_grade5.equals("C-")){
                    g5=c_minus;
                }
                if(letter_grade5.equals("D+")){
                    g5=d_plus;
                }
                if(letter_grade5.equals("D")){
                    g5=d;
                }
                if(letter_grade5.equals("F")){
                    g5=f;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                c5=Double.parseDouble(credit5);
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4)+(c4*g5);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4+c5);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();

            }
            if(n==5){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String credit5=editcg5.getText().toString();
                if(TextUtils.isEmpty(credit5)){
                    editcg5.setError("Enter Credit");
                    return;
                }
                final String credit6=editcg6.getText().toString();
                if(TextUtils.isEmpty(credit6)){
                    editcg6.setError("Enter Credit");
                    return;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                c5=Double.parseDouble(credit5);
                c6=Double.parseDouble(credit6);

                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }

                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }

                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }

                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                final String letter_grade5 = spin5.getSelectedItem().toString();
                if (letter_grade5.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade5.equals("A+"))||(letter_grade5.equals("A"))){
                    g5=a_plus;
                }
                if(letter_grade5.equals("A-")){
                    g5=a_minus;
                }
                if(letter_grade5.equals("B+")){
                    g5=b_plus;
                }
                if(letter_grade5.equals("B")){
                    g5=b;
                }
                if(letter_grade5.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade5.equals("C+")){
                    g5=c_plus;
                }
                if(letter_grade5.equals("C")){
                    g5=c;
                }
                if(letter_grade5.equals("C-")){
                    g5=c_minus;
                }
                if(letter_grade5.equals("D+")){
                    g5=d_plus;
                }
                if(letter_grade5.equals("D")){
                    g5=d;
                }
                if(letter_grade5.equals("F")){
                    g5=f;
                }
                final String letter_grade6 = spin6.getSelectedItem().toString();
                if (letter_grade6.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade6.equals("A+"))||(letter_grade6.equals("A"))){
                    g6=a_plus;
                }
                if(letter_grade6.equals("A-")){
                    g6=a_minus;
                }
                if(letter_grade6.equals("B+")){
                    g6=b_plus;
                }
                if(letter_grade6.equals("B")){
                    g6=b;
                }
                if(letter_grade6.equals("B-")){
                    g6=b_minus;
                }
                if(letter_grade6.equals("C+")){
                    g6=c_plus;
                }
                if(letter_grade6.equals("C")){
                    g6=c;
                }
                if(letter_grade6.equals("C-")){
                    g6=c_minus;
                }
                if(letter_grade6.equals("D+")){
                    g6=d_plus;
                }
                if(letter_grade6.equals("D")){
                    g6=d;
                }
                if(letter_grade6.equals("F")){
                    g6=f;
                }
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4)+(c5*g5)+(c6*g6);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4+c5+c6);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();

            }
            if(n==6){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String credit5=editcg5.getText().toString();
                if(TextUtils.isEmpty(credit5)){
                    editcg5.setError("Enter Credit");
                    return;
                }
                final String credit6=editcg6.getText().toString();
                if(TextUtils.isEmpty(credit6)){
                    editcg6.setError("Enter Credit");
                    return;
                }
                final String credit7=editcg7.getText().toString();
                if(TextUtils.isEmpty(credit7)){
                    editcg7.setError("Enter Credit");
                    return;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                c5=Double.parseDouble(credit5);
                c6=Double.parseDouble(credit6);
                c7=Double.parseDouble(credit7);

                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }

                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }

                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }
                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                final String letter_grade5 = spin5.getSelectedItem().toString();
                if (letter_grade5.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade5.equals("A+"))||(letter_grade5.equals("A"))){
                    g5=a_plus;
                }
                if(letter_grade5.equals("A-")){
                    g5=a_minus;
                }
                if(letter_grade5.equals("B+")){
                    g5=b_plus;
                }
                if(letter_grade5.equals("B")){
                    g5=b;
                }
                if(letter_grade5.equals("B-")){
                    g5=b_minus;
                }
                if(letter_grade5.equals("C+")){
                    g5=c_plus;
                }
                if(letter_grade5.equals("C")){
                    g5=c;
                }
                if(letter_grade5.equals("C-")){
                    g5=c_minus;
                }
                if(letter_grade5.equals("D+")){
                    g5=d_plus;
                }
                if(letter_grade5.equals("D")){
                    g5=d;
                }
                if(letter_grade5.equals("F")){
                    g5=f;
                }
                final String letter_grade6 = spin6.getSelectedItem().toString();
                if (letter_grade6.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade6.equals("A+"))||(letter_grade6.equals("A"))){
                    g6=a_plus;
                }
                if(letter_grade6.equals("A-")){
                    g6=a_minus;
                }
                if(letter_grade6.equals("B+")){
                    g6=b_plus;
                }
                if(letter_grade6.equals("B")){
                    g6=b;
                }
                if(letter_grade6.equals("B-")){
                    g6=b_minus;
                }
                if(letter_grade6.equals("C+")){
                    g6=c_plus;
                }
                if(letter_grade6.equals("C")){
                    g6=c;
                }
                if(letter_grade6.equals("C-")){
                    g6=c_minus;
                }
                if(letter_grade6.equals("D+")){
                    g6=d_plus;
                }
                if(letter_grade6.equals("D")){
                    g6=d;
                }
                if(letter_grade6.equals("F")){
                    g6=f;
                }
                final String letter_grade7 = spin7.getSelectedItem().toString();
                if (letter_grade7.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade7.equals("A+"))||(letter_grade7.equals("A"))){
                    g7=a_plus;
                }
                if(letter_grade7.equals("A-")){
                    g7=a_minus;
                }
                if(letter_grade7.equals("B+")){
                    g7=b_plus;
                }
                if(letter_grade7.equals("B")){
                    g7=b;
                }
                if(letter_grade7.equals("B-")){
                    g7=b_minus;
                }
                if(letter_grade7.equals("C+")){
                    g7=c_plus;
                }
                if(letter_grade7.equals("C")){
                    g7=c;
                }
                if(letter_grade7.equals("C-")){
                    g7=c_minus;
                }
                if(letter_grade7.equals("D+")){
                    g7=d_plus;
                }
                if(letter_grade7.equals("D")){
                    g7=d;
                }
                if(letter_grade7.equals("F")){
                    g7=f;
                }
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4)+(c5*g5)+(c6*g6)+(c7*g7);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4+c5+c6+c7);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();
            }
            if(n==7){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String credit5=editcg5.getText().toString();
                if(TextUtils.isEmpty(credit5)){
                    editcg5.setError("Enter Credit");
                    return;
                }
                final String credit6=editcg6.getText().toString();
                if(TextUtils.isEmpty(credit6)){
                    editcg6.setError("Enter Credit");
                    return;
                }
                final String credit7=editcg7.getText().toString();
                if(TextUtils.isEmpty(credit7)){
                    editcg7.setError("Enter Credit");
                    return;
                }
                final String credit8=editcg8.getText().toString();
                if(TextUtils.isEmpty(credit8)){
                    editcg8.setError("Enter Credit");
                    return;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                c5=Double.parseDouble(credit5);
                c6=Double.parseDouble(credit6);
                c7=Double.parseDouble(credit7);
                c8=Double.parseDouble(credit8);
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }

                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }

                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }

                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                final String letter_grade5 = spin5.getSelectedItem().toString();
                if (letter_grade5.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade5.equals("A+"))||(letter_grade5.equals("A"))){
                    g5=a_plus;
                }
                if(letter_grade5.equals("A-")){
                    g5=a_minus;
                }
                if(letter_grade5.equals("B+")){
                    g5=b_plus;
                }
                if(letter_grade5.equals("B")){
                    g5=b;
                }
                if(letter_grade5.equals("B-")){
                    g5=b_minus;
                }
                if(letter_grade5.equals("C+")){
                    g5=c_plus;
                }
                if(letter_grade5.equals("C")){
                    g5=c;
                }
                if(letter_grade5.equals("C-")){
                    g5=c_minus;
                }
                if(letter_grade5.equals("D+")){
                    g5=d_plus;
                }
                if(letter_grade5.equals("D")){
                    g5=d;
                }
                if(letter_grade5.equals("F")){
                    g5=f;
                }
                final String letter_grade6 = spin6.getSelectedItem().toString();
                if (letter_grade6.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade6.equals("A+"))||(letter_grade6.equals("A"))){
                    g6=a_plus;
                }
                if(letter_grade6.equals("A-")){
                    g6=a_minus;
                }
                if(letter_grade6.equals("B+")){
                    g6=b_plus;
                }
                if(letter_grade6.equals("B")){
                    g6=b;
                }
                if(letter_grade6.equals("B-")){
                    g6=b_minus;
                }
                if(letter_grade6.equals("C+")){
                    g6=c_plus;
                }
                if(letter_grade6.equals("C")){
                    g6=c;
                }
                if(letter_grade6.equals("C-")){
                    g6=c_minus;
                }
                if(letter_grade6.equals("D+")){
                    g6=d_plus;
                }
                if(letter_grade6.equals("D")){
                    g6=d;
                }
                if(letter_grade6.equals("F")){
                    g6=f;
                }
                final String letter_grade7 = spin7.getSelectedItem().toString();
                if (letter_grade7.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade7.equals("A+"))||(letter_grade7.equals("A"))){
                    g7=a_plus;
                }
                if(letter_grade7.equals("A-")){
                    g7=a_minus;
                }
                if(letter_grade7.equals("B+")){
                    g7=b_plus;
                }
                if(letter_grade7.equals("B")){
                    g7=b;
                }
                if(letter_grade7.equals("B-")){
                    g7=b_minus;
                }
                if(letter_grade7.equals("C+")){
                    g7=c_plus;
                }
                if(letter_grade7.equals("C")){
                    g7=c;
                }
                if(letter_grade7.equals("C-")){
                    g7=c_minus;
                }
                if(letter_grade7.equals("D+")){
                    g7=d_plus;
                }
                if(letter_grade7.equals("D")){
                    g7=d;
                }
                if(letter_grade7.equals("F")){
                    g7=f;
                }
                final String letter_grade8 = spin8.getSelectedItem().toString();
                if (letter_grade8.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4)+(c5*g5)+(c6*g6)+(c7*g7)+(c8*g8);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4+c5+c6+c7+c8);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();
            }
            if(n==8){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String credit5=editcg5.getText().toString();
                if(TextUtils.isEmpty(credit5)){
                    editcg5.setError("Enter Credit");
                    return;
                }
                final String credit6=editcg6.getText().toString();
                if(TextUtils.isEmpty(credit6)){
                    editcg6.setError("Enter Credit");
                    return;
                }
                final String credit7=editcg7.getText().toString();
                if(TextUtils.isEmpty(credit7)){
                    editcg7.setError("Enter Credit");
                    return;
                }
                final String credit8=editcg8.getText().toString();
                if(TextUtils.isEmpty(credit8)){
                    editcg8.setError("Enter Credit");
                    return;
                }
                final String credit9=editcg9.getText().toString();
                if(TextUtils.isEmpty(credit9)){
                    editcg9.setError("Enter Credit");
                    return;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                c5=Double.parseDouble(credit5);
                c6=Double.parseDouble(credit6);
                c7=Double.parseDouble(credit7);
                c8=Double.parseDouble(credit8);
                c9=Double.parseDouble(credit9);

                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }

                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }

                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }
                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                final String letter_grade5 = spin5.getSelectedItem().toString();
                if (letter_grade5.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade5.equals("A+"))||(letter_grade5.equals("A"))){
                    g5=a_plus;
                }
                if(letter_grade5.equals("A-")){
                    g5=a_minus;
                }
                if(letter_grade5.equals("B+")){
                    g5=b_plus;
                }
                if(letter_grade5.equals("B")){
                    g5=b;
                }
                if(letter_grade5.equals("B-")){
                    g5=b_minus;
                }
                if(letter_grade5.equals("C+")){
                    g5=c_plus;
                }
                if(letter_grade5.equals("C")){
                    g5=c;
                }
                if(letter_grade5.equals("C-")){
                    g5=c_minus;
                }
                if(letter_grade5.equals("D+")){
                    g5=d_plus;
                }
                if(letter_grade5.equals("D")){
                    g5=d;
                }
                if(letter_grade5.equals("F")){
                    g5=f;
                }
                final String letter_grade6 = spin6.getSelectedItem().toString();
                if (letter_grade6.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade6.equals("A+"))||(letter_grade6.equals("A"))){
                    g6=a_plus;
                }
                if(letter_grade6.equals("A-")){
                    g6=a_minus;
                }
                if(letter_grade6.equals("B+")){
                    g6=b_plus;
                }
                if(letter_grade6.equals("B")){
                    g6=b;
                }
                if(letter_grade6.equals("B-")){
                    g6=b_minus;
                }
                if(letter_grade6.equals("C+")){
                    g6=c_plus;
                }
                if(letter_grade6.equals("C")){
                    g6=c;
                }
                if(letter_grade6.equals("C-")){
                    g6=c_minus;
                }
                if(letter_grade6.equals("D+")){
                    g6=d_plus;
                }
                if(letter_grade6.equals("D")){
                    g6=d;
                }
                if(letter_grade6.equals("F")){
                    g6=f;
                }
                final String letter_grade7 = spin7.getSelectedItem().toString();
                if (letter_grade7.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade7.equals("A+"))||(letter_grade7.equals("A"))){
                    g7=a_plus;
                }
                if(letter_grade7.equals("A-")){
                    g7=a_minus;
                }
                if(letter_grade7.equals("B+")){
                    g7=b_plus;
                }
                if(letter_grade7.equals("B")){
                    g7=b;
                }
                if(letter_grade7.equals("B-")){
                    g7=b_minus;
                }
                if(letter_grade7.equals("C+")){
                    g7=c_plus;
                }
                if(letter_grade7.equals("C")){
                    g7=c;
                }
                if(letter_grade7.equals("C-")){
                    g7=c_minus;
                }
                if(letter_grade7.equals("D+")){
                    g7=d_plus;
                }
                if(letter_grade7.equals("D")){
                    g7=d;
                }
                if(letter_grade7.equals("F")){
                    g7=f;
                }
                final String letter_grade8 = spin8.getSelectedItem().toString();
                if (letter_grade8.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade8.equals("A+"))||(letter_grade8.equals("A"))){
                    g8=a_plus;
                }
                if(letter_grade8.equals("A-")){
                    g8=a_minus;
                }
                if(letter_grade8.equals("B+")){
                    g8=b_plus;
                }
                if(letter_grade8.equals("B")){
                    g8=b;
                }
                if(letter_grade8.equals("B-")){
                    g8=b_minus;
                }
                if(letter_grade8.equals("C+")){
                    g8=c_plus;
                }
                if(letter_grade8.equals("C")){
                    g8=c;
                }
                if(letter_grade8.equals("C-")){
                    g8=c_minus;
                }
                if(letter_grade8.equals("D+")){
                    g8=d_plus;
                }
                if(letter_grade8.equals("D")){
                    g8=d;
                }
                if(letter_grade8.equals("F")){
                    g8=f;
                }
                final String letter_grade9 = spin9.getSelectedItem().toString();
                if (letter_grade9.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade9.equals("A+"))||(letter_grade9.equals("A"))){
                    g9=a_plus;
                }
                if(letter_grade9.equals("A-")){
                    g9=a_minus;
                }
                if(letter_grade9.equals("B+")){
                    g9=b_plus;
                }
                if(letter_grade9.equals("B")){
                    g9=b;
                }
                if(letter_grade9.equals("B-")){
                    g9=b_minus;
                }
                if(letter_grade9.equals("C+")){
                    g9=c_plus;
                }
                if(letter_grade9.equals("C")){
                    g9=c;
                }
                if(letter_grade9.equals("C-")){
                    g9=c_minus;
                }
                if(letter_grade9.equals("D+")){
                    g9=d_plus;
                }
                if(letter_grade9.equals("D")){
                    g9=d;
                }
                if(letter_grade9.equals("F")){
                    g9=f;
                }
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4)+(c5*g5)+(c6*g6)+(c7*g7)+(c8*g8)+(c9*g9);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4+c5+c6+c7+c8+c9);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();
            }
            if(n==9){
                final String credit1=editcg1.getText().toString();
                if(TextUtils.isEmpty(credit1)){
                    editcg1.setError("Enter Credit");
                    return;
                }
                final String credit2=editcg2.getText().toString();
                if(TextUtils.isEmpty(credit2)){
                    editcg2.setError("Enter Credit");
                    return;
                }
                final String credit3=editcg3.getText().toString();
                if(TextUtils.isEmpty(credit3)){
                    editcg3.setError("Enter Credit");
                    return;
                }
                final String credit4=editcg4.getText().toString();
                if(TextUtils.isEmpty(credit4)){
                    editcg4.setError("Enter Credit");
                    return;
                }
                final String credit5=editcg5.getText().toString();
                if(TextUtils.isEmpty(credit5)){
                    editcg5.setError("Enter Credit");
                    return;
                }
                final String credit6=editcg6.getText().toString();
                if(TextUtils.isEmpty(credit6)){
                    editcg6.setError("Enter Credit");
                    return;
                }
                final String credit7=editcg7.getText().toString();
                if(TextUtils.isEmpty(credit7)){
                    editcg7.setError("Enter Credit");
                    return;
                }
                final String credit8=editcg8.getText().toString();
                if(TextUtils.isEmpty(credit8)){
                    editcg8.setError("Enter Credit");
                    return;
                }
                final String credit9=editcg9.getText().toString();
                if(TextUtils.isEmpty(credit9)){
                    editcg9.setError("Enter Credit");
                    return;
                }
                final String credit10=editcg10.getText().toString();
                if(TextUtils.isEmpty(credit10)){
                    editcg10.setError("Enter Credit");
                    return;
                }
                c1=Double.parseDouble(credit1);
                c2=Double.parseDouble(credit2);
                c3=Double.parseDouble(credit3);
                c4=Double.parseDouble(credit4);
                c5=Double.parseDouble(credit5);
                c6=Double.parseDouble(credit6);
                c7=Double.parseDouble(credit7);
                c8=Double.parseDouble(credit8);
                c9=Double.parseDouble(credit9);
                c10=Double.parseDouble(credit10);
                final String letter_grade1 = spin1.getSelectedItem().toString();
                if (letter_grade1.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade1.equals("A+"))||(letter_grade1.equals("A"))){
                    g1=a_plus;
                }
                if(letter_grade1.equals("A-")){
                    g1=a_minus;
                }
                if(letter_grade1.equals("B+")){
                    g1=b_plus;
                }
                if(letter_grade1.equals("B")){
                    g1=b;
                }
                if(letter_grade1.equals("B-")){
                    g1=b_minus;
                }
                if(letter_grade1.equals("C+")){
                    g1=c_plus;
                }
                if(letter_grade1.equals("C")){
                    g1=c;
                }
                if(letter_grade1.equals("C-")){
                    g1=c_minus;
                }
                if(letter_grade1.equals("D+")){
                    g1=d_plus;
                }
                if(letter_grade1.equals("D")){
                    g1=d;
                }
                if(letter_grade1.equals("F")){
                    g1=f;
                }

                final String letter_grade2 = spin2.getSelectedItem().toString();
                if (letter_grade2.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade2.equals("A+"))||(letter_grade2.equals("A"))){
                    g2=a_plus;
                }
                if(letter_grade2.equals("A-")){
                    g2=a_minus;
                }
                if(letter_grade2.equals("B+")){
                    g2=b_plus;
                }
                if(letter_grade2.equals("B")){
                    g2=b;
                }
                if(letter_grade2.equals("B-")){
                    g2=b_minus;
                }
                if(letter_grade2.equals("C+")){
                    g2=c_plus;
                }
                if(letter_grade2.equals("C")){
                    g2=c;
                }
                if(letter_grade2.equals("C-")){
                    g2=c_minus;
                }
                if(letter_grade2.equals("D+")){
                    g2=d_plus;
                }
                if(letter_grade2.equals("D")){
                    g2=d;
                }
                if(letter_grade2.equals("F")){
                    g2=f;
                }

                final String letter_grade3 = spin3.getSelectedItem().toString();
                if (letter_grade3.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade3.equals("A+"))||(letter_grade3.equals("A"))){
                    g3=a_plus;
                }
                if(letter_grade3.equals("A-")){
                    g3=a_minus;
                }
                if(letter_grade3.equals("B+")){
                    g3=b_plus;
                }
                if(letter_grade3.equals("B")){
                    g3=b;
                }
                if(letter_grade3.equals("B-")){
                    g3=b_minus;
                }
                if(letter_grade3.equals("C+")){
                    g3=c_plus;
                }
                if(letter_grade3.equals("C")){
                    g3=c;
                }
                if(letter_grade3.equals("C-")){
                    g3=c_minus;
                }
                if(letter_grade3.equals("D+")){
                    g3=d_plus;
                }
                if(letter_grade3.equals("D")){
                    g3=d;
                }
                if(letter_grade3.equals("F")){
                    g3=f;
                }

                final String letter_grade4 = spin4.getSelectedItem().toString();
                if (letter_grade4.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade4.equals("A+"))||(letter_grade4.equals("A"))){
                    g4=a_plus;
                }
                if(letter_grade4.equals("A-")){
                    g4=a_minus;
                }
                if(letter_grade4.equals("B+")){
                    g4=b_plus;
                }
                if(letter_grade4.equals("B")){
                    g4=b;
                }
                if(letter_grade4.equals("B-")){
                    g4=b_minus;
                }
                if(letter_grade4.equals("C+")){
                    g4=c_plus;
                }
                if(letter_grade4.equals("C")){
                    g4=c;
                }
                if(letter_grade4.equals("C-")){
                    g4=c_minus;
                }
                if(letter_grade4.equals("D+")){
                    g4=d_plus;
                }
                if(letter_grade4.equals("D")){
                    g4=d;
                }
                if(letter_grade4.equals("F")){
                    g4=f;
                }
                final String letter_grade5 = spin5.getSelectedItem().toString();
                if (letter_grade5.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade5.equals("A+"))||(letter_grade5.equals("A"))){
                    g5=a_plus;
                }
                if(letter_grade5.equals("A-")){
                    g5=a_minus;
                }
                if(letter_grade5.equals("B+")){
                    g5=b_plus;
                }
                if(letter_grade5.equals("B")){
                    g5=b;
                }
                if(letter_grade5.equals("B-")){
                    g5=b_minus;
                }
                if(letter_grade5.equals("C+")){
                    g5=c_plus;
                }
                if(letter_grade5.equals("C")){
                    g5=c;
                }
                if(letter_grade5.equals("C-")){
                    g5=c_minus;
                }
                if(letter_grade5.equals("D+")){
                    g5=d_plus;
                }
                if(letter_grade5.equals("D")){
                    g5=d;
                }
                if(letter_grade5.equals("F")){
                    g5=f;
                }
                final String letter_grade6 = spin6.getSelectedItem().toString();
                if (letter_grade6.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade6.equals("A+"))||(letter_grade6.equals("A"))){
                    g6=a_plus;
                }
                if(letter_grade6.equals("A-")){
                    g6=a_minus;
                }
                if(letter_grade6.equals("B+")){
                    g6=b_plus;
                }
                if(letter_grade6.equals("B")){
                    g6=b;
                }
                if(letter_grade6.equals("B-")){
                    g6=b_minus;
                }
                if(letter_grade6.equals("C+")){
                    g6=c_plus;
                }
                if(letter_grade6.equals("C")){
                    g6=c;
                }
                if(letter_grade6.equals("C-")){
                    g6=c_minus;
                }
                if(letter_grade6.equals("D+")){
                    g6=d_plus;
                }
                if(letter_grade6.equals("D")){
                    g6=d;
                }
                if(letter_grade6.equals("F")){
                    g6=f;
                }
                final String letter_grade7 = spin7.getSelectedItem().toString();
                if (letter_grade7.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade7.equals("A+"))||(letter_grade7.equals("A"))){
                    g7=a_plus;
                }
                if(letter_grade7.equals("A-")){
                    g7=a_minus;
                }
                if(letter_grade7.equals("B+")){
                    g7=b_plus;
                }
                if(letter_grade7.equals("B")){
                    g7=b;
                }
                if(letter_grade7.equals("B-")){
                    g7=b_minus;
                }
                if(letter_grade7.equals("C+")){
                    g7=c_plus;
                }
                if(letter_grade7.equals("C")){
                    g7=c;
                }
                if(letter_grade7.equals("C-")){
                    g7=c_minus;
                }
                if(letter_grade7.equals("D+")){
                    g7=d_plus;
                }
                if(letter_grade7.equals("D")){
                    g7=d;
                }
                if(letter_grade7.equals("F")){
                    g7=f;
                }
                final String letter_grade8 = spin8.getSelectedItem().toString();
                if (letter_grade8.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade8.equals("A+"))||(letter_grade8.equals("A"))){
                    g8=a_plus;
                }
                if(letter_grade8.equals("A-")){
                    g8=a_minus;
                }
                if(letter_grade8.equals("B+")){
                    g8=b_plus;
                }
                if(letter_grade8.equals("B")){
                    g8=b;
                }
                if(letter_grade8.equals("B-")){
                    g8=b_minus;
                }
                if(letter_grade8.equals("C+")){
                    g8=c_plus;
                }
                if(letter_grade8.equals("C")){
                    g8=c;
                }
                if(letter_grade8.equals("C-")){
                    g8=c_minus;
                }
                if(letter_grade8.equals("D+")){
                    g8=d_plus;
                }
                if(letter_grade8.equals("D")){
                    g8=d;
                }
                if(letter_grade8.equals("F")){
                    g8=f;
                }
                final String letter_grade9 = spin9.getSelectedItem().toString();
                if (letter_grade9.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade9.equals("A+"))||(letter_grade9.equals("A"))){
                    g9=a_plus;
                }
                if(letter_grade9.equals("A-")){
                    g9=a_minus;
                }
                if(letter_grade9.equals("B+")){
                    g9=b_plus;
                }
                if(letter_grade9.equals("B")){
                    g9=b;
                }
                if(letter_grade9.equals("B-")){
                    g9=b_minus;
                }
                if(letter_grade9.equals("C+")){
                    g9=c_plus;
                }
                if(letter_grade9.equals("C")){
                    g9=c;
                }
                if(letter_grade9.equals("C-")){
                    g9=c_minus;
                }
                if(letter_grade9.equals("D+")){
                    g9=d_plus;
                }
                if(letter_grade9.equals("D")){
                    g9=d;
                }
                if(letter_grade9.equals("F")){
                    g9=f;
                }
                final String letter_grade10 = spin10.getSelectedItem().toString();
                if (letter_grade10.equals("Select Grade")){
                    Toast.makeText(CgpaActivity.this,"Grade not selected" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if((letter_grade10.equals("A+"))||(letter_grade10.equals("A"))){
                    g10=a_plus;
                }
                if(letter_grade10.equals("A-")){
                    g10=a_minus;
                }
                if(letter_grade10.equals("B+")){
                    g10=b_plus;
                }
                if(letter_grade10.equals("B")){
                    g10=b;
                }
                if(letter_grade10.equals("B-")){
                    g10=b_minus;
                }
                if(letter_grade10.equals("C+")){
                    g10=c_plus;
                }
                if(letter_grade10.equals("C")){
                    g10=c;
                }
                if(letter_grade10.equals("C-")){
                    g10=c_minus;
                }
                if(letter_grade10.equals("D+")){
                    g10=d_plus;
                }
                if(letter_grade10.equals("D")){
                    g10=d;
                }
                if(letter_grade10.equals("F")){
                    g10=f;
                }
                cSum=(c1*g1)+(c2*g2)+(c3*g3)+(c4*g4)+(c5*g5)+(c6*g6)+(c7*g7)+(c8*g8)+(c9*g9)+(c10*g10);

                gSum=(crossT+cSum)/(cMan+c1+c2+c3+c4+c5+c6+c7+c8+c9+c10);
                res_la.setVisibility(View.VISIBLE);
                cgpa_result.setText(String.valueOf(gSum));
                Toast.makeText(CgpaActivity.this,gSum+"" , Toast.LENGTH_SHORT).show();
            }






        }





    }


}