package com.example.cs4520_inclass.inClass5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cs4520_inclass.R;
import com.example.cs4520_inclass.inclass2.EditProfile;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class InClass05 extends AppCompatActivity implements View.OnClickListener {

    String TAG = "demo";
    EditText editText;
    Button button;
    ImageView display;
    ImageButton buttonPrevious, buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclass05);

        editText = findViewById(R.id.editText_searchKeyword);
        button = findViewById(R.id.button_searchKeyword);
        display = findViewById(R.id.imageView_displayKeyword);
        buttonPrevious = findViewById(R.id.imageButton_previous);
        buttonNext = findViewById(R.id.imageButton_next);

        button.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

        /*OkHttpClient keywordClient = new OkHttpClient();
        Request keywordRequest = new Request.Builder()
                .url("http://dev.sakibnm.space/apis/images/keywords")
                .build();*/

        /*keywordClient.newCall(keywordRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                Log.d("demo", "on Response: " +Thread.currentThread().getId());

                if( response.isSuccessful()){
                    ResponseBody responseBody = response.body();
                    String body = responseBody.string();
                }
            }
        });*/

        HttpUrl keywordUrl =  HttpUrl.parse("http://dev.sakibnm.space/apis/images/keywords");

        Request keywordRequest = new Request.Builder()
                .url(keywordUrl)
                .build();




        HttpUrl imageUrl =  HttpUrl.parse("http://dev.sakibnm.space/apis/images/retrieve").newBuilder()
                .addQueryParameter("keyword", "")
                .build();

        OkHttpClient imageClient = new OkHttpClient();

        Request imageRequest = new Request.Builder()
                .url(imageUrl)
                .build();

        imageClient.newCall(imageRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("demo", "on Response: " +Thread.currentThread().getId());

                if( response.isSuccessful()){
                    ResponseBody responseBody = response.body();
                    String body = responseBody.string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                };
            };

        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_searchKeyword) {
            String input = editText.getText().toString();
            // TODO use input to find images with keyword
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.imageButton_previous) {

            Toast.makeText(this, "Previous", Toast.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.imageButton_next) {

            Toast.makeText(this, "Next", Toast.LENGTH_LONG).show();
        }
    }
}