package com.hmatewu.ewulife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private CardView aca_demic, departmentCardView, ResultCardView,
            cgpaCardView, gsCardView, clubCardView, admiCardView,
            otherCardView, feeCardView, aidCardView, facultycardView, ewu_newsCardView, alumniCardView, libraryCardView, helpdeskCardView, lifeCardView, office_roomCardView, ConvocationCardView, roktoCardView,
            aboutCardView, classscCardView, othersCardView,coursescard,course_listCardview,fooodCardView,reportCardView;

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    StorageReference storageReference;
    CircleImageView profile_image;
    TextView name, department,cgpa;
    LinearLayout profile_info;
    String update, updatea;

    public HomeFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        fAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        userID =fAuth.getCurrentUser().getUid();
        storageReference= FirebaseStorage.getInstance().getReference();

        name=v.findViewById(R.id.textView36);
        department=v.findViewById(R.id.textView37);
        cgpa =v.findViewById(R.id.textView38);
        profile_image=v.findViewById(R.id.profile_image3000);
        profile_info=v.findViewById(R.id.prof_click);
       final DocumentReference documentReference2 = fstore.collection("EWU_student").document(userID);
        documentReference2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {

                final String name2=(documentSnapshot.getString("Name"));
                final String   depar2=(documentSnapshot.getString("Program"));
                final String    cgpa2=(documentSnapshot.getString("CGPA"));

                name.setText(name2);
                department.setText(depar2);
                cgpa.setText(cgpa2);

                documentReference2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){



                        }
                        else{
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_error_admin_toast,(ViewGroup)v.findViewById(R.id.errorad));
                            final Toast toast = new Toast(getActivity());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_SHORT));
                            toast.setView(layout1);
                            toast.show();
                            Toast.makeText(getActivity(), "Error Fetching", Toast.LENGTH_LONG).show();
                        }
                    }
                });



            }
        });

        StorageReference profRef = storageReference.child("ewuuser/"+userID+"profile.jpg");
        profRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profile_image);


            }
        });

        aca_demic = v.findViewById(R.id.ac);
        departmentCardView = v.findViewById(R.id.dep);
        ResultCardView = v.findViewById(R.id.result);
        cgpaCardView = v.findViewById(R.id.cgpa);
        gsCardView = v.findViewById(R.id.gs);
        clubCardView = v.findViewById(R.id.club);
        admiCardView = v.findViewById(R.id.admi);
        aidCardView = v.findViewById(R.id.aid);
        otherCardView = v.findViewById(R.id.feepay);
        feeCardView = v.findViewById(R.id.fee);
        facultycardView = v.findViewById(R.id.faculty);
        ewu_newsCardView = v.findViewById(R.id.ewu_news);
        alumniCardView = v.findViewById(R.id.Alumni);
        libraryCardView = v.findViewById(R.id.library);
        helpdeskCardView = v.findViewById(R.id.helpdesk);
        lifeCardView = v.findViewById(R.id.life);
        office_roomCardView = v.findViewById(R.id.office_room);
        ConvocationCardView = v.findViewById(R.id.convocation);
        roktoCardView = v.findViewById(R.id.rokto);
        aboutCardView = v.findViewById(R.id.about);
        classscCardView = v.findViewById(R.id.classsch);
        othersCardView = v.findViewById(R.id.other);
        coursescard = v.findViewById(R.id.courses);
        course_listCardview = v.findViewById(R.id.course_list);
        fooodCardView= v.findViewById(R.id.food);
        reportCardView= v.findViewById(R.id.report);



        course_listCardview.setOnClickListener(this);
        aca_demic.setOnClickListener(this);
        departmentCardView.setOnClickListener(this);
        ResultCardView.setOnClickListener(this);
        cgpaCardView.setOnClickListener(this);
        gsCardView.setOnClickListener(this);
        clubCardView.setOnClickListener(this);
        admiCardView.setOnClickListener(this);
        aidCardView.setOnClickListener(this);
        otherCardView.setOnClickListener(this);

        feeCardView.setOnClickListener(this);
        facultycardView.setOnClickListener(this);
        ewu_newsCardView.setOnClickListener(this);
        reportCardView.setOnClickListener(this);
        alumniCardView.setOnClickListener(this);
        libraryCardView.setOnClickListener(this);
        helpdeskCardView.setOnClickListener(this);
        lifeCardView.setOnClickListener(this);
        office_roomCardView.setOnClickListener(this);
        ConvocationCardView.setOnClickListener(this);
        roktoCardView.setOnClickListener(this);
        aboutCardView.setOnClickListener(this);
        classscCardView.setOnClickListener(this);
        othersCardView.setOnClickListener(this);
        coursescard.setOnClickListener(this);
        profile_info.setOnClickListener(this);
        profile_image.setOnClickListener(this);
        fooodCardView.setOnClickListener(this);



        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ac) {
            Intent intent = new Intent(getActivity(), CalenderActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.dep) {
            Intent intent = new Intent(getActivity(), DepartmentActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.result) {
            Intent intent = new Intent(getActivity(), PortalActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.cgpa) {
            Intent intent = new Intent(getActivity(), CgpaActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.gs) {
            Intent intent = new Intent(getActivity(), GradingSystemActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.club) {
            Intent intent = new Intent(getActivity(), EWUClubActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.admi) {
            Intent intent = new Intent(getActivity(), AdmissionActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.aid) {
            Intent intent = new Intent(getActivity(), FundActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ewu_news) {
            Intent intent = new Intent(getActivity(), EWUnewsActivity2.class);
            startActivity(intent);
        }


        if (v.getId() == R.id.library) {
            Intent intent = new Intent(getActivity(), LibraryActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.life) {
            Intent intent = new Intent(getActivity(), CampusLifeActivity2.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.helpdesk) {
            Intent intent = new Intent(getActivity(), HelpDeskActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.feepay) {
            Intent intent = new Intent(getActivity(), AddDropActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.fee) {
            Intent intent = new Intent(getActivity(), AdvisingActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.faculty) {
            Intent intent = new Intent(getActivity(), FacultyActivity.class);
            startActivity(intent);


        }
        if (v.getId() == R.id.Alumni) {
            Intent intent = new Intent(getActivity(), AlumniActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.convocation) {
            Intent intent = new Intent(getActivity(),CovocationActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.other) {
            Intent intent = new Intent(getActivity(),FMPActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.courses) {
            Intent intent = new Intent(getActivity(),CourseChartActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.course_list) {
            Intent intent = new Intent(getActivity(),Course_ChartActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.prof_click) {
            Intent intent = new Intent(getActivity(),UserProfileActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.profile_image3000) {
            Intent intent = new Intent(getActivity(),UserProfileActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.classsch) {


            Intent intent = new Intent(getActivity(),ClassScActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.rokto) {


            Intent intent = new Intent(getActivity(),RoktoJoddhaActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.about) {


            Intent intent = new Intent(getActivity(),AboutActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.report) {


            Intent intent = new Intent(getActivity(),Rep_SupporActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.food) {

            Intent intent = new Intent(getActivity(),FoodInfoActivity.class);
            startActivity(intent);


        }
        if(v.getId() == R.id.office_room){


            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
            View layout1 = inflater1.inflate(R.layout.worry_toast,(ViewGroup)v.findViewById(R.id.worried));
            final Toast toast = new Toast(getActivity());
            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
            toast.setDuration((Toast.LENGTH_LONG));
            toast.setView(layout1);
            toast.show();

        }
    }
}