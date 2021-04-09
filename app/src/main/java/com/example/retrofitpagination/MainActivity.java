 package com.example.retrofitpagination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofitpagination.API.apiClient;
import com.example.retrofitpagination.API.apiService;
import com.example.retrofitpagination.Moddel.Medicine;
import com.example.retrofitpagination.Moddel.Response;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

 public class MainActivity extends AppCompatActivity {

/*ArrayList<Medicine> mediList;*/

     // Initialize Variable

   NestedScrollView nestedScrollView;
    //ScrollView scrollView;

    RecyclerView recyclerView;
    ProgressBar progressBar;


    //Api Initialize

     private Retrofit retrofit;              // = ApiClient.getClient();
     private apiService api;                //= retrofit.create(ApiService.class);

     //  initialize Response variable   for data show adpter to reclyeview

    Response dataArrayList ;

     MainAdapter adapter ;

     // Initialize Pagination
      int page =1,limit = 10;


    /*  //Pagination from api
      int page =1,limit = 10;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intFunction();

     /*   // pagination from api
        intApiIntregate(page,limit);*/


        intApiIntregate();


/*

                     nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                         @Override
                         public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                       // Pagination data from api

                            if (scrollY == v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight())
                            {
                                  page++;

                                progressBar.setVisibility(View.VISIBLE);


                            }




                         }
                     });
*/





 // Set Layout Manager
 recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }








     private void intApiIntregate() {


        //Assign api Variable

         retrofit = apiClient.getClient();
         api = retrofit.create(apiService.class);



         Call<Response> call;
/*
         // Pagination from api
         call = api.medicinelist(page, limit);
         */


     /*    mediList=new ArrayList<>();*/  // sad



         call = api.medicinelist();
         call.enqueue(new Callback<Response>() {


             @Override
             public void onResponse(Call<Response> call, retrofit2.Response<Response> finddata) {

                 //Check Condition

                 if (finddata.isSuccessful() && finddata.body() !=null) {
                     // When Response is Succefully and not empty
                     // hide progress bar

                     progressBar.setVisibility(View.GONE);

                     // Initialize json variable
                     dataArrayList = finddata.body();

                     //sad
/*
                     for(Medicine md:finddata.body().getMedicines())
                     {
                         Toast.makeText(MainActivity.this, ""+md.getDrugs(), Toast.LENGTH_SHORT).show();

                         mediList.add(new Medicine(md.getDrugs()));
                     }*/

                     //Initial Adapter

                   /* adapter = new MainAdapter(recyclerView,(ArrayList<Medicine>) dataArrayList.getMedicines(),MainActivity.this);*/
                     //Set adapter

                     adapter = new MainAdapter((ArrayList<Medicine>)dataArrayList.getMedicines(),MainActivity.this);

                     recyclerView.setAdapter(adapter);


                 }


             }

             @Override
             public void onFailure(Call<Response> call, Throwable t) {

             }
         });


     }


     //Int Function for Assign Variable
     private void intFunction() {

       /* nestedScrollView = findViewById(R.id.Scroll_Viewid);*/
        progressBar = findViewById(R.id.progress_barid);
        recyclerView = findViewById(R.id.recycler_viewid);

     }
 }