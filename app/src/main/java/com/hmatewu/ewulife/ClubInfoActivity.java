package com.hmatewu.ewulife;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

import java.net.URL;

public class ClubInfoActivity extends AppCompatActivity {
    public static final String EXTRA_NFID= "com.hm.roktojoddha.EXTRA_NFID";
    public static final String EXTRA_MOBILE= "com.hm.roktojoddha.EXTRA_MOBILE";
    public static final String EXTRA_ID= "com.hm.roktojoddha.EXTRA_ID";
    public static final String EXTRA_CLUB= "com.hm.roktojoddha.EXTRA_CLUB";
    public static final String EXTRA_CLUB_FORM= "com.hm.roktojoddha.EXTRA_CLUB_FORM";

    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    String userID2,nfid2;
    TextView club,title,descrip,date,time,place;
    Button form,page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_info);
        fAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        nfid2=intent.getStringExtra(FeedFragment.EXTRA_NFID);

        userID2=intent.getStringExtra(FeedFragment.EXTRA_ID);
       // Toast.makeText(ClubInfoActivity.this, ""+userID2+" "+nfid2, Toast.LENGTH_SHORT).show();
        fstore = FirebaseFirestore.getInstance();

        club = findViewById(R.id.text7club);
        title = findViewById(R.id.text11club);
        descrip = findViewById(R.id.text17club);
        date = findViewById(R.id.text98club);
        time = findViewById(R.id.text95club);
        place =findViewById(R.id.textView100club);
        form = findViewById(R.id.button11);
        page = findViewById(R.id.button12);

      final  String  UI = userID2;
      final  String NI =nfid2;


       // Log.d("userID", userID2);
       // Log.d("nfID", nfid2);

        DocumentReference documentReference = fstore.collection("Club_Detail").document(userID2).collection("History").document(nfid2);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                club.setText(documentSnapshot.getString("Club"));
                title.setText(documentSnapshot.getString("Title"));
                descrip.setText(documentSnapshot.getString("Description"));
                date.setText(documentSnapshot.getString("Date"));
                time.setText(documentSnapshot.getString("Time"));
                place.setText(documentSnapshot.getString("Places"));
                String url_check=documentSnapshot.getString("URL");
              //  Toast.makeText(ClubInfoActivity.this, ""+String.valueOf(NI), Toast.LENGTH_SHORT).show();


                String icheck=(documentSnapshot.getString("Club"));
                        if(icheck!=null){
                            LayoutInflater inflater = getLayoutInflater();                             ///custom toast//
                            View layout = inflater.inflate(R.layout.custom_admin_toast,(ViewGroup)findViewById(R.id.adtoast));
                            final Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_SHORT));
                            toast.setView(layout);
                        }
                        else{
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_error_admin_toast,(ViewGroup)findViewById(R.id.errorad));
                            final Toast toast1 = new Toast(getApplicationContext());
                            toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast1.setDuration((Toast.LENGTH_SHORT));
                            toast1.setView(layout1);
                        }

                DocumentReference documentReference9 = fstore.collection("Club_Detail").document(userID2).collection("History").document(nfid2);
                documentReference9.addSnapshotListener(ClubInfoActivity.this, new EventListener<DocumentSnapshot>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        final String news1=documentSnapshot.getString("Club");
                       if(news1.equals("EWU Notice")){
                           form.setText("Visit Link");
                       }

                    }
                });


                if (isValid(url_check)){
                // Toast.makeText(ClubInfoActivity.this, "Yes, URL is Valid", Toast.LENGTH_LONG).show();

                    form.setVisibility(View.VISIBLE);
                }

                else{
                  //Toast.makeText(ClubInfoActivity.this, "NO, URL is not Valid/All", Toast.LENGTH_LONG).show();
                    form.setVisibility(View.GONE);
                }

            }
        });

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DocumentReference documentReference3 = fstore.collection("Club_Detail").document(userID2).collection("History").document(nfid2);
                documentReference3.addSnapshotListener(ClubInfoActivity.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                        final String url1=documentSnapshot.getString("Club");
                        Intent intent = new Intent(ClubInfoActivity.this, ClubWebFromActivity.class);
                        intent.putExtra(EXTRA_CLUB_FORM, url1);
                        startActivity(intent);

                    }
                });

            }
        });
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference documentReference1 = fstore.collection("Club_Detail").document(userID2).collection("History").document(nfid2);
                documentReference1.addSnapshotListener(ClubInfoActivity.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                       String club_name = documentSnapshot.getString("Club");
                       if(club_name.equals("Agro Industrialization")){
                           Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/103160894764904"));
                           startActivity(intent);
                       }
                        if(club_name.equals("Creative Marketing")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1469755913307760"));
                            startActivity(intent);
                        }
                        if(club_name.equals("Club For Performing Arts")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/393648010662437"));
                            startActivity(intent);   //https://www.facebook.com/EWU.ECPA
                        }
                        if(club_name.equals("Bussiness")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/459252267511756"));
                            startActivity(intent);       //https://www.facebook.com/EWUBC
                        }
                        if(club_name.equals("Debating")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/107198719615400"));
                            startActivity(intent);      //https://www.facebook.com/ewudc
                        }
                        if(club_name.equals("Economics")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/231219780618950"));
                            startActivity(intent);   //https://www.facebook.com/ewueconomicsclub
                        }
                        if(club_name.equals("Electronics Programming and Robotics")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1509435916025800"));
                            startActivity(intent);   //https://www.facebook.com/ewuRoboticsClub
                        }
                        if(club_name.equals("English Conversation")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/212265778807446"));
                            startActivity(intent);  //https://www.facebook.com/EWUECC/
                        }
                        if(club_name.equals("Environmental and Social")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/610714095616773"));
                            startActivity(intent);     //https://www.facebook.com/ewuesc/
                        }
                        if(club_name.equals("Investment and Finance")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1231454686889509"));
                            startActivity(intent);  //https://www.facebook.com/EWUIFC.BD
                        }
                        if(club_name.equals("IEEE")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/121097061329915"));
                            startActivity(intent); //https://www.facebook.com/ewuieee
                        }
                        if(club_name.equals("Model United Nation")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/399745436887279"));
                            startActivity(intent);  //https://www.facebook.com/ewumunc/
                        }
                        if(club_name.equals("Photography")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/647849551969351"));
                            startActivity(intent);  //https://www.facebook.com/ewupc.bd/
                        }
                        if(club_name.equals("Rotaract")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1613863388934073"));
                            startActivity(intent);  //https://www.facebook.com/rotaractsofewu
                        }
                        if(club_name.equals("Science")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/122654974478172"));
                            startActivity(intent);      //https://www.facebook.com/ewusc04/
                        }
                        if(club_name.equals("Sociology")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/249743269016805"));
                            startActivity(intent);        //https://www.facebook.com/scewu/
                        }
                        if(club_name.equals("Sports")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/300557563333714"));
                            startActivity(intent);     //https://www.facebook.com/EWUSC.EWU/
                        }
                        if(club_name.equals("TeleCommunication")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/264136207008070"));
                            startActivity(intent);        //https://www.facebook.com/EWUTC/
                        }

                        if(club_name.equals("পাঠচক্র")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/121784785880615"));
                            startActivity(intent);        //https://www.facebook.com/pathchakro.ewu.bd//
                        }
                        if(club_name.equals("EWUCoPC")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/206695629361670"));
                            startActivity(intent);     //https://www.facebook.com/EWUCoPC/
                        }
                        if(club_name.equals("Pharmacy")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/124528110968424"));
                            startActivity(intent);     //https://www.facebook.com/phrm.dept/
                        }
                        if(club_name.equals("Career Counseling Cente")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/270480290009304"));
                            startActivity(intent);        //https://www.facebook.com/east.west.university.career.counseling.center///
                        }
                        if(club_name.equals("EWU Notice")){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/220819065537138"));
                            startActivity(intent);        //https://www.facebook.com/myewu/
                        }
                        String url_check=documentSnapshot.getString("URL");


                    }
                });
            }
        });
    }
    public static boolean isValid(String url)
    {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }
}