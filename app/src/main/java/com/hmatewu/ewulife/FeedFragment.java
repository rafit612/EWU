package com.hmatewu.ewulife;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;


import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;




public class FeedFragment extends Fragment {

    public static final String EXTRA_NFID= "com.hm.roktojoddha.EXTRA_NFID";
    public static final String EXTRA_MOBILE= "com.hm.roktojoddha.EXTRA_MOBILE";
    public static final String EXTRA_ID= "com.hm.roktojoddha.EXTRA_ID";
    public FirebaseFirestore fstore;

   public RecyclerView recyclerView;
   public ArrayList<String> arrayList_parent;
   public ArrayAdapter<String> arrayAdapter_parent;


    List<String> cgpa_list = new ArrayList<>();
    public Query query;

    FirestorePagingAdapter adapter;
    public FeedFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feed, container, false);




            fstore=FirebaseFirestore.getInstance();

            recyclerView= v.findViewById(R.id.rev_view);

            arrayList_parent = new ArrayList<>();


            query = fstore.collection("News_Feed").orderBy("NFID",Query.Direction.DESCENDING);
            PagedList.Config config = new PagedList.Config.Builder()
                    .setInitialLoadSizeHint(5).setPageSize(3).build();

            FirestorePagingOptions< newsadapter > options = new FirestorePagingOptions.Builder<newsadapter>()
                    .setLifecycleOwner(getActivity())
                    .setQuery(query, config, new SnapshotParser<newsadapter>() {
                        @NonNull
                        @Override
                        public newsadapter parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                            newsadapter newsadaptermodel =snapshot.toObject(newsadapter.class);
                            String itemID = snapshot.getId();
                            newsadaptermodel.setItem_id(itemID);
                            return newsadaptermodel;
                        }
                    }).build();


            adapter = new FirestorePagingAdapter<newsadapter, ProductViewHolder>(options) {
                @NonNull
                @Override
                public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycle, parent, false);
                    return new ProductViewHolder(view);
                }

                @Override
                public void onBindViewHolder(@NonNull ProductViewHolder holder, int positions, @NonNull final newsadapter newsadapter) {

                    holder.a1.setText(newsadapter.getTitle());
                    holder.a2.setText(newsadapter.getDescription());
                    holder.b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String n_fid= newsadapter.getNFID();
                            String category = newsadapter.getCategory();
                            String mobile = newsadapter.getMobile();
                            String id = newsadapter.getUpload_User_ID();

                            if(category.equals("Blood")){
                                Intent intent = new Intent(getActivity(), BloodInfoActivity.class);
                                intent.putExtra(EXTRA_NFID, n_fid);
                                intent.putExtra(EXTRA_MOBILE, mobile);
                                intent.putExtra(EXTRA_ID, id);
                                startActivity(intent);
                            }
                            if(category.equals("Add")){
                                Intent intent = new Intent(getActivity(), AddDropActivity.class);
                                startActivity(intent);
                            }
                            if(category.equals("Calender")){
                                Intent intent = new Intent(getActivity(), CalenderActivity.class);
                                startActivity(intent);
                            }
                            if(category.equals("Advising")){
                                Intent intent = new Intent(getActivity(), AdvisingActivity.class);
                                startActivity(intent);
                            }
                            if(category.equals("Course")){
                                Intent intent = new Intent(getActivity(), Course_ChartActivity.class);
                                startActivity(intent);
                            }
                            if(category.equals("Club")){

                                Intent intent = new Intent(getActivity(), ClubInfoActivity.class);
                                intent.putExtra(EXTRA_NFID, n_fid);
                                intent.putExtra(EXTRA_ID, id);
                                startActivity(intent);

                            }
                            if(category.equals("Others")){
                                Intent intent = new Intent(getActivity(),EWUNoticeActivity.class);
                                intent.putExtra(EXTRA_NFID, n_fid);
                                intent.putExtra(EXTRA_ID, id);
                                startActivity(intent);
                            }

                        }
                    });





                }

                @Override
                public void onLoadingStateChanged(@NonNull LoadingState state) {
                    super.onLoadingStateChanged(state);
                    switch (state){
                        case LOADING_INITIAL:Toast.makeText(getActivity(), "Loading Initial Data", Toast.LENGTH_SHORT).show();
                            break;
                        case LOADING_MORE:Toast.makeText(getActivity(), "Loading Next Page", Toast.LENGTH_SHORT).show();
                            break;

                        case FINISHED: Toast.makeText(getActivity(), "Finished", Toast.LENGTH_SHORT).show();
                            break;
                        case ERROR:   Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                            break;

                        case LOADED:  Toast.makeText(getActivity(), "Loaded", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            };




            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);








        return v;
    }




    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView a1,a2;
        Button b1;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            try{
                a1 = itemView.findViewById(R.id.textView67);
                a2 = itemView.findViewById(R.id.textView68);
                b1 = itemView.findViewById(R.id.button9);

            } catch (Exception e) {
                Toast.makeText(getActivity(), "error= "+e, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        }
    }

}