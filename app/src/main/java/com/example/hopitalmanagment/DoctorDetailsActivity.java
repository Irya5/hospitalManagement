  package com.example.hopitalmanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

  public class DoctorDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra(name:"title");
        tv.setText(title);

        btn.setOnCliclListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(packageContext: DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
    }
}