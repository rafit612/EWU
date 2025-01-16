package com.hmatewu.ewulife;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class BloodFromActivity extends AppCompatActivity implements View.OnClickListener {
    String help2,acc,div2,dis,area3,uldd,dd;
    Spinner p_group;
    EditText Reason;
    int ages;
    int month1,day1,years;
    String mtoday;
    String mbirth,give_date;
    int months;
    int days;
    int months2;
    int days2;
    int years2;
    RadioGroup radioGroup,radioGroup2;
    RadioButton gender,covid;
    ArrayList<String> arrayList_blood;
    ArrayAdapter<String> rr_blood;
    String current,dob,age1,age,cmon,mon,mon1,cday,day,current_time,need_date,need_time,nfid;
    DatePicker datePicker,datePicker2;
    EditText request_fullname,request_number;
    Button button;
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    FirebaseUser user;
    String userID;
    TimePicker timePicker;
    ArrayList<String> arrayListnull,arrayListBloodQuan,arrayList_Division,arrayList_relation,arrayList_bloodtype
            ,arrayListDHKD,arrayListRJD,arrayListBSD,
            arrayListKLD,arrayListCTGD,arrayListMMSD
            ,arrayListRPD,arrayListSD;
    ArrayList<String> arrayListDHKA,arrayListGazipur,arrayListkishorganj,
            arrayListmunshiganj,arrayListnarayanganj,arrayListfaridpur,arrayListsingdi
            ,arrayListtangail,arraygopalganj,arrayListmadaripur,arrayListrajbari,arrayListshariatpur;

    ArrayList<String> arrayListRajshahi,arrayListChapainawabganj,arrayListJoypurhat,arrayListNaogaon,arrayListNatore,arrayListPabna,arrayListBogura,arrayListSirajgonj;

    ArrayList<String> arrayListBarisal , arrayListPatuakhali , arrayListBhola , arrayListJhalokati ,arrayListBarguna, arrayListPirojpur;
    ArrayList<String> arrayListChittagong,arrayListBrahmanbaria,arrayListChandpur,arrayListLakshmipur,arrayListNoakhali,arrayListFeni,arrayListKhagrachhari,arrayListRangamati,
            arrayListBandarban,arrayListCoxBazar,arrayListOther;

    ArrayList<String> arrayListKhulna,arrayListChuadanga,arrayListJessore,arrayListJhenaidah,arrayListKushtia,arrayListMagura,arrayListNarail,arrayListSatkhira,arrayListBagerhat;

    ArrayList<String> arrayListMymensingh,arrayListNetrokona,arrayListJamalpur,arrayListSherpur;

    ArrayList<String> arrayListRangpur,arrayListDinajpur,arrayListKurigram,arrayListNilphamari,arrayListGaibandha,arrayListThakurgaon,arrayListPanchagarh,arrayListLalmonirhat;

    ArrayList<String> arrayListSylhet,arrayListSunamganj,arrayListMoulvibazar,arrayListHabiganj;

    TextInputEditText blood_location,reason;
    AutoCompleteTextView hospital,reasonbldauto;



    String name,mobile,blood,gen,age3,donate_score,donate_time,request_time,dob2,report2,acc_open,ask;
    ArrayAdapter<String> r_relation,r_blood_type,r_division,r_district,r_area,bloodquan,adapter_hos,reasonbld;
    Spinner Division,District,Area,Rel_type,need_type,Quantity,bloodbank;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_from);

        Reason = findViewById(R.id.note);
        request_fullname=findViewById(R.id.reqb_name);
        request_number=findViewById(R.id.reqb_mobileno);
        p_group = findViewById(R.id.bloodspinner);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        user=fAuth.getCurrentUser();
        datePicker = findViewById(R.id.agedate);
        button = findViewById(R.id.button17);
        button.setOnClickListener(this);
       current = currentDate();

        datePicker2= findViewById(R.id.giving_Date);
        timePicker =findViewById(R.id.time);
        timePicker.setIs24HourView(true);
        current_time = timePicker.getHour()+":"+timePicker.getMinute()+" ";
        Calendar calendar = Calendar.getInstance();
        years= calendar.get(Calendar.YEAR);
        month1=calendar.get(Calendar.MONTH)+1;
        day1=calendar.get(Calendar.DAY_OF_MONTH);
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        nfid=NFID_method();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mtoday = simpleDateFormat.format(Calendar.getInstance().getTime());
        radioGroup = findViewById(R.id.gender);
        radioGroup2 = findViewById(R.id.covid);
        {

            arrayList_blood = new ArrayList<>();
            arrayList_blood.add("Select");
            arrayList_blood.add("A+");
            arrayList_blood.add("B+");
            arrayList_blood.add("O+");
            arrayList_blood.add("AB+");
            arrayList_blood.add("A-");
            arrayList_blood.add("B-");
            arrayList_blood.add("O-");
            arrayList_blood.add("AB-");
        }
        rr_blood = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_blood);
        p_group.setAdapter(rr_blood);



        Division = findViewById(R.id.spinner);
        District = findViewById(R.id.spinner3);
        Area = findViewById(R.id.spinner4);
        Rel_type = findViewById(R.id.spinner6);
        need_type = findViewById(R.id.spinner5);
        Quantity = findViewById(R.id.spinner7);


        reasonbldauto = findViewById(R.id.editTextdiease);
        String[] res = getResources().getStringArray(R.array.reasonblood);
        reasonbld = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,res);
        reasonbldauto.setThreshold(1);
        reasonbldauto.setAdapter(reasonbld);

        DocumentReference documentReference9 = fstore.collection("EWU_student").document(userID);
        documentReference9.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@androidx.annotation.Nullable DocumentSnapshot documentSnapshot, @androidx.annotation.Nullable FirebaseFirestoreException e) {

                String  updatea = documentSnapshot.getString("Block");

                if(!updatea.equals("1")){
                    LayoutInflater inflater = getLayoutInflater();                             ///custom toast//
                    View layout = inflater.inflate(R.layout.custom_error_admin_toast,(ViewGroup)findViewById(R.id.errorad));
                    final Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.setDuration((Toast.LENGTH_LONG));
                    toast.setView(layout);
                    toast.show();
                    Intent intent =new Intent(BloodFromActivity.this,BlockedActivity2.class);
                    startActivity(intent);
                    finish();
                }




            }
        });

        hospital = findViewById(R.id.editTextTextPersonName);


        blood_location = findViewById(R.id.editTextlocation);


        arrayListnull = new ArrayList<>();
        arrayListnull.add("Select");

        arrayListBloodQuan = new ArrayList<>();
        {
            arrayListBloodQuan.add("Select");
            arrayListBloodQuan.add("1");
            arrayListBloodQuan.add("2");
            arrayListBloodQuan.add("3");
            arrayListBloodQuan.add("4");
            arrayListBloodQuan.add("5");
        }

        arrayList_bloodtype = new ArrayList<>();
        {
            arrayList_bloodtype.add("Select");
            arrayList_bloodtype.add("Plasma");
            arrayList_bloodtype.add("Platelets");
            arrayList_bloodtype.add("Red Blood");
            arrayList_bloodtype.add("Others");
        }
        arrayList_Division = new ArrayList<>();
        {     //dhaka division District

            arrayList_Division.add("Select");
            arrayList_Division.add("Dhaka");
            arrayList_Division.add("Rajshahi");
            arrayList_Division.add("Barisal");
            arrayList_Division.add("Chittagong");
            arrayList_Division.add("Khulna");
            arrayList_Division.add("Mymensingh");
            arrayList_Division.add("Rangpur");
            arrayList_Division.add("Sylhet");

        }

        {
            arrayListDHKD = new ArrayList<>();
            {     //dhaka division District

                arrayListDHKD.add("Select");
                arrayListDHKD.add("Dhaka");
                arrayListDHKD.add("Ghazipur");
                arrayListDHKD.add("Kishoreganj");
                arrayListDHKD.add("Munshiganj");
                arrayListDHKD.add("Narayanganj");
                arrayListDHKD.add("Narsingdi");
                arrayListDHKD.add("Faridpur");
                arrayListDHKD.add("Tangail");
                arrayListDHKD.add("Gopalganj");
                arrayListDHKD.add("Madaripur");
                arrayListDHKD.add("Rajbari");
                arrayListDHKD.add("Shariatpur");
            }
            arrayListDHKA = new ArrayList<>();
            {
                arrayListDHKA.add("Select");
                arrayListDHKA.add("Adabor");
                arrayListDHKA.add("Badda");
                arrayListDHKA.add("Bangshal");
                arrayListDHKA.add("Biman Bandar");
                arrayListDHKA.add("Cantonment");
                arrayListDHKA.add("Chawkbazar ");
                arrayListDHKA.add("Dakshinkhan");
                arrayListDHKA.add("Darus Salam");
                arrayListDHKA.add("Demra");
                arrayListDHKA.add("Dhanmondi");
                arrayListDHKA.add("Gendaria");
                arrayListDHKA.add("Gulshan");
                arrayListDHKA.add("Hazaribagh");
                arrayListDHKA.add("Jatrabari ");
                arrayListDHKA.add("Kadamtali");
                arrayListDHKA.add("Kafrul");
                arrayListDHKA.add("Kalabagan");
                arrayListDHKA.add("Kamrangirchar");
                arrayListDHKA.add("Keraniganj");
                arrayListDHKA.add("Khilgaon");
                arrayListDHKA.add("Khilkhet");
                arrayListDHKA.add("Kotwali");
                arrayListDHKA.add("Lalbagh");
                arrayListDHKA.add("Mirpur");
                arrayListDHKA.add("Mohammadpur");
                arrayListDHKA.add("Motijheel");
                arrayListDHKA.add("Pallabi");
                arrayListDHKA.add("Paltan");
                arrayListDHKA.add("Ramna");
                arrayListDHKA.add("Rampura");
                arrayListDHKA.add("Sabujbagh");
                arrayListDHKA.add("Savar");
                arrayListDHKA.add("Shah Ali");
                arrayListDHKA.add("Shahbagh");
                arrayListDHKA.add("Sher-e-Bangla Nagar");
                arrayListDHKA.add("Shyampur");
                arrayListDHKA.add("Sutrapur");
                arrayListDHKA.add("Tejgaon");
                arrayListDHKA.add("Turag");
                arrayListDHKA.add("Uttara");
                arrayListDHKA.add("Uttar Khan");
            }

            arrayListGazipur = new ArrayList<>();
            {
                arrayListGazipur.add("Select");
                arrayListGazipur.add("Bager Bazar Mowna");
                arrayListGazipur.add("Bahawalpur College Chowrasta");
                arrayListGazipur.add("Barmi");
                arrayListGazipur.add("Bashon Thana Chowrasta");
                arrayListGazipur.add("BRRI");
                arrayListGazipur.add("Brtc Chowrasta");
                arrayListGazipur.add("Caller Bazar");
                arrayListGazipur.add("Chowrasta");
                arrayListGazipur.add("Chowrasta Baypass");
                arrayListGazipur.add("Chowrasta Telipara");
                arrayListGazipur.add("Chowrasta Warelessgate");
                arrayListGazipur.add("Dhakkinan Joydebpur");
                arrayListGazipur.add("Dhakkin Chaybithi");
                arrayListGazipur.add("Dhirashom Joydebpur");
                arrayListGazipur.add("Gazipur");
                arrayListGazipur.add("Gazipur Sadar");
                arrayListGazipur.add("Hotapara Mowna");
                arrayListGazipur.add("Joydebpur Police Line");
                arrayListGazipur.add("Joydebpur Rail Gate");
                arrayListGazipur.add("Konabari");
                arrayListGazipur.add("Konabari Nawjor");
                arrayListGazipur.add("Kashimpur Ambag");
                arrayListGazipur.add("Kaliganj");
                arrayListGazipur.add("Kaliakaar");
                arrayListGazipur.add("Monnunagar");
                arrayListGazipur.add("Mouchak");
                arrayListGazipur.add("Mowna Chowrasta");
                arrayListGazipur.add("National University");
                arrayListGazipur.add("Rajbari Math Joydebpur");
                arrayListGazipur.add("Rajendrapur");
                arrayListGazipur.add("Rajendrapur Cantonmen");
                arrayListGazipur.add("Shafipur");
                arrayListGazipur.add("Shimultoli Joydebpur");
                arrayListGazipur.add("Sreepur");
                arrayListGazipur.add("Tongi");
                arrayListGazipur.add("Uttor Chayabithi");
                arrayListGazipur.add("Kapasia");

            }

            arrayListkishorganj = new ArrayList<>();
            {
                arrayListkishorganj.add("Select");
                arrayListkishorganj.add("Abdullahpur");
                arrayListkishorganj.add("Bajitpur");
                arrayListkishorganj.add("Bhairab");
                arrayListkishorganj.add("Binnadi Bazar");
                arrayListkishorganj.add("Hossainpur");
                arrayListkishorganj.add("Josudal Syed Nazrul Islam Medical");
                arrayListkishorganj.add("Karimganj");
                arrayListkishorganj.add("Katiadi");
                arrayListkishorganj.add("Katiadi Gochhihata");
                arrayListkishorganj.add("Kishoreganj Sadar");
                arrayListkishorganj.add("Kishoreganj Sadar S.Mills");
                arrayListkishorganj.add("Kishoregonj Camara Bandar");
                arrayListkishorganj.add("Kishoregonj Sadar");
                arrayListkishorganj.add("Kuliarchar");
                arrayListkishorganj.add("Laksmipur");
                arrayListkishorganj.add("Maria Industrial City");
                arrayListkishorganj.add("Mithamoin");
                arrayListkishorganj.add("Nandail Chourasta - Mymensingh Road");
                arrayListkishorganj.add("Nilganj Bazar");
                arrayListkishorganj.add("Ostagram");
                arrayListkishorganj.add("Pakundia");
                arrayListkishorganj.add("Pakundia Bazar");
                arrayListkishorganj.add("Pulgarhat Bazar");
                arrayListkishorganj.add("Sararchar");
                arrayListkishorganj.add("Sholakia Area");
                arrayListkishorganj.add("Tarial");
                arrayListkishorganj.add("Austagram");
                arrayListkishorganj.add("Itna");
                arrayListkishorganj.add("Nikli");


            }

            arrayListmunshiganj = new ArrayList<>();
            {
                arrayListmunshiganj.add("Select");
                arrayListmunshiganj.add("Gajaria Hossendi");
                arrayListmunshiganj.add("Gajaria Rasulpur");
                arrayListmunshiganj.add("Gajaria Sadar");
                arrayListmunshiganj.add("Lohajong");
                arrayListmunshiganj.add("Lohajong Gouragonj");

                arrayListmunshiganj.add("Lohajong Haridia");
                arrayListmunshiganj.add("Lohajong Korhati");
                arrayListmunshiganj.add("Lohajong Madini Mandal");
                arrayListmunshiganj.add("Sirajdikhan");
                arrayListmunshiganj.add("Sirajdikhan Ichapur");
                arrayListmunshiganj.add("Sirajdikhan Kola");
                arrayListmunshiganj.add("Sirajdikhan Malkha Nagar");
                arrayListmunshiganj.add("Sirajdikhan Shekher Nagar");
                arrayListmunshiganj.add("Baghra");
                arrayListmunshiganj.add("Bajrajugini");
                arrayListmunshiganj.add("Baligao");
                arrayListmunshiganj.add("Betkahat");
                arrayListmunshiganj.add("Bhaggyakul");
                arrayListmunshiganj.add("Dighirpar");
                arrayListmunshiganj.add("Hasail");
                arrayListmunshiganj.add("Hashara");
                arrayListmunshiganj.add("Kolapara");
                arrayListmunshiganj.add("Kumarbhog");
                arrayListmunshiganj.add("Maijpara");
                arrayListmunshiganj.add("Munshiganj Sadar Kathakhali");
                arrayListmunshiganj.add("Munshiganj Sadar Mirkadim");
                arrayListmunshiganj.add("Munshiganj Sadar Munshiganj Sadar");
                arrayListmunshiganj.add("Munshiganj Sadar Rikabibazar");
                arrayListmunshiganj.add("Pura");
                arrayListmunshiganj.add("Pura EDSO");
                arrayListmunshiganj.add("Rarikhal");
                arrayListmunshiganj.add("Sreenagar");
                arrayListmunshiganj.add("Tangibari");
                arrayListmunshiganj.add("Vaggyakul SO");


            }

            arrayListfaridpur = new ArrayList<>();
            {
                arrayListfaridpur.add("Select");
                arrayListfaridpur.add("Alfadanga");
                arrayListfaridpur.add("Alipur");
                arrayListfaridpur.add("Ambikapur");
                arrayListfaridpur.add("Ambikapur Board Office");
                arrayListfaridpur.add("Baitulaman Housing");
                arrayListfaridpur.add("Baitulaman Politecni");
                arrayListfaridpur.add("Bakhunda");
                arrayListfaridpur.add("Bhanga");
                arrayListfaridpur.add("Boalmari");
                arrayListfaridpur.add("Bodorpur");
                arrayListfaridpur.add("C&B Ghat");
                arrayListfaridpur.add("Chorkomlapur");
                arrayListfaridpur.add("Chunaghata");
                arrayListfaridpur.add("Dhuldi Bazar");
                arrayListfaridpur.add("Dhuldi Railgate");
                arrayListfaridpur.add("Engineering College");
                arrayListfaridpur.add("Faridpur Sadar");
                arrayListfaridpur.add("Horishova");
                arrayListfaridpur.add("Jhiltuli");
                arrayListfaridpur.add("Kanaipur");
                arrayListfaridpur.add("Khabaspur");
                arrayListfaridpur.add("Kobirpur");
                arrayListfaridpur.add("Komlapur");
                arrayListfaridpur.add("Komorpur");
                arrayListfaridpur.add("Krishi College");
                arrayListfaridpur.add("Laler Mor");
                arrayListfaridpur.add("Medical");
                arrayListfaridpur.add("Mohila Road");
                arrayListfaridpur.add("Munshibazar");
                arrayListfaridpur.add("New Bus Stand");
                arrayListfaridpur.add("Old Bus Stand");
                arrayListfaridpur.add("Onather Mor");
                arrayListfaridpur.add("Puran Gazi Bari");
                arrayListfaridpur.add("Sovarampur");
                arrayListfaridpur.add("Station Bazar");
                arrayListfaridpur.add("Tepakhola");


            }
            arrayListnarayanganj = new ArrayList<>();
            {
                arrayListnarayanganj.add("Select");
                arrayListnarayanganj.add("Araihazar");
                arrayListnarayanganj.add("Araihazar Gopaldi");
                arrayListnarayanganj.add("Baidder Bazar");
                arrayListnarayanganj.add("Baidder Bazar Bara Nagar");
                arrayListnarayanganj.add("Baidder Bazar Barodi");
                arrayListnarayanganj.add("Bandar");
                arrayListnarayanganj.add("Bandar BIDS");
                arrayListnarayanganj.add("Bandar D.C Mills");
                arrayListnarayanganj.add("Fatullah");
                arrayListnarayanganj.add("Fatullah Bazar");
                arrayListnarayanganj.add("Madanganj");
                arrayListnarayanganj.add("Nabiganj");
                arrayListnarayanganj.add("Narayanganj Sadar");
                arrayListnarayanganj.add("Rupganj");
                arrayListnarayanganj.add("Rupganj Bhulta");
                arrayListnarayanganj.add("Rupganj Kanchan");
                arrayListnarayanganj.add("Rupganj Murapara");
                arrayListnarayanganj.add("Rupganj Nagri");
                arrayListnarayanganj.add("Siddirganj Adamjeenagar");
                arrayListnarayanganj.add("Siddirganj LN Mills");
                arrayListnarayanganj.add("Siddirganj Siddirganj");


            }
            arrayListsingdi = new ArrayList<>();
            {
                arrayListsingdi.add("Select");
                arrayListsingdi.add("Basail");
                arrayListsingdi.add("Belabo");
                arrayListsingdi.add("Bilasdi");
                arrayListsingdi.add("Bot-Tola");
                arrayListsingdi.add("Brahmondi");
                arrayListsingdi.add("Char Sindhur");
                arrayListsingdi.add("Chinishpur");
                arrayListsingdi.add("Daspara");
                arrayListsingdi.add("Dogoria");
                arrayListsingdi.add("Ghorashal");
                arrayListsingdi.add("Ghorashal Bazar");
                arrayListsingdi.add("Goradia");
                arrayListsingdi.add("Grorashal Pran Factory");
                arrayListsingdi.add("Grorashal Sarkar Khana");
                arrayListsingdi.add("Hazupur");
                arrayListsingdi.add("Janata Jute Mile");
                arrayListsingdi.add("Kandapara");
                arrayListsingdi.add("Karimpur");
                arrayListsingdi.add("Kawriapara");
                arrayListsingdi.add("Madhabdi");
                arrayListsingdi.add("Monohordi");
                arrayListsingdi.add("Monohordi Hatirdia");
                arrayListsingdi.add("Monohordi Katabaria");
                arrayListsingdi.add("Narsingdi Bazar");
                arrayListsingdi.add("Narsingdi College");
                arrayListsingdi.add("Narsingdi Sadar");
                arrayListsingdi.add("Palash");
                arrayListsingdi.add("Panchdona");
                arrayListsingdi.add("Raypura");
                arrayListsingdi.add("Raypura Bazar Hasnabad");
                arrayListsingdi.add("Raypura Radhaganj bazar");
                arrayListsingdi.add("Salidha");
                arrayListsingdi.add("Sarkarkhana");
                arrayListsingdi.add("Satirpara");
                arrayListsingdi.add("Shibpur");
                arrayListsingdi.add("Shilmandi");
                arrayListsingdi.add("Songita");
                arrayListsingdi.add("Torowa");
                arrayListsingdi.add("UMC Jute Mills");
                arrayListsingdi.add("Velanaghar");


            }

            arrayListtangail = new ArrayList<>();
            {
                arrayListtangail.add("Select");
                arrayListtangail.add("Bagli");
                arrayListtangail.add("Basali");
                arrayListtangail.add("Basali Sadar");
                arrayListtangail.add("Bhuapur Sadar");
                arrayListtangail.add("Delduar");
                arrayListtangail.add("Ghatail");
                arrayListtangail.add("Gopalpur");
                arrayListtangail.add("Kalihat");
                arrayListtangail.add("Kashkawlia");
                arrayListtangail.add("Madhupur");
                arrayListtangail.add("Mirzapur");
                arrayListtangail.add("Nagarpur");
                arrayListtangail.add("Sakhipur");
                arrayListtangail.add("Charabari");
                arrayListtangail.add("Elanga");
                arrayListtangail.add("Gala");
                arrayListtangail.add("Jugni Bazar");
                arrayListtangail.add("Kasil");
                arrayListtangail.add("Potol Bazar");
                arrayListtangail.add("Pugli");
                arrayListtangail.add("Rosulpur");
                arrayListtangail.add("Salimpur");
                arrayListtangail.add("Soto Basail");
                arrayListtangail.add("Tangail Sadar");
                arrayListtangail.add("Tangail Sadar Kagmari");
                arrayListtangail.add("Tangail Sadar Karatia");
                arrayListtangail.add("Tangail Sadar Porabari");
                arrayListtangail.add("Tangail Sadar Santosh");
                arrayListtangail.add("Tarotiya");
                arrayListtangail.add("Vaita");
                arrayListtangail.add("Vatkora");


            }
            arraygopalganj = new ArrayList<>();
            {
                arraygopalganj.add("Select");
                arraygopalganj.add("Arpara");
                arraygopalganj.add("Gopalganj Sadar");
                arraygopalganj.add("Gopalganj Sadar Ulpur");
                arraygopalganj.add("Gopinathpur");
                arraygopalganj.add("Kashiani");
                arraygopalganj.add("Kotalipara");
                arraygopalganj.add("Maksudpur");
                arraygopalganj.add("Malenga");
                arraygopalganj.add("Manikher");
                arraygopalganj.add("Ratoil");
                arraygopalganj.add("Tungipara");
                arraygopalganj.add("Vatiapara");


            }
            arrayListmadaripur = new ArrayList<>();
            {
                arrayListmadaripur.add("Select");
                arrayListmadaripur.add("Kalkini");
                arrayListmadaripur.add("Madaripur");
                arrayListmadaripur.add("Rajoir");
                arrayListmadaripur.add("Rajoir Khalia");
                arrayListmadaripur.add("Sahabrampur");

            }

            arrayListrajbari = new ArrayList<>();
            {
                arrayListmadaripur.add("Select");
                arrayListmadaripur.add("Baliakandi");
                arrayListmadaripur.add("Pangsha");
                arrayListmadaripur.add("Rajbari Sadar");
                arrayListmadaripur.add("Goalanda");
                arrayListmadaripur.add("Rajbari Sadar khankhanapur");
                arrayListmadaripur.add("Kalukhali");

            }
            arrayListshariatpur = new ArrayList<>();
            {
                arrayListshariatpur.add("Select");
                arrayListshariatpur.add("Naria");
                arrayListshariatpur.add("Bhedorganj");
                arrayListshariatpur.add("Gosairhat");
                arrayListshariatpur.add("Jajira");
                arrayListshariatpur.add("Shariatpur Sadar");
                arrayListshariatpur.add("Shariatpur Sadar Angaria");
                arrayListshariatpur.add("Shariatpur Sadar Chikandi");

            }

        }
        {
            arrayListRJD = new ArrayList<>();
            {
                arrayListRJD.add("Select");
                arrayListRJD.add("Rajshahi");
                arrayListRJD.add("Chapainawabganj");
                arrayListRJD.add("Joypurhat");
                arrayListRJD.add("Naogaon");
                arrayListRJD.add("Natore");
                arrayListRJD.add("Pabna");
                arrayListRJD.add("Bogura");
                arrayListRJD.add("Sirajgonj");
            }
            arrayListRajshahi = new ArrayList<>();
            {
                arrayListRajshahi.add("Select");
                arrayListRajshahi.add("Arani");
                arrayListRajshahi.add("Bagha");
                arrayListRajshahi.add("Bhabaniganj");
                arrayListRajshahi.add("Bhatkandi");
                arrayListRajshahi.add("Binodpur Bazar");
                arrayListRajshahi.add("Charghat");
                arrayListRajshahi.add("Durgapur");
                arrayListRajshahi.add("Ghoramara");
                arrayListRajshahi.add("Godagari");
                arrayListRajshahi.add("Katakhali");
                arrayListRajshahi.add("Kazla");
                arrayListRajshahi.add("Khodmohanpur");
                arrayListRajshahi.add("Lalitganj");
                arrayListRajshahi.add("Nowhata");
                arrayListRajshahi.add("Premtoli");
                arrayListRajshahi.add("Putia");
                arrayListRajshahi.add("Rajshahi Canttonment");
                arrayListRajshahi.add("Rajshahi Court");
                arrayListRajshahi.add("Rajshahi Sadar");
                arrayListRajshahi.add("Rajshahi Sugar Mills");
                arrayListRajshahi.add("Rajshahi University");
                arrayListRajshahi.add("Sapura");
                arrayListRajshahi.add("Sardah");
                arrayListRajshahi.add("Shyampur");
                arrayListRajshahi.add("Taherpur");
                arrayListRajshahi.add("Tanor");
            }

            arrayListChapainawabganj = new ArrayList<>();
            {
                arrayListChapainawabganj.add("Select");
                arrayListChapainawabganj.add("Amnura");
                arrayListChapainawabganj.add("Bholahat");
                arrayListChapainawabganj.add("Chapai Nawabganj Sadar");
                arrayListChapainawabganj.add("Gomashtapur");
                arrayListChapainawabganj.add("Kansart");
                arrayListChapainawabganj.add("Manaksha");
                arrayListChapainawabganj.add("Mandumala");
                arrayListChapainawabganj.add("Nachol");
                arrayListChapainawabganj.add("Rajarampur");
                arrayListChapainawabganj.add("Ramchandrapur");
                arrayListChapainawabganj.add("Rohanpur");
                arrayListChapainawabganj.add("Shibganj U.P.O");

            }

            arrayListJoypurhat = new ArrayList<>();
            {
                arrayListJoypurhat.add("Select");
                arrayListJoypurhat.add("Akklepur");
                arrayListJoypurhat.add("Jamalganj");
                arrayListJoypurhat.add("Joypurhat Sadar");
                arrayListJoypurhat.add("Kalai");
                arrayListJoypurhat.add("Khetlal");
                arrayListJoypurhat.add("Panchbibi");
                arrayListJoypurhat.add("Tilakpur");


            }

            arrayListNaogaon = new ArrayList<>();
            {
                arrayListNaogaon.add("Select");
                arrayListNaogaon.add("Ahsanganj");
                arrayListNaogaon.add("Badalgachhi");
                arrayListNaogaon.add("Balihar");
                arrayListNaogaon.add("Bandai");
                arrayListNaogaon.add("Dhamuirhat");
                arrayListNaogaon.add("Kashimpur");
                arrayListNaogaon.add("Mahadebpur");
                arrayListNaogaon.add("Manda");
                arrayListNaogaon.add("Moduhil");
                arrayListNaogaon.add("Naogaon Sadar");
                arrayListNaogaon.add("Niamatpur");
                arrayListNaogaon.add("Nitpur");
                arrayListNaogaon.add("Panguria");
                arrayListNaogaon.add("Patnitala");
                arrayListNaogaon.add("Porsa");
                arrayListNaogaon.add("Prasadpur");
                arrayListNaogaon.add("Raninagar");
                arrayListNaogaon.add("Sapahar");

            }
            arrayListNatore = new ArrayList<>();
            {
                arrayListNatore.add("Select");
                arrayListNatore.add("Abdulpur");
                arrayListNatore.add("Baiddyabal Gharia");
                arrayListNatore.add("Baraigram");
                arrayListNatore.add("Dayarampur");
                arrayListNatore.add("Digapatia");
                arrayListNatore.add("Gopalpur U.P.O");
                arrayListNatore.add("Harua");
                arrayListNatore.add("Hatgurudaspur");
                arrayListNatore.add("Lalpur S.O");
                arrayListNatore.add("Laxman");
                arrayListNatore.add("Madhnagar");
                arrayListNatore.add("Natore Sadar");
                arrayListNatore.add("Singra");

            }

            arrayListPabna = new ArrayList<>();
            {
                arrayListPabna.add("Select");
                arrayListPabna.add("Banwarinagar");
                arrayListPabna.add("Bera");
                arrayListPabna.add("Bhangura");
                arrayListPabna.add("Chatmohar");
                arrayListPabna.add("Debottar");
                arrayListPabna.add("Dhapari");
                arrayListPabna.add("Hamayetpur");
                arrayListPabna.add("Ishwardi");
                arrayListPabna.add("Kaliko Cotton Mills");
                arrayListPabna.add("Kashinathpur");
                arrayListPabna.add("Nakalia");
                arrayListPabna.add("Pabna Sadar");
                arrayListPabna.add("Pakshi");
                arrayListPabna.add("Puran Bharenga");
                arrayListPabna.add("Rajapur");
                arrayListPabna.add("Sagarkandi");
                arrayListPabna.add("Sathia");
                arrayListPabna.add("Sujanagar");

            }
            arrayListBogura = new ArrayList<>();
            {
                arrayListBogura.add("Select");
                arrayListBogura.add("Adamdighi");
                arrayListBogura.add("Bagura Canttonment");
                arrayListBogura.add("Bagura Sadar");
                arrayListBogura.add("Balkuchi");
                arrayListBogura.add("Balukapara");
                arrayListBogura.add("Barachapra");
                arrayListBogura.add("Bottola Bazar");
                arrayListBogura.add("Chalapara");
                arrayListBogura.add("Champapur");
                arrayListBogura.add("Chandaikona");
                arrayListBogura.add("Chandan Baisha");
                arrayListBogura.add("Chhantiagram");
                arrayListBogura.add("Debkhanda");
                arrayListBogura.add("Dhunat");
                arrayListBogura.add("Dupchachia");
                arrayListBogura.add("Erulia");
                arrayListBogura.add("Gabtoli");
                arrayListBogura.add("Gokul");
                arrayListBogura.add("Gosaibari");
                arrayListBogura.add("Kahaloo");
                arrayListBogura.add("Kahalu");
                arrayListBogura.add("Khanpur");
                arrayListBogura.add("Koiel");
                arrayListBogura.add("Koyel");
                arrayListBogura.add("Kundagram");
                arrayListBogura.add("Kutubpur");
                arrayListBogura.add("Lahiri Para");
                arrayListBogura.add("Namuja");
                arrayListBogura.add("Nandigram");
                arrayListBogura.add("Nasharatpur");
                arrayListBogura.add("Nasratpur");
                arrayListBogura.add("Noongola");
                arrayListBogura.add("Palli Unnyan Accademy");
                arrayListBogura.add("Santahar");
                arrayListBogura.add("Santahar Pouroshova");
                arrayListBogura.add("Sariakandi");
                arrayListBogura.add("Shabgram");
                arrayListBogura.add("Shalikha");
                arrayListBogura.add("Shekharkola");
                arrayListBogura.add("Sherpur");
                arrayListBogura.add("Sherpur Chakatola Road");
                arrayListBogura.add("Shibganj");
                arrayListBogura.add("Sonatola");
                arrayListBogura.add("Sukhanpukur");
                arrayListBogura.add("Talora");
                arrayListBogura.add("Ulipurpara");
                arrayListBogura.add("Utra");


            }
            arrayListSirajgonj = new ArrayList<>();
            {
                arrayListSirajgonj.add("Select");
                arrayListSirajgonj.add("Baiddya Jam Toil");
                arrayListSirajgonj.add("Belkuchi");
                arrayListSirajgonj.add("Dhangora");
                arrayListSirajgonj.add("Enayetpur");
                arrayListSirajgonj.add("Gandail");
                arrayListSirajgonj.add("Jamirta");
                arrayListSirajgonj.add("Kaijuri");
                arrayListSirajgonj.add("Kazipur");
                arrayListSirajgonj.add("Lahiri Mohanpur");
                arrayListSirajgonj.add("Malonga");
                arrayListSirajgonj.add("Porjana");
                arrayListSirajgonj.add("Raipur");
                arrayListSirajgonj.add("Rajapur");
                arrayListSirajgonj.add("Rashidabad");
                arrayListSirajgonj.add("Salap");
                arrayListSirajgonj.add("Shahjadpur");
                arrayListSirajgonj.add("Shuvgachha");
                arrayListSirajgonj.add("Sirajganj Sadar");
                arrayListSirajgonj.add("Sohagpur");
                arrayListSirajgonj.add("Tarash");
                arrayListSirajgonj.add("Ullapara");
                arrayListSirajgonj.add("Ullapara R.S");

            }
        }

        {
            arrayListBSD = new ArrayList<>();
            {
                arrayListBSD.add("Select");
                arrayListBSD.add("Barisal");
                arrayListBSD.add("Patuakhali");
                arrayListBSD.add("Bhola");
                arrayListBSD.add("Jhalokati");
                arrayListBSD.add("Barguna");
                arrayListBSD.add("Pirojpur");
            }

            arrayListBarisal = new ArrayList<>();
            {
                arrayListBarisal.add("Select");
                arrayListBarisal.add("Agailjhara");
                arrayListBarisal.add("Gaila");
                arrayListBarisal.add("Paisarhat");
                arrayListBarisal.add("Babuganj Sadar");
                arrayListBarisal.add("Babuganj");
                arrayListBarisal.add("Chandpasha");
                arrayListBarisal.add("Dehergoti");
                arrayListBarisal.add("Guthia");
                arrayListBarisal.add("Madhabpasha");
                arrayListBarisal.add("Rahamatpur");
                arrayListBarisal.add("Thakur Malik");
                arrayListBarisal.add("Barajalia Sadar");
                arrayListBarisal.add("Osman Manjil");
                arrayListBarisal.add("Batajor");
                arrayListBarisal.add("Gouranadi Launch Ghat");
                arrayListBarisal.add("Gouranadi Sadar");
                arrayListBarisal.add("Kashemabad");
                arrayListBarisal.add("Mridha market");
                arrayListBarisal.add("Tarki Bandar");
                arrayListBarisal.add("Langutia");
                arrayListBarisal.add("Laskarpur");
                arrayListBarisal.add("Mehendiganj Sadar");
                arrayListBarisal.add("Nalgora");
                arrayListBarisal.add("Ulania");
                arrayListBarisal.add("Bara Madhab rayer char");
                arrayListBarisal.add("Charkalekhan");
                arrayListBarisal.add("Kazirchar");
                arrayListBarisal.add("Muladi Sadar");
                arrayListBarisal.add("Charamandi");
                arrayListBarisal.add("Kalaskati");
                arrayListBarisal.add("Padri Shibpur");
                arrayListBarisal.add("Sahebganj");
                arrayListBarisal.add("Shialguni");
                arrayListBarisal.add("Pirojpur");
                arrayListBarisal.add("Barguna");
                arrayListBarisal.add("Pirojpur");
                arrayListBarisal.add("Barguna");
                arrayListBarisal.add("Pirojpur");
                arrayListBarisal.add("Barishal Sadar");
                arrayListBarisal.add("Bibir Pukur");
                arrayListBarisal.add("Bukhainagar");
                arrayListBarisal.add("Chahutpur");
                arrayListBarisal.add("Jaguarhat");
                arrayListBarisal.add("Kashipur");
                arrayListBarisal.add("Kawnia");
                arrayListBarisal.add("Kazipara");
                arrayListBarisal.add("Moth Baria");
                arrayListBarisal.add("Natun Bazar");
                arrayListBarisal.add("Patang");
                arrayListBarisal.add("Rajmahal");
                arrayListBarisal.add("Rupatali");
                arrayListBarisal.add("Sadar Upazila");
                arrayListBarisal.add("Sagardi");
                arrayListBarisal.add("Saheberhat");
                arrayListBarisal.add("Sugandia");
                arrayListBarisal.add("Taltali");
                arrayListBarisal.add("Tia Khali");
                arrayListBarisal.add("Dakuarhat");
                arrayListBarisal.add("Dhamura");
                arrayListBarisal.add("Jugirkanda");
                arrayListBarisal.add("Shikarpur");
                arrayListBarisal.add("Uzirpur Bazar");
                arrayListBarisal.add("Uzirpur Sadar");
                arrayListBarisal.add("Wazirpur Bazar");

            }
            arrayListPatuakhali = new ArrayList<>();
            {
                arrayListPatuakhali.add("Select");
                arrayListPatuakhali.add("Bagabandar");
                arrayListPatuakhali.add("Bauphal");
                arrayListPatuakhali.add("Birpasha");
                arrayListPatuakhali.add("Dashmina");
                arrayListPatuakhali.add("Dumkee");
                arrayListPatuakhali.add("Galachipa");
                arrayListPatuakhali.add("Gazipur Bandar");
                arrayListPatuakhali.add("Kalaia");
                arrayListPatuakhali.add("Kalishari");
                arrayListPatuakhali.add("Khepupara");
                arrayListPatuakhali.add("Mahipur");
                arrayListPatuakhali.add("Moukaran");
                arrayListPatuakhali.add("Patuakhali Sadar");
                arrayListPatuakhali.add("Rahimabad");
                arrayListPatuakhali.add("Subidkhali");

            }
            arrayListBhola = new ArrayList<>();
            {
                arrayListBhola.add("Select");
                arrayListBhola.add("Bhola Sadar");
                arrayListBhola.add("Borhanuddin UPO");
                arrayListBhola.add("Charfashion");
                arrayListBhola.add("Daurihat");
                arrayListBhola.add("Doulatkhan");
                arrayListBhola.add("Dularhat");
                arrayListBhola.add("Gazaria");
                arrayListBhola.add("Hajipur");
                arrayListBhola.add("Hajirhat");
                arrayListBhola.add("Hatshoshiganj");
                arrayListBhola.add("Joynagar");
                arrayListBhola.add("Keramatganj");
                arrayListBhola.add("Lalmohan UPO");
                arrayListBhola.add("Mirzakalu");


            }
            arrayListJhalokati = new ArrayList<>();
            {
                arrayListJhalokati.add("Select");
                arrayListJhalokati.add("Amua");
                arrayListJhalokati.add("Baukathi");
                arrayListJhalokati.add("Beerkathi");
                arrayListJhalokati.add("Gabha");
                arrayListJhalokati.add("Jhalokati Sadar");
                arrayListJhalokati.add("Kathalia");
                arrayListJhalokati.add("Nabagram");
                arrayListJhalokati.add("Nalchhiti");
                arrayListJhalokati.add("Niamatee");
                arrayListJhalokati.add("Rajapur");
                arrayListJhalokati.add("Shekherhat");
                arrayListJhalokati.add("Shoulajalia");


            }
            arrayListBarguna = new ArrayList<>();
            {
                arrayListBarguna.add("Select");
                arrayListBarguna.add("Bamna");
                arrayListBarguna.add("Barguna Sadar");
                arrayListBarguna.add("Betagi");
                arrayListBarguna.add("Darul Ulum");
                arrayListBarguna.add("Kakchira");
                arrayListBarguna.add("Nali Bandar");
                arrayListBarguna.add("Patharghata");

            }
            arrayListPirojpur = new ArrayList<>();
            {
                arrayListPirojpur.add("Select");
                arrayListPirojpur.add("Banaripara");
                arrayListPirojpur.add("Bhandaria");
                arrayListPirojpur.add("Chakhar");
                arrayListPirojpur.add("Darus Sunnat");
                arrayListPirojpur.add("Dhaoa");
                arrayListPirojpur.add("Gulishakhali");
                arrayListPirojpur.add("Halta");
                arrayListPirojpur.add("Hularhat");
                arrayListPirojpur.add("Jalabari");
                arrayListPirojpur.add("Jolagati");
                arrayListPirojpur.add("Joykul");
                arrayListPirojpur.add("Kanudashkathi");
                arrayListPirojpur.add("Kaukhali");
                arrayListPirojpur.add("Kaurikhara");
                arrayListPirojpur.add("Keundia");
                arrayListPirojpur.add("Mathbaria");
                arrayListPirojpur.add("Nazirpur");
                arrayListPirojpur.add("Parerhat");
                arrayListPirojpur.add("Pirojpur Sadar");
                arrayListPirojpur.add("Shilarganj");
                arrayListPirojpur.add("Sriramkathi");
                arrayListPirojpur.add("Swarupkathi");
                arrayListPirojpur.add("Tiarkhali");
                arrayListPirojpur.add("Tushkhali");

            }
        }
        {
            arrayListKLD = new ArrayList<>();
            {
                arrayListKLD.add("Select");
                arrayListKLD.add("Khulna");
                arrayListKLD.add("Chuadanga");
                arrayListKLD.add("Jessore");
                arrayListKLD.add("Jhenaidah");
                arrayListKLD.add("Kushtia");
                arrayListKLD.add("Magura");
                arrayListKLD.add("Meherpur");
                arrayListKLD.add("Narail");
                arrayListKLD.add("Satkhira");
                arrayListKLD.add("Bagerhat");
            }

            arrayListKhulna = new ArrayList<>();
            {
                arrayListKhulna.add("Select");
                arrayListKhulna.add("Bagerhat Sadar");
                arrayListKhulna.add("Barabaria");
                arrayListKhulna.add("Bhanganpar Bazar");
                arrayListKhulna.add("Chalna Ankorage");
                arrayListKhulna.add("Charkulia");
                arrayListKhulna.add("Chitalmari");
                arrayListKhulna.add("Dariala");
                arrayListKhulna.add("Fakirhat");
                arrayListKhulna.add("Foylahat");
                arrayListKhulna.add("Gourambha");
                arrayListKhulna.add("Kachua");
                arrayListKhulna.add("Kahalpur");
                arrayListKhulna.add("Mansa");
                arrayListKhulna.add("Mollahat");
                arrayListKhulna.add("Mongla Port");
                arrayListKhulna.add("Morrelganj");
                arrayListKhulna.add("Nagarkandi");
                arrayListKhulna.add("P.C College");
                arrayListKhulna.add("Pak Gangni");
                arrayListKhulna.add("Rampal");
                arrayListKhulna.add("Rangdia");
                arrayListKhulna.add("Rayenda");
                arrayListKhulna.add("Sannasi Bazar");
                arrayListKhulna.add("Sonarkola");
                arrayListKhulna.add("Sonatunia");
                arrayListKhulna.add("Telisatee");

            }
            arrayListChuadanga = new ArrayList<>();
            {
                arrayListChuadanga.add("Select");
                arrayListChuadanga.add("Alamdanga");
                arrayListChuadanga.add("Andulbaria");
                arrayListChuadanga.add("Chuadanga Sadar");
                arrayListChuadanga.add("Damurhuda");
                arrayListChuadanga.add("Darshana");
                arrayListChuadanga.add("Doulatganj");
                arrayListChuadanga.add("Hardi");
                arrayListChuadanga.add("Munshiganj");

            }
            arrayListJessore = new ArrayList<>();
            {
                arrayListJessore.add("Select");
                arrayListJessore.add("Bagachra");
                arrayListJessore.add("Bagherpara");
                arrayListJessore.add("Basundia");
                arrayListJessore.add("Benapole");
                arrayListJessore.add("Bhugilhat");
                arrayListJessore.add("Chanchra");
                arrayListJessore.add("Chougachha");
                arrayListJessore.add("Churamankathi");
                arrayListJessore.add("Gouranagar");
                arrayListJessore.add("Jadabpur");
                arrayListJessore.add("Jashore Airbach");
                arrayListJessore.add("Jashore canttonment");
                arrayListJessore.add("Jashore Sadar");
                arrayListJessore.add("Jashore Upa - Shahar");
                arrayListJessore.add("Jhikargachha");
                arrayListJessore.add("Keshobpur");
                arrayListJessore.add("Monirampur");
                arrayListJessore.add("Noapara");
                arrayListJessore.add("Rajarhat");
                arrayListJessore.add("Rupdia");
                arrayListJessore.add("Sarsa");


            }
            arrayListJhenaidah = new ArrayList<>();
            {
                arrayListJhenaidah.add("Select");
                arrayListJhenaidah.add("Dobila");
                arrayListJhenaidah.add("Harinakundu");
                arrayListJhenaidah.add("Hat gopalpur Bazar");
                arrayListJessore.add("Jakaria");
                arrayListJessore.add("Jhenaidah Cadet College");
                arrayListJessore.add("Kangshee");
                arrayListJessore.add("Kotchandpur");
                arrayListJessore.add("Maheshpur");
                arrayListJessore.add("Mayadhorpur Village");
                arrayListJessore.add("Naldanga");
                arrayListJessore.add("Shailakupa");

            }
            arrayListKushtia = new ArrayList<>();
            {
                arrayListKushtia.add("Select");
                arrayListKushtia.add("Bheramara Bazar");
                arrayListKushtia.add("Boro Bazer");
                arrayListKushtia.add("BRB Bscic Area");
                arrayListKushtia.add("Chorhas");
                arrayListKushtia.add("Housing");
                arrayListKushtia.add("Islamic University");
                arrayListKushtia.add("Khas mathurapur");
                arrayListKushtia.add("Khoksa");
                arrayListKushtia.add("Kumarkhali");
                arrayListKushtia.add("Kumarkhali Bazar");
                arrayListKushtia.add("Kushtia Mohini");
                arrayListKushtia.add("Kushtia Sadar");
                arrayListKushtia.add("Lahini Bot Toil");
                arrayListKushtia.add("Mirpur");
                arrayListKushtia.add("Mojompur");
                arrayListKushtia.add("Mongolbari Bazar");
                arrayListKushtia.add("Poradaho Bazer");
                arrayListKushtia.add("Singer Mor");
                arrayListKushtia.add("Taragunia");
                arrayListKushtia.add("Tri-Mohoni Bazar");


            }
            arrayListMagura = new ArrayList<>();
            {
                arrayListMagura.add("Select");
                arrayListMagura.add("Magura Sadar");
                arrayListMagura.add("Mohammadpurr");
                arrayListMagura.add("Sreepur");
                arrayListMagura.add("Shalikha");
            }
            arrayListNarail = new ArrayList<>();
            {
                arrayListNarail.add("Select");
                arrayListNarail.add("Baradia");
                arrayListNarail.add("Itna");
                arrayListNarail.add("Kalia");
                arrayListNarail.add("Laxmipasha");
                arrayListNarail.add("Lohagora");
                arrayListNarail.add("Naldi");
                arrayListNarail.add("Narail Sadar");

            }
            arrayListSatkhira = new ArrayList<>();
            {
                arrayListSatkhira.add("Select");
                arrayListSatkhira.add("Ashashuni");
                arrayListSatkhira.add("Budhhat");
                arrayListSatkhira.add("Buri Goalini");
                arrayListSatkhira.add("Chandanpur");
                arrayListSatkhira.add("Debbhata");
                arrayListSatkhira.add("Gabura");
                arrayListSatkhira.add("Jhaudanga");
                arrayListSatkhira.add("Kalaroa");
                arrayListSatkhira.add("Kaliganj UPO");
                arrayListSatkhira.add("Nalta Mubaroknagar");
                arrayListSatkhira.add("Noornagar");
                arrayListSatkhira.add("Patkelghata");
                arrayListSatkhira.add("Ratanpur");
                arrayListSatkhira.add("Satkhira Islamia Acc");
                arrayListSatkhira.add("Satkhira Sadar");
                arrayListSatkhira.add("Taala");

            }
            arrayListBagerhat = new ArrayList<>();
            {
                arrayListBagerhat.add("Select");
                arrayListBagerhat.add("Bagerhat Sadar");
                arrayListBagerhat.add("Barabaria");
                arrayListBagerhat.add("Bhanganpar Bazar");
                arrayListBagerhat.add("Chalna Ankorage");
                arrayListBagerhat.add("Charkulia");
                arrayListBagerhat.add("Chitalmari");
                arrayListBagerhat.add("Dariala");
                arrayListBagerhat.add("Fakirhat");
                arrayListBagerhat.add("Foylahat");
                arrayListBagerhat.add("Gourambha");
                arrayListBagerhat.add("Kachua");
                arrayListBagerhat.add("Kahalpur");
                arrayListBagerhat.add("Mansa");
                arrayListBagerhat.add("Mollahat");
                arrayListBagerhat.add("Mongla Port");
                arrayListBagerhat.add("Morrelganj");
                arrayListBagerhat.add("Nagarkandi");
                arrayListBagerhat.add("P.C College");
                arrayListBagerhat.add("Pak Gangni");
                arrayListBagerhat.add("Rampal");
                arrayListBagerhat.add("Rangdia");
                arrayListBagerhat.add("Rayenda");
                arrayListBagerhat.add("Sannasi Bazar");
                arrayListBagerhat.add("Sonarkola");
                arrayListBagerhat.add("Sonatunia");
                arrayListBagerhat.add("Telisatee");

            }

        }

        {
            arrayListCTGD = new ArrayList<>();
            {
                arrayListCTGD.add("Select");
                arrayListCTGD.add("Chittagong");
                arrayListCTGD.add("Brahmanbaria");
                arrayListCTGD.add("Chandpur");
                arrayListCTGD.add("Lakshmipur");
                arrayListCTGD.add("Noakhali");
                arrayListCTGD.add("Feni");
                arrayListCTGD.add("Khagrachhari");
                arrayListCTGD.add("Rangamati");
                arrayListCTGD.add("Bandarban");
                arrayListCTGD.add("Cox's Bazar");
                arrayListCTGD.add("Others City");
            }
            arrayListChittagong = new ArrayList<>();
            {
                arrayListChittagong.add("Select");
                arrayListChittagong.add("Chattogram Sadar Al- Amin Baria Madra");
                arrayListChittagong.add("Chattogram Sadar Amin Jute Mills");
                arrayListChittagong.add("Chattogram Sadar Anandabazar");
                arrayListChittagong.add("Chattogram Sadar Bayezid Bostami");
                arrayListChittagong.add("Chattogram Sadar Chandgaon");
                arrayListChittagong.add("Chattogram Sadar Chattogram Airport");
                arrayListChittagong.add("Chattogram Sadar Chattogram Bandar");
                arrayListChittagong.add("Chattogram Sadar Chattogram GPO");
                arrayListChittagong.add("Chattogram Sadar Chawkbazar");
                arrayListChittagong.add("Chattogram Sadar Chitt. Cantonment");
                arrayListChittagong.add("Chattogram Sadar Chitt. Customs Acca");
                arrayListChittagong.add("Chattogram Sadar Chitt. Politechnic In");
                arrayListChittagong.add("Chattogram Sadar Chitt. Sailers Colon");
                arrayListChittagong.add("Chattogram Sadar Export Processing");
                arrayListChittagong.add("Chattogram Sadar Firozshah");
                arrayListChittagong.add("Chattogram Sadar Halishahar");
                arrayListChittagong.add("Chattogram Sadar Jalalabad");
                arrayListChittagong.add("Chattogram Sadar Jaldia Merine Accade");
                arrayListChittagong.add("Chattogram Sadar Middle Patenga");
                arrayListChittagong.add("Chattogram Sadar Mohard");
                arrayListChittagong.add("Chattogram Sadar North Halishahar");
                arrayListChittagong.add("Chattogram Sadar North Katuli");
                arrayListChittagong.add("Chattogram Sadar Pahartoli");
                arrayListChittagong.add("Chattogram Sadar Patenga");
                arrayListChittagong.add("Chattogram Sadar Rampura TSO");
                arrayListChittagong.add("Chattogram Sadar Wazedia");
                arrayListChittagong.add("Agrabad");
                arrayListChittagong.add("AK Khan");
                arrayListChittagong.add("Al- Amin Baria Madra");
                arrayListChittagong.add("Anandabazar");
                arrayListChittagong.add("Bayezid Bostami");
                arrayListChittagong.add("Chandgaon");
                arrayListChittagong.add("Chattogram Airport");
                arrayListChittagong.add("Chattogram Bandar");
                arrayListChittagong.add("Chattogram Cantonment");
                arrayListChittagong.add("Chattogram Customs Acca");
                arrayListChittagong.add("Chattogram GPO");
                arrayListChittagong.add("Chattogram New Market");
                arrayListChittagong.add("Chattogram Politechnic Institute");
                arrayListChittagong.add("Chattogram Sailers Colony");
                arrayListChittagong.add("Chawkbazar");
                arrayListChittagong.add("Colonel Hat");
                arrayListChittagong.add("Dakkshin Pahartoli");
                arrayListChittagong.add("Double Mooring");
                arrayListChittagong.add("Export Processing");
                arrayListChittagong.add("Firozshah");
                arrayListChittagong.add("GEC");
                arrayListChittagong.add("Halishshar");
                arrayListChittagong.add("Jalalabad");
                arrayListChittagong.add("Jaldia Marine Academy");
                arrayListChittagong.add("Kattuli");
                arrayListChittagong.add("Khulshi");
                arrayListChittagong.add("Kotwali");
                arrayListChittagong.add("Middle Patenga");
                arrayListChittagong.add("Mohard");
                arrayListChittagong.add("Nasirabad");
                arrayListChittagong.add("North Halishahar");
                arrayListChittagong.add("North Kattuli");
                arrayListChittagong.add("North Katuli");
                arrayListChittagong.add("Noyabazar");
                arrayListChittagong.add("Oxygen");
                arrayListChittagong.add("Pahartoli");
                arrayListChittagong.add("Panchlaish");
                arrayListChittagong.add("Patenga");
                arrayListChittagong.add("Rampura TSO");
                arrayListChittagong.add("Sadarghat");
                arrayListChittagong.add("South Halishahar");
                arrayListChittagong.add("Wazedia");

            }
            arrayListBrahmanbaria = new ArrayList<>();
            {
                arrayListBrahmanbaria.add("Select");
                arrayListBrahmanbaria.add("Akhaura");
                arrayListBrahmanbaria.add("Banchharampur");
                arrayListBrahmanbaria.add("Brahamanbaria Sadar");
                arrayListBrahmanbaria.add("Brahamanbaria Sadar Ashuganj");
                arrayListBrahmanbaria.add("Brahamanbaria Sadar Poun");
                arrayListBrahmanbaria.add("Brahamanbaria Sadar Talshahar");
                arrayListBrahmanbaria.add("Nasirnagar");
                arrayListBrahmanbaria.add("Sarail");
                arrayListBrahmanbaria.add("Kasba");
                arrayListBrahmanbaria.add("Bijoynagar");


            }
            arrayListChandpur = new ArrayList<>();
            {
                arrayListChandpur.add("Select");
                arrayListChandpur.add("Chandpur Sadar");
                arrayListChandpur.add("Chandpur Sadar Baburhat");
                arrayListChandpur.add("Chandpur Sadar Puranbazar");
                arrayListChandpur.add("Faridganj");
                arrayListChandpur.add("Haimchar");
                arrayListChandpur.add("Hajiganj");
                arrayListChandpur.add("Kachua");
                arrayListChandpur.add("Matlab Dakshin");
                arrayListChandpur.add("Matlab Uttar");
                arrayListChandpur.add("Shahrasti");


            }
            arrayListLakshmipur = new ArrayList<>();
            {
                arrayListLakshmipur.add("Select");
                arrayListLakshmipur.add("Lakshimpur Sadar");
                arrayListLakshmipur.add("Ramganj");
                arrayListLakshmipur.add("Raipur");
                arrayListLakshmipur.add("Ramgati");
                arrayListLakshmipur.add("Kamalnagar");

            }
            arrayListNoakhali = new ArrayList<>();
            {
                arrayListNoakhali.add("Select");
                arrayListNoakhali.add("Bishwanaath Bus Stop");
                arrayListNoakhali.add("Dotter Haat");
                arrayListNoakhali.add("Church Of The Queen Of Lourdes");
                arrayListNoakhali.add("Harinarayanpur Railway Station");
                arrayListNoakhali.add("Housing State");
                arrayListNoakhali.add("Medical Assistant Training School,Noakhali");
                arrayListNoakhali.add("Mohila College Morr");
                arrayListNoakhali.add("Noakhali Circuit House");
                arrayListNoakhali.add("Noakhali Sadar");
                arrayListNoakhali.add("Senbagh");
                arrayListNoakhali.add("Begumganj");
                arrayListNoakhali.add("Chatkhil");
                arrayListNoakhali.add("Companiganj");
                arrayListNoakhali.add("Kabirhat");
                arrayListNoakhali.add("Sonaimuri ");
                arrayListNoakhali.add("Suborno Char");

            }
            arrayListFeni = new ArrayList<>();
            {
                arrayListFeni.add("Select");
                arrayListFeni.add("Bhanga Takia Bazar Sharshadie");
                arrayListFeni.add("Cadet Collage");
                arrayListFeni.add("Court Buliding");
                arrayListFeni.add("Daud Pul");
                arrayListFeni.add("Doctor Para");
                arrayListFeni.add("Fazilpur Bus Stop Market");
                arrayListFeni.add("Feni Sadar");
                arrayListFeni.add("Feni Stadium");
                arrayListFeni.add("Feni University");
                arrayListFeni.add("Grand Trunk Road");
                arrayListFeni.add("Grand Trunk Road Squre");
                arrayListFeni.add("Hazir Bazar Post OfficeSharshadie");
                arrayListFeni.add("Kalidaha- Laskarhat Rd");
                arrayListFeni.add("Kasim Pur");
                arrayListFeni.add("Khaiyara The Head ");
                arrayListFeni.add("Lalpul");
                arrayListFeni.add("Laskarhat Post Office");
                arrayListFeni.add("Laskar Hat S C Laha Institution");
                arrayListFeni.add("Lemua Bazar Sharshadie");
                arrayListFeni.add("Mastar Para");
                arrayListFeni.add("Mohammad Ali Bazzar");
                arrayListFeni.add("Mohipal");
                arrayListFeni.add("Muhuri Bridge");
                arrayListFeni.add("Panchgachia Bazar");
                arrayListFeni.add("Petro Bangla");
                arrayListFeni.add("Police Line");
                arrayListFeni.add("Rampur");
                arrayListFeni.add("Ranir Hat");
                arrayListFeni.add("Sadar Hospital");
                arrayListFeni.add("Santi Company Road");
                arrayListFeni.add("Selena Parveen Road");
                arrayListFeni.add("Shodeb Pur");
                arrayListFeni.add("Tewmuhuni Bazar");
                arrayListFeni.add("Tongirpara Jame Masjid Sharshadie");
                arrayListFeni.add("Ukil Para");
                arrayListFeni.add("Daganbhuiyan Upazila");
                arrayListFeni.add("Chhagalnaiya Upazilar");
                arrayListFeni.add("Sonagazi Upazila");
                arrayListFeni.add("Parshuram Upazila");
                arrayListFeni.add("Fulgazi Upazila");


            }
            arrayListKhagrachhari = new ArrayList<>();
            {
                arrayListKhagrachhari.add("Select");
                arrayListKhagrachhari.add("Khagrachari Sadar");
                arrayListKhagrachhari.add("Dighinala Upazila");
                arrayListKhagrachhari.add("Lakshmichhari Upazila");
                arrayListKhagrachhari.add("Mahalchhari Upazila");
                arrayListKhagrachhari.add("Manikchhari Upazila");
                arrayListKhagrachhari.add("Matiranga Upazila");
                arrayListKhagrachhari.add("Panchhari Upazila");
                arrayListKhagrachhari.add("Ramgarh Upazila");
                arrayListKhagrachhari.add("Guimara Upazila");

            }
            arrayListRangamati = new ArrayList<>();
            {
                arrayListRangamati.add("Select");
                arrayListRangamati.add("Rangamati Sadar Upazila");
                arrayListRangamati.add("Belaichhari Upazila");
                arrayListRangamati.add("Bagaichhari Upazila");
                arrayListRangamati.add("Barkal Upazila");
                arrayListRangamati.add("Juraichhari Upazila");
                arrayListRangamati.add("Rajasthali Upazila");
                arrayListRangamati.add("Kaptai Upazila");
                arrayListRangamati.add("Langadu Upazila");
                arrayListRangamati.add("Naniarchar Upazila");
                arrayListRangamati.add("Kaukhali Upazila");

            }
            arrayListBandarban = new ArrayList<>();
            {
                arrayListBandarban.add("Select");
                arrayListBandarban.add("Alikadam");
                arrayListBandarban.add("Bandarban Sadar");
                arrayListBandarban.add("Naikhong");
                arrayListBandarban.add("Roanchhari");
                arrayListBandarban.add("Ruma");
                arrayListBandarban.add("Thanchi");
                arrayListBandarban.add("Thanchi Lama");
                arrayListBandarban.add("Naikhongchari");

            }
            arrayListCoxBazar = new ArrayList<>();
            {
                arrayListCoxBazar.add("Select");
                arrayListCoxBazar.add("Baharchora");
                arrayListCoxBazar.add("Bazarghata");
                arrayListCoxBazar.add("Bus Terminal");
                arrayListCoxBazar.add("Coxs Bazar Sadar");
                arrayListCoxBazar.add("Holyday More");
                arrayListCoxBazar.add("Kolatoly");
                arrayListCoxBazar.add("Laldighi Pa");
                arrayListCoxBazar.add("Pekua Upazila");
                arrayListCoxBazar.add("Ukhia Upazila");
                arrayListCoxBazar.add("Teknaf Upazila");
                arrayListCoxBazar.add("Ramu Upazila");
                arrayListCoxBazar.add("Maheshkhali Upazila");
                arrayListCoxBazar.add("Kutubdia Upazila");
                arrayListCoxBazar.add("Chakaria Upazila");

            }
            arrayListOther = new ArrayList<>();
            {
                arrayListCoxBazar.add("Select");
                arrayListCoxBazar.add("Other");

            }

        }


        {
            arrayListMMSD = new ArrayList<>();
            {
                arrayListMMSD.add("Select");
                arrayListMMSD.add("Mymensingh");
                arrayListMMSD.add("Netrokona");
                arrayListMMSD.add("Jamalpur");
                arrayListMMSD.add("Sherpur");
            }
            arrayListMymensingh = new ArrayList<>();
            {
                arrayListMymensingh.add("Select");
                arrayListMymensingh.add("Bhaluka");
                arrayListMymensingh.add("Trishal");
                arrayListMymensingh.add("Haluaghat");
                arrayListMymensingh.add("Muktagacha");
                arrayListMymensingh.add("Dhobaura");
                arrayListMymensingh.add("Fulbaria");
                arrayListMymensingh.add("Gaffargaon");
                arrayListMymensingh.add("Gauripur");
                arrayListMymensingh.add("Ishwarganj");
                arrayListMymensingh.add("Mymensingh Sadar");
                arrayListMymensingh.add("Nandail");
                arrayListMymensingh.add("Phulpur");
                arrayListMymensingh.add("Tarakanda");
                arrayListMymensingh.add("C.K. Gosh Road");
                arrayListMymensingh.add("Chorpara Area");
                arrayListMymensingh.add("Maskanda Bypass");
                arrayListMymensingh.add("Mymensingh Zero Point");
                arrayListMymensingh.add("Sankipara Jamtola Ses More");
                arrayListMymensingh.add("Tarakanda Bazar");
            }
            arrayListNetrokona = new ArrayList<>();
            {
                arrayListNetrokona.add("Select");
                arrayListNetrokona.add("Atpara");
                arrayListNetrokona.add("Barhatta");
                arrayListNetrokona.add("Dharmapasha");
                arrayListNetrokona.add("Dhobaura");
                arrayListNetrokona.add("Dhobaura Sakoai");
                arrayListNetrokona.add("Kalmakanda");
                arrayListNetrokona.add("Kendua");
                arrayListNetrokona.add("Khaliajuri Saddar");
                arrayListNetrokona.add("Khaliajuri Shaldigha");
                arrayListNetrokona.add("Madan Madan");
                arrayListNetrokona.add("Moddhynagar Moddoynagar");
                arrayListNetrokona.add("Mohanganj");
                arrayListNetrokona.add("Netrakona Sadar");
                arrayListNetrokona.add("Netrakona Sadar Baikherhati");
                arrayListNetrokona.add("Purbadhola Jaria Jhanjhail");
                arrayListNetrokona.add("Purbadhola Saddar");
                arrayListMymensingh.add("Purbadhola Shamgonj");
                arrayListMymensingh.add("Susung Durgapur");

            }
            arrayListJamalpur = new ArrayList<>();
            {
                arrayListJamalpur.add("Select");
                arrayListJamalpur.add("Jamalpur Nandina");
                arrayListJamalpur.add("Jamalpur Narundi");
                arrayListJamalpur.add("Jamalpur Sadar");
                arrayListJamalpur.add("Dewanganj Upazila");
                arrayListJamalpur.add("Baksiganj Upazila");
                arrayListJamalpur.add("Islampur Upazila");
                arrayListJamalpur.add("Jamalpur Sadar Upazila");
                arrayListJamalpur.add("Madarganj Upazila");
                arrayListJamalpur.add("Melandaha Upazila");
                arrayListJamalpur.add("Sarishabari Upazila");


            }
            arrayListSherpur = new ArrayList<>();
            {
                arrayListSherpur.add("Select");
                arrayListSherpur.add("Bakshigonj");
                arrayListSherpur.add("Jhinaigati");
                arrayListSherpur.add("Nakla");
                arrayListSherpur.add("Nakla Gonopaddi");
                arrayListSherpur.add("Nalitabari");
                arrayListSherpur.add("Nalitabari Hatibandha");
                arrayListSherpur.add("Sherpur Shadar");
                arrayListSherpur.add("Shribardi Shribardi");


            }
        }

        {
            arrayListRPD = new ArrayList<>();
            {
                arrayListRPD.add("Select");
                arrayListRPD.add("Rangpur");
                arrayListRPD.add("Dinajpur");
                arrayListRPD.add("Kurigram");
                arrayListRPD.add("Nilphamari");
                arrayListRPD.add("Gaibandha");
                arrayListRPD.add("Thakurgaon");
                arrayListRPD.add("Panchagarh");
                arrayListRPD.add("Lalmonirhat");
            }

            arrayListRangpur = new ArrayList<>();
            {
                arrayListRangpur.add("Select");
                arrayListRangpur.add("Adarsopara");
                arrayListRangpur.add("Ansari Mor");
                arrayListRangpur.add("Arshad Nagor");
                arrayListRangpur.add("Asrotpur");
                arrayListRangpur.add("Babukha");
                arrayListRangpur.add("Bangladesh Bank Mor");
                arrayListRangpur.add("Beacon Mor");
                arrayListRangpur.add("Betpotti");
                arrayListRangpur.add("Birganj");
                arrayListRangpur.add("Birol");
                arrayListRangpur.add("Boiragi Para");
                arrayListRangpur.add("Bokultola");
                arrayListRangpur.add("Borobari");
                arrayListRangpur.add("Boubazar");
                arrayListRangpur.add("Burirhat");
                arrayListRangpur.add("C.M.B Quarter");
                arrayListRangpur.add("C.O Bazar");
                arrayListRangpur.add("Cadet College");
                arrayListRangpur.add("Central Road");
                arrayListRangpur.add("Charokbari");
                arrayListRangpur.add("Chartola Mor");
                arrayListRangpur.add("Checkpost 3 Numbar");
                arrayListRangpur.add("Chikli Vata");
                arrayListRangpur.add("Chirirbandar");
                arrayListRangpur.add("Chokbazar");
                arrayListRangpur.add("Circuit House Lane");
                arrayListRangpur.add("City Bazar");
                arrayListRangpur.add("College Para");
                arrayListRangpur.add("D.C Mor");
                arrayListRangpur.add("Deodoba");
                arrayListRangpur.add("Dhap Engineer Para");
                arrayListRangpur.add("Dhap Haji Para");
                arrayListRangpur.add("Dhap Masterpara");
                arrayListRangpur.add("Dhap Sagor Para");
                arrayListRangpur.add("Dhap Sardar Para");

                arrayListRangpur.add("Dharsona");
                arrayListRangpur.add("Doctor Para");
                arrayListRangpur.add("Fulbari");
                arrayListRangpur.add("Gamostopara");
                arrayListRangpur.add("Ghunjonmor");
                arrayListRangpur.add("Gl Roy Road");
                arrayListRangpur.add("Gonespur");
                arrayListRangpur.add("Grand Hotel Mor");
                arrayListRangpur.add("Guptopara");
                arrayListRangpur.add("Gurati Para");
                arrayListRangpur.add("Habibnagar Akhalitari");
                arrayListRangpur.add("Hanumantola");
                arrayListRangpur.add("Haragach");
                arrayListRangpur.add("Horidebpur");
                arrayListRangpur.add("Indrarmore");
                arrayListRangpur.add("Jalkor");
                arrayListRangpur.add("Jummapara");
                arrayListRangpur.add("Jummapara Pakarmatha");

                arrayListRangpur.add("Kachari Bazar");
                arrayListRangpur.add("Kaharole");
                arrayListRangpur.add("Kakoli Lane");
                arrayListRangpur.add("Kamalkachna");
                arrayListRangpur.add("Kamarpara");
                arrayListRangpur.add("Karuponno Alamnagor");
                arrayListRangpur.add("Katki Para");
                arrayListRangpur.add("Kaunia");
                arrayListRangpur.add("Kellaband");
                arrayListRangpur.add("Kerani Para");
                arrayListRangpur.add("Khamar Mor");
                arrayListRangpur.add("Khasbag");
                arrayListRangpur.add("Kobaru");
                arrayListRangpur.add("Kukrul Golakatamor");
                arrayListRangpur.add("Lalkuti Lane");
                arrayListRangpur.add("Mahigonj");
                arrayListRangpur.add("Medical Pakarmatha");
                arrayListRangpur.add("Medical Purbo Gate");

                arrayListRangpur.add("Medical Quater");
                arrayListRangpur.add("Milonpara");
                arrayListRangpur.add("Mohadevpur");
                arrayListRangpur.add("Mondol Para");
                arrayListRangpur.add("Mordern");
                arrayListRangpur.add("Mulatol");
                arrayListRangpur.add("Munsipara");
                arrayListRangpur.add("Nazirrerhat");
                arrayListRangpur.add("New Jummapara");
                arrayListRangpur.add("Nil Kantho");
                arrayListRangpur.add("Nisbedganj");
                arrayListRangpur.add("Nurpur");
                arrayListRangpur.add("Pairaband");
                arrayListRangpur.add("Palpara");
                arrayListRangpur.add("Parbotipur Uposohor");
                arrayListRangpur.add("Parkmor");
                arrayListRangpur.add("Pasari Para");
                arrayListRangpur.add("Payra Chattar");

                arrayListRangpur.add("Pirgacha");
                arrayListRangpur.add("Pirpur");
                arrayListRangpur.add("Pouro Bazar");
                arrayListRangpur.add("Press Club");
                arrayListRangpur.add("Prime Medical");
                arrayListRangpur.add("Radhaballav");
                arrayListRangpur.add("Rail Station");
                arrayListRangpur.add("Rajendrapur");
                arrayListRangpur.add("Rangpur Cantontment");
                arrayListRangpur.add("Rangpur Sadar");
                arrayListRangpur.add("Rcc Mor");
                arrayListRangpur.add("Rfl Foundary");
                arrayListRangpur.add("RK Road");
                arrayListRangpur.add("Robertsongonj");
                arrayListRangpur.add("Salbon Mistripara");
                arrayListRangpur.add("Sardarpara");
                arrayListRangpur.add("Satgara Mistripara");
                arrayListRangpur.add("Satmatha");

                arrayListRangpur.add("Senpara");
                arrayListRangpur.add("Shampur");
                arrayListRangpur.add("Shantibag");
                arrayListRangpur.add("Shapla");
                arrayListRangpur.add("Shayamoli Lane");
                arrayListRangpur.add("Shimulbag");
                arrayListRangpur.add("Siyalurmor");
                arrayListRangpur.add("Sultanmor");
                arrayListRangpur.add("Super Market");
                arrayListRangpur.add("Tajhat");
                arrayListRangpur.add("Tati Para");
                arrayListRangpur.add("Thikadarpara");
                arrayListRangpur.add("Vogi Lane");
                arrayListRangpur.add("Others");
            }
            arrayListDinajpur = new ArrayList<>();
            {
                arrayListDinajpur.add("Select");
                arrayListDinajpur.add("Ansar Clubr");
                arrayListDinajpur.add("Asrom Para");
                arrayListDinajpur.add("Bahadur Bazar");
                arrayListDinajpur.add("Basuniya Potti");
                arrayListDinajpur.add("Bgb Camp");
                arrayListDinajpur.add("BKSP");
                arrayListDinajpur.add("Boro Gurgola");
                arrayListDinajpur.add("Boromath");
                arrayListDinajpur.add("Botibabur Mor");
                arrayListDinajpur.add("Bottoli Bazar");
                arrayListDinajpur.add("Bottoli Mor");
                arrayListDinajpur.add("Brac Center");
                arrayListDinajpur.add("Brtc Road");
                arrayListDinajpur.add("Bus Terminal");
                arrayListDinajpur.add("Cafetoria");
                arrayListDinajpur.add("Charubabur More");
                arrayListDinajpur.add("Chawliya Potti");
                arrayListDinajpur.add("Chehelgazi School");
                arrayListDinajpur.add("Chok Bazar");
                arrayListDinajpur.add("Choto Gurgola");
                arrayListDinajpur.add("Chourangi Mor");
                arrayListDinajpur.add("Churipotti Mor");
                arrayListDinajpur.add("City Park");
                arrayListDinajpur.add("Dabgach Mosque");
                arrayListDinajpur.add("Dailar Mor");
                arrayListDinajpur.add("Doshmile");
                arrayListDinajpur.add("Dotola Mosque Mor");
                arrayListDinajpur.add("Dttc");
                arrayListDinajpur.add("Education Board");
                arrayListDinajpur.add("Fakir Para");
                arrayListDinajpur.add("Foridpur Gorsthan");
                arrayListDinajpur.add("Gabura Bridge");
                arrayListDinajpur.add("Gaocia Gaerege Mor");
                arrayListDinajpur.add("Gausul Azom Eye Hospital");
                arrayListDinajpur.add("Ghasipara");

                arrayListDinajpur.add("Golapbag");
                arrayListDinajpur.add("Goneshtola");
                arrayListDinajpur.add("Gopalgonj Bazar");
                arrayListDinajpur.add("Goshaipur");
                arrayListDinajpur.add("Gunjabari");
                arrayListDinajpur.add("Horisova Mor");
                arrayListDinajpur.add("Hospital Mor");
                arrayListDinajpur.add("Housing Mor");
                arrayListDinajpur.add("Indra Mor");
                arrayListDinajpur.add("Iqbal School Mor");
                arrayListDinajpur.add("Islami Hospital");
                arrayListDinajpur.add("Jail Road");
                arrayListDinajpur.add("Jamaipara Mor");
                arrayListDinajpur.add("Jamtoli Bazar");
                arrayListDinajpur.add("Janata Bank Mor");
                arrayListDinajpur.add("Jogen Babur Math");
                arrayListDinajpur.add("Jorabridge");
                arrayListDinajpur.add("Kalur Mor");
                arrayListDinajpur.add("Kana Hafez Mor");
                arrayListDinajpur.add("Kanchon Bridge Mor");
                arrayListDinajpur.add("Khal Para");
                arrayListDinajpur.add("Khamar Kachai Road");
                arrayListDinajpur.add("Khetripara");
                arrayListDinajpur.add("Khokonmowlovi Mor");

                arrayListDinajpur.add("Kosba");
                arrayListDinajpur.add("Kumar Para");
                arrayListDinajpur.add("Labur Mor");
                arrayListDinajpur.add("Lalbag Mor");
                arrayListDinajpur.add("Law College Mor");
                arrayListDinajpur.add("Maldahpotti");
                arrayListDinajpur.add("Mamun Mor");
                arrayListDinajpur.add("Masimpur");
                arrayListDinajpur.add("Matasagor");
                arrayListDinajpur.add("Medical College");
                arrayListDinajpur.add("Mirzapur");
                arrayListDinajpur.add("Mission Road");
                arrayListDinajpur.add("Mohonpur");
                arrayListDinajpur.add("Mudi Para");
                arrayListDinajpur.add("Munshipara");
                arrayListDinajpur.add("Nimtola");
                arrayListDinajpur.add("Notun Para");
                arrayListDinajpur.add("Noyanpur");
                arrayListDinajpur.add("Paglamor");
                arrayListDinajpur.add("Paharpur");
                arrayListDinajpur.add("Patua Para");
                arrayListDinajpur.add("Police Line Market");
                arrayListDinajpur.add("Pollibiddud");
                arrayListDinajpur.add("Polytechnical College");

                arrayListDinajpur.add("Profesor Para");
                arrayListDinajpur.add("Promottori");
                arrayListDinajpur.add("Pti Mor");
                arrayListDinajpur.add("Rab -13 Camp");
                arrayListDinajpur.add("Rail Bazar");
                arrayListDinajpur.add("Rajbati");
                arrayListDinajpur.add("Ramnogor");
                arrayListDinajpur.add("Ramsagor");
                arrayListDinajpur.add("Ranigonj Mor");
                arrayListDinajpur.add("Sadeshsori Mor");
                arrayListDinajpur.add("Sekhpura");
                arrayListDinajpur.add("Shahi Mosjid Mor");
                arrayListDinajpur.add("Sikdar Hat");
                arrayListDinajpur.add("Six Way Mor");
                arrayListDinajpur.add("Sohid Minar Mor");
                arrayListDinajpur.add("Sostitola");
                arrayListDinajpur.add("Staf Quarter Mor");
                arrayListDinajpur.add("Station Road");
                arrayListDinajpur.add("Suksagor");
                arrayListDinajpur.add("Thana Mor");
                arrayListDinajpur.add("Upozila Get");
                arrayListDinajpur.add("Watertank Mor");
                arrayListDinajpur.add("Women Govt.College");
                arrayListDinajpur.add("Zia Heart Foundation");
            }
            arrayListKurigram = new ArrayList<>();
            {
                arrayListKurigram.add("Select");
                arrayListKurigram.add("Bhurungamari");
                arrayListKurigram.add("Chilmari");
                arrayListKurigram.add("Kurigram");
                arrayListKurigram.add("Nageshwari");
                arrayListKurigram.add("Rangalirbash");
                arrayListKurigram.add("Rowmari");
                arrayListKurigram.add("Ulipur");
                arrayListKurigram.add("Char Rajibpur Upazila");
                arrayListKurigram.add("Rajarhat Upazila");
            }
            arrayListNilphamari = new ArrayList<>();
            {
                arrayListNilphamari.add("Select");
                arrayListNilphamari.add("Nilphamari Sadar");
                arrayListNilphamari.add("Saidpur Upazila");
                arrayListNilphamari.add("Jaldhaka");
                arrayListNilphamari.add("Kishoreganj");
                arrayListNilphamari.add("Domar");
                arrayListNilphamari.add("Dimla");

            }
            arrayListGaibandha = new ArrayList<>();
            {
                arrayListGaibandha.add("Select");
                arrayListGaibandha.add("Fulchhari");
                arrayListGaibandha.add("Gaibandha Sadar");
                arrayListGaibandha.add("Gobindaganj");
                arrayListGaibandha.add("Palashbari");
                arrayListGaibandha.add("Sadullapur");
                arrayListGaibandha.add("Sundarganj");
                arrayListGaibandha.add("Saghata");

            }
            arrayListThakurgaon = new ArrayList<>();
            {
                arrayListThakurgaon.add("Select");
                arrayListThakurgaon.add("Goalpara");
                arrayListThakurgaon.add("Goshpara");
                arrayListThakurgaon.add("Islambag");
                arrayListThakurgaon.add("Jamidarpara");
                arrayListThakurgaon.add("Nishchintapur");
                arrayListThakurgaon.add("Thakurgaon");
                arrayListThakurgaon.add("Haripur Upazila");
                arrayListThakurgaon.add("Baliadangi Upazila");
                arrayListThakurgaon.add("Ranisankail Upazila");
                arrayListThakurgaon.add("Pirganj Upazila");
            }
            arrayListPanchagarh = new ArrayList<>();
            {
                arrayListPanchagarh.add("Select");
                arrayListPanchagarh.add("Docropara");
                arrayListPanchagarh.add("Panchagarh Sadar");
                arrayListPanchagarh.add("Boda");
                arrayListPanchagarh.add("Atwari");
                arrayListPanchagarh.add("Tetulia");

            }
            arrayListLalmonirhat = new ArrayList<>();
            {
                arrayListPanchagarh.add("Select");
                arrayListPanchagarh.add("Barabari");
                arrayListPanchagarh.add("Lalmonirhat Sadar");
                arrayListPanchagarh.add("Aditmari");
                arrayListPanchagarh.add("Kaliganj");
                arrayListPanchagarh.add("Hatibandha");
                arrayListPanchagarh.add("Patgram");

            }
        }

        {
            arrayListSD = new ArrayList<>();
            {
                arrayListSD.add("Select");
                arrayListSD.add("Sylhet");
                arrayListSD.add("Sunamganj");
                arrayListSD.add("Moulvibazar");
                arrayListSD.add("Habiganj");
            }
            arrayListSylhet = new ArrayList<>();
            {
                arrayListSylhet.add("Select");
                arrayListSylhet.add("Alampur");
                arrayListSylhet.add("Bandar Bazar");
                arrayListSylhet.add("Baruth Khana");
                arrayListSylhet.add("Borobazar");
                arrayListSylhet.add("Boteshshor");
                arrayListSylhet.add("Chandipul");
                arrayListSylhet.add("Chauhatta");
                arrayListSylhet.add("Dargah Gate");
                arrayListSylhet.add("Electric Supply");
                arrayListSylhet.add("Fazil Chisth");
                arrayListSylhet.add("Gutatikar");
                arrayListSylhet.add("Housing Estate");
                arrayListSylhet.add("Jaintapur");
                arrayListSylhet.add("Kanaighat Gachbari");
                arrayListSylhet.add("Kanaighat Kanaighat");
                arrayListSylhet.add("Kanaighat Manikganj");
                arrayListSylhet.add("Kazir Bazar");
                arrayListSylhet.add("Kazi Tula");
                arrayListSylhet.add("Kompanyganj");
                arrayListSylhet.add("Kumar Para");
                arrayListSylhet.add("Kurshi Ghat");
                arrayListSylhet.add("Machimpur");
                arrayListSylhet.add("Mehendibagh");
                arrayListSylhet.add("Mezor Tila");

                arrayListSylhet.add("Miah Fazil Chist");
                arrayListSylhet.add("Mira Bazar");
                arrayListSylhet.add("Mirer Maidan");
                arrayListSylhet.add("Modina Market");
                arrayListSylhet.add("Raynagar");
                arrayListSylhet.add("Rekabi Bazar");
                arrayListSylhet.add("Saudagar Tola");
                arrayListSylhet.add("Sekhghat");
                arrayListSylhet.add("Shahjalal Uposhohor");
                arrayListSylhet.add("Shah Poran");
                arrayListSylhet.add("Sonarpara");
                arrayListSylhet.add("Subid Bazar");
                arrayListSylhet.add("Sylhet Sadar");
                arrayListSylhet.add("Sylhet Sadar Biman Bondar");
                arrayListSylhet.add("Sylhet Sadar Birahimpur");
                arrayListSylhet.add("Sylhet Sadar Jalalabad");
                arrayListSylhet.add("Sylhet Sadar Jalalabad Cantonment");
                arrayListSylhet.add("Sylhet Sadar Kadamtali");
                arrayListSylhet.add("Sylhet Sadar Kamalbazer");
                arrayListSylhet.add("Sylhet Sadar Khadimnagar");
                arrayListSylhet.add("Sylhet Sadar Lalbazar");
                arrayListSylhet.add("Sylhet Sadar Mogla");
                arrayListSylhet.add("Sylhet Sadar Ranga Hajiganj");
                arrayListSylhet.add("Sylhet Sadar Shahajalal University");
                arrayListSylhet.add("Sylhet Sadar Sylhet Cadet College");
                arrayListSylhet.add("Tilaghar");
                arrayListSylhet.add("Tuliikar");
                arrayListSylhet.add("Zinda Bazar");

                arrayListSylhet.add("Birahimpur");
                arrayListSylhet.add("Jalalabad");
                arrayListSylhet.add("Jalalabad Cantoment");
                arrayListSylhet.add("Kadamtali");
                arrayListSylhet.add("Kamalbazer");
                arrayListSylhet.add("Khadimnagar");
                arrayListSylhet.add("Lalbazar");
                arrayListSylhet.add("Mongla");
                arrayListSylhet.add("Ranga Hajiganj");
                arrayListSylhet.add("Shahajalal University Sylhet");
                arrayListSylhet.add("Silam");
                arrayListSylhet.add("Sylhet Biman Bondar");
                arrayListSylhet.add("Sylhet Cadet College");
                arrayListSylhet.add("Sylhet Sadar");


            }
            arrayListSunamganj = new ArrayList<>();
            {
                arrayListSunamganj.add("Bishwamvarpur");
                arrayListSunamganj.add("Chhatak");
                arrayListSunamganj.add("Dakshin Sunamganj");
                arrayListSunamganj.add("Derai");
                arrayListSunamganj.add("Dharamapasha");
                arrayListSunamganj.add("Dowarabazar");
                arrayListSunamganj.add("Jagannathpurt");
                arrayListSunamganj.add("Jamalganj");
                arrayListSunamganj.add("Sullah");
                arrayListSunamganj.add("Sunamganj Sadar");
                arrayListSunamganj.add("Tahirpur");
            }
            arrayListMoulvibazar = new ArrayList<>();
            {
                arrayListMoulvibazar.add("Moulvibazar Sadar");
                arrayListMoulvibazar.add("Kamalganj");
                arrayListMoulvibazar.add("Kulaura");
                arrayListMoulvibazar.add("Rajnagar");
                arrayListMoulvibazar.add("Sreemangal");
                arrayListMoulvibazar.add("Barlekha");
                arrayListMoulvibazar.add("Juri");

            }
            arrayListHabiganj = new ArrayList<>();
            {
                arrayListHabiganj.add("Ajmiriganj");
                arrayListHabiganj.add("Baniachang");
                arrayListHabiganj.add("Bahubal");
                arrayListHabiganj.add("Chunarughat");
                arrayListHabiganj.add("Habiganj Sadar");
                arrayListHabiganj.add("Lakhai");
                arrayListHabiganj.add("Madhabpur");
                arrayListHabiganj.add("Nabiganj");
                arrayListHabiganj.add("Sayestaganj");

            }
        }

        arrayList_relation = new ArrayList<>();
        {
            arrayList_relation.add("Select");
            arrayList_relation.add("Friend");
            arrayList_relation.add("Teacher");
            arrayList_relation.add("Spouse(Husband/Wife)");
            arrayList_relation.add("Father");
            arrayList_relation.add("Mother");
            arrayList_relation.add("Brother");
            arrayList_relation.add("Sister");
            arrayList_relation.add("Son");
            arrayList_relation.add("Boyfriend");
            arrayList_relation.add("Girlfriend");
            arrayList_relation.add("Daughter");
            arrayList_relation.add("Grandparent");
            arrayList_relation.add("Grandfather");
            arrayList_relation.add("Grandmother");
            arrayList_relation.add("Grandson");
            arrayList_relation.add("Granddaughter");
            arrayList_relation.add("Uncle");
            arrayList_relation.add("Aunt");
            arrayList_relation.add("Cousin");
            arrayList_relation.add("Nephew");
            arrayList_relation.add("Niece");
            arrayList_relation.add("Niegbour");
            arrayList_relation.add("EX");

        }




        r_relation = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_relation);
        Rel_type.setAdapter(r_relation);

        bloodquan = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListBloodQuan);
        Quantity.setAdapter(bloodquan);

        r_blood_type = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_bloodtype);
        need_type.setAdapter(r_blood_type);

        r_division = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Division);
        Division.setAdapter(r_division);

        r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListnull);
        District.setAdapter(r_district);

        r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull );
        Area.setAdapter(r_area);

        Division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListDHKD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListDHKA);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.dhaka_hospital);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListGazipur);

                                Area.setAdapter(r_area);

                                String[] hos = getResources().getStringArray(R.array.gazipur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);


                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListkishorganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.kishoreganj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListmunshiganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.mun_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==5) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnarayanganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.narayanganj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==6) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListsingdi);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.narsingdi_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==7) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListfaridpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.faridpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==8) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListtangail);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.tangail_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==9) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arraygopalganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.gopalganj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==10) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListmadaripur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.madaripur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==11) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListrajbari);
                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.rajbari_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==12) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListshariatpur );

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.shariatpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                if(position==2)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListRJD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListRajshahi);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.rajshahi_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListChapainawabganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.chapainawabganj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,  arrayListJoypurhat);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.joypurhat_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListNaogaon);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.naogaon_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==5) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListNatore);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.natore_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==6) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListPabna);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.pabna_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==7) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBogura);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.bogura_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==8) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListSirajgonj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.sirajgonj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }



                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                if(position==3)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListBSD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBarisal);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.barisal_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListPatuakhali);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.patuakhali_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBhola);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.bhola_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListJhalokati);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.jhalokati_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==5) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBarguna);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.barguna_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==6) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListPirojpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.pirojpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                if(position==4)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListCTGD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListChittagong);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.chittagong_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBrahmanbaria);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.brahmanbaria_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListChandpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.chandpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListLakshmipur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.lakshmipur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==5) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListNoakhali);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.noakhali_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==6) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListFeni);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.feni_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==7) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListKhagrachhari);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.khagrachhari_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==8) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListRangamati);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.rangamati_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==9) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBandarban);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.bandarban_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==10) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListCoxBazar);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.CoxBazar_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==11) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListOther);

                                Area.setAdapter(r_area);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                if(position==5)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListKLD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListKhulna);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.khulna_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListChuadanga);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.chuadanga_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListJessore);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.jessore_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListJhenaidah);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.jhenaidah_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==5) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListKushtia);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.kushtia_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==6) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListMagura);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.magura_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==7) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListNarail);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.narail_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==8) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListSatkhira);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.satkhira_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==9) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListBagerhat);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.bagerhat_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                if(position==6)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListMMSD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListMymensingh);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.mymensingh_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListNetrokona);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.netrokona_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListJamalpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.jamalpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListSherpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.sherpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                if(position==7)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListRPD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListRangpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.rangpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListDinajpur);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.dinajpur_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListKurigram);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.kurigram_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListNilphamari);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.nilphamari_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==5) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListGaibandha);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.gaibandha_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==6) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListThakurgaon);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.thakurgaon_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==7) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListPanchagarh);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.panchagarh_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==8) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListLalmonirhat);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.lalmonirhat_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                if(position==8)  {
                    r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListSD);
                    District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListSylhet);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.sylhet_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==2) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListSunamganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.sunamganj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==3) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListMoulvibazar);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.moulvibazar_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }
                            if(position==4) {
                                r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListHabiganj);

                                Area.setAdapter(r_area);
                                String[] hos = getResources().getStringArray(R.array.habiganj_hosp);
                                adapter_hos = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,hos);
                                hospital.setThreshold(1);
                                hospital.setAdapter(adapter_hos);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            r_area = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListnull);

                            Area.setAdapter(r_area);
                        }
                    });
                }
                District.setAdapter(r_district);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                r_district = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayListnull);
                District.setAdapter(r_district);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    String NFID_method(){
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(datePicker.getYear());
        stringBuilder3.append((datePicker.getMonth() + 1));
        stringBuilder3.append(datePicker.getDayOfMonth());
        stringBuilder3.append(timePicker.getHour());
        stringBuilder3.append(timePicker.getMinute());
        stringBuilder3.append(userID);
        return stringBuilder3.toString().trim();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    String HID_method(){
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(datePicker.getYear());
        stringBuilder4.append((datePicker.getMonth() + 1));
        return stringBuilder4.toString().trim();
    }
    String currentDate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(datePicker.getDayOfMonth() + "/");
        stringBuilder.append((datePicker.getMonth() + 1) + "/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
    String currentDate2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(datePicker2.getDayOfMonth() + "/");
        stringBuilder.append((datePicker2.getMonth() + 1) + "/");
        stringBuilder.append(datePicker2.getYear());

        return stringBuilder.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button17) {
            mbirth = currentDate();
            give_date = currentDate2();
            if (mbirth == null || give_date == null) {
                Toast.makeText(getApplicationContext(), "please enter your date of birth", Toast.LENGTH_LONG).show();
            } else {
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date1 = simpleDateFormat1.parse(mbirth);
                    Date date3 = simpleDateFormat1.parse(give_date);
                    Date date2 = simpleDateFormat1.parse(mtoday);

                    long startDate = date1.getTime();
                    long endDate = date2.getTime();
                    long giveDate2 = date3.getTime();


                    Period period = new Period(startDate, endDate, PeriodType.yearMonthDay());
                    Period period2 = new Period(endDate, giveDate2, PeriodType.yearMonthDay());
                    int years = period.getYears();
                    months = period.getMonths();
                    days = period.getDays();

                    ages = years;
                    years2 = period2.getYears();
                    months2 = period2.getMonths();
                    days2 = period2.getDays();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            if (ages < 0 || ages > 100) {
                Toast.makeText(getApplicationContext(), "YPlease Enter valid date", Toast.LENGTH_LONG).show();
                return;
            }
            if (years2 > 0) {
                Toast.makeText(getApplicationContext(), "You can not give blood request date more  than 1 month", Toast.LENGTH_LONG).show();
                return;
            }
            if (months2 > 1) {
                Toast.makeText(getApplicationContext(), "You can not give blood request date more  than 1 month", Toast.LENGTH_LONG).show();
                return;
            } else {
                need_date = give_date;
            }


            int selectedId = radioGroup.getCheckedRadioButtonId();
            int selectedId2 = radioGroup2.getCheckedRadioButtonId();
            gender = findViewById(selectedId);
            covid = findViewById(selectedId2);
            final String patient_name = request_fullname.getText().toString();
            final String patient_number = request_number.getText().toString();
            if (TextUtils.isEmpty(patient_name)) {
                request_fullname.setError("Patient Name Required");
                Toast.makeText(BloodFromActivity.this, "Patient Name Required", Toast.LENGTH_LONG).show();
                return;
            }

            if (TextUtils.isEmpty(patient_number)) {
                request_number.setError("Mobile Number Required");
                Toast.makeText(BloodFromActivity.this, "Mobile Number Required", Toast.LENGTH_LONG).show();
                return;
            }

            if (gender == null) {

                Toast.makeText(BloodFromActivity.this, "Selected gender", Toast.LENGTH_SHORT).show();
                return;
            }
            final String gen = gender.getText().toString();
            if (covid == null) {

                Toast.makeText(BloodFromActivity.this, "Select Covid", Toast.LENGTH_SHORT).show();
                return;
            }
            final String cov = covid.getText().toString();

            final String blood_value = p_group.getSelectedItem().toString();
            if (blood_value.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "Selected Blood Group", Toast.LENGTH_SHORT).show();
                return;
            }
            final String division_value = Division.getSelectedItem().toString();
            if (division_value.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "Division not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            final String district_value = District.getSelectedItem().toString();
            if (district_value.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "District not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            final String area_value = Area.getSelectedItem().toString();
            if (area_value.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "Area not selected", Toast.LENGTH_LONG).show();
                return;
            }
            final String patient_hospital = hospital.getText().toString().trim();
            if (TextUtils.isEmpty(patient_hospital)) {
                hospital.setError("Enter Hospital Name");
                return;
            }
            final String patient_location = blood_location.getText().toString().trim();
            if (TextUtils.isEmpty(patient_location)) {
                blood_location.setError("Enter Hospital Name");
                return;
            }
            final String patient_need_type = reasonbldauto.getText().toString().trim();
            if (TextUtils.isEmpty(patient_need_type)) {
                reasonbldauto.setError("Enter Reason");
                return;
            }

            final String relation_value = Rel_type.getSelectedItem().toString();
            if (relation_value.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "Select Relationship", Toast.LENGTH_SHORT).show();
                return;
            }
            final String blood_type = need_type.getSelectedItem().toString();
            if (blood_type.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "blood type not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            final String quantity_value = Quantity.getSelectedItem().toString();
            if (quantity_value.equals("Select")) {
                Toast.makeText(BloodFromActivity.this, "Quantity not selected", Toast.LENGTH_LONG).show();
                return;
            }
            final String patient_note = Reason.getText().toString().trim();
            if (TextUtils.isEmpty(patient_note)) {
                Reason.setError("Enter Reson(Minimum 50 Word)");
                return;

            }
            if (patient_note.length() < 50) {
                Reason.setError("Enter Reson(Minimum 50 Word)");
                return;
            }


            need_time = timePicker.getHour() + ":" + timePicker.getMinute();

            final DocumentReference documentReference1 = fstore.collection("News_Feed").document(NFID_method());
            documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                    Map<String, Object> user = new HashMap<>();
                    user.put("Title", "Blood Needed");
                    user.put("Mobile", patient_number);
                    user.put("DOB", mbirth);
                    user.put("Description", blood_value);

                    user.put("Area", area_value);

                    user.put("Uploader_ID", userID);
                    user.put("Blood_Giving_Time", need_time);
                    user.put("Blood_Giving_Date", need_date);


                    user.put("NFID", NFID_method());
                    user.put("Category", "Blood");


                    user.put("Upload_User_ID", userID);

                    user.put("Uploader_Profile_Photo", "bfuser/" + userID + "profile.jpg");

                    documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                        @Override
                        public void onSuccess(Void aVoid) {



                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(BloodFromActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });


            final DocumentReference documentReference3 = fstore.collection("Blood_Detail").document(userID).collection("History").document(NFID_method());
            documentReference3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot1, @Nullable FirebaseFirestoreException e2) {


                    Map<String, Object> user = new HashMap<>();
                    user.put("Patient_Name", patient_name);
                    user.put("Mobile", patient_number);
                    user.put("DOB", mbirth);
                    user.put("Blood_group", blood_value);
                    user.put("Gender", gen);
                    user.put("Covid", cov);
                    user.put("Division", division_value);
                    user.put("District", district_value);
                    user.put("Area", area_value);
                    user.put("Apply_Date", mtoday);
                    user.put("Age", String.valueOf(ages));

                    user.put("Blood_Giving_Time", need_time);
                    user.put("Blood_Giving_Date", need_date);
                    user.put("Reason", patient_note);
                    user.put("Hospital_Blood_Bank", patient_hospital);
                    user.put("Location", patient_location);
                    user.put("Blood_Quantity", quantity_value);
                    user.put("Blood_Type", blood_type);
                    user.put("Relation_With_Patient", relation_value);
                    user.put("Upload_Date", mtoday);

                    user.put("Blood_Patient_Problem", patient_need_type);
                    user.put("NFID", NFID_method());


                    documentReference3.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                        @Override
                        public void onSuccess(Void aVoid) {
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_bloodadd_toast,(ViewGroup)v.findViewById(R.id.bloodadd));
                            final Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_LONG));
                            toast.setView(layout1);
                            toast.show();
                            Intent intent = new Intent(BloodFromActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            LayoutInflater inflater1 = getLayoutInflater();                             ///custom toast//
                            View layout1 = inflater1.inflate(R.layout.custom_error_admin_toast,(ViewGroup)v.findViewById(R.id.errorad));
                            final Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                            toast.setDuration((Toast.LENGTH_LONG));
                            toast.setView(layout1);
                            toast.show();
                            Toast.makeText(BloodFromActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });
        }
    }
}