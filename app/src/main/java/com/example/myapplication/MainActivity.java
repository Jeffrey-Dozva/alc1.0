package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MapsActivity";
  private Button about_alc_btn, my_profile_btn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    about_alc_btn = findViewById(R.id.about_alc_btn);
    my_profile_btn = findViewById(R.id.my_profile_btn);

    about_alc_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, AboutAlcActivity.class);
        startActivity(intent);
      }
    });
    my_profile_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
        startActivity(intent);
      }
    });
//    Toolbar toolbar = findViewById(R.id.my_toolbar);
//    setSupportActionBar(toolbar);
//    getSupportActionBar().setTitle("Credit Debit Card Payments");
//    getSupportActionBar().setHomeButtonEnabled(true);
//    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        onBackPressed();
//      }
//    });
  }
}
