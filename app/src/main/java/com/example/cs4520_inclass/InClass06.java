package com.example.cs4520_inclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class InClass06 extends AppCompatActivity {

    private TextView textView;
    private final OkHttpClient client = new OkHttpClient();
    private ListView listView;
    private Spinner spinner;

    private String apikey = "f777477991854b12a9a2f60117e85e34";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclass06);

        textView = findViewById(R.id.textView_newsTitle);
        //listView.findViewById(R.id.listView_newsStack);
        //spinner.findViewById(R.id.spinner_selectParam);


        Headline h = new Headline();
        h.setPublishedAt("2022-05-31T18:25:03Z");

        String test = h.readbleDate();
        textView.setText(test);



    }

    private void getNews(){
        Request request = new Request.Builder()
                .url("")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    String body = response.body().string();
                    Gson gsonData = new Gson();

                    gsonData.fromJson(response.body().charStream(), Headlines.class);
                }

            }
        });
    }
}