package com.example.laba2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laba2.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {

            String poroda = intent.getStringExtra("poroda");
            String ves = intent.getStringExtra("ves");
            String country = intent.getStringExtra("country");
            int imageid = intent.getIntExtra("imageid", R.drawable.a);

            binding.porodaProfile.setText(poroda);
            binding.vesProfile.setText(ves);
            binding.countryProfile.setText(country);
            binding.profileImage.setImageResource(imageid);

        }
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(UserActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

    }
}





