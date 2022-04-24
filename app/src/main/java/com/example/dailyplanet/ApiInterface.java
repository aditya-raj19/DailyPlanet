package com.example.dailyplanet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URl="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainnews>getnews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );
    @GET("top-headlines")
    Call<mainnews>getCategorynews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );

}
