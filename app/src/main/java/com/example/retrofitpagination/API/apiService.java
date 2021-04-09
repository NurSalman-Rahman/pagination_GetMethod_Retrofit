package com.example.retrofitpagination.API;

import com.example.retrofitpagination.Moddel.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiService {



    @GET("medicineList.php")
    Call<Response> medicinelist();





    // Pagination data from api
    //Call<Response> medicinelist(@Query("page")int page,@Query("limit") int limit);

}
