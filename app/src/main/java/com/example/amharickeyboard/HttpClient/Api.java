package com.example.amharickeyboard.HttpClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "http://192.168.43.240:5000";
    @GET("/api/v1/{word}")
    Call<List<String>> getSugessions(@Path(value="word", encoded=true) String word);
}
