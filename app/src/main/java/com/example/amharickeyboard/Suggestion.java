package com.example.amharickeyboard;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Suggestion {

    private static Suggestion instance = new Suggestion();
    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private final String url = "http://192.168.43.240:5000/api/v1/ዛሬ ሃገር ሰላም";

    public static Suggestion createInstance(){
        return instance;
    }

    public String getSuggestions(String text){
        try {
            post(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            Log.e("TAG", "getSuggestions: Error");
//            Log.d("TAG", e.getMessage());
        }
        return null;

    }

    public void post(String text) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    Log.d("TAG", myResponse);

                }
            }
    });

}
}
