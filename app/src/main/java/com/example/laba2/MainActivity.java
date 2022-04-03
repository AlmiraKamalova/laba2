package com.example.laba2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laba2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a, R.drawable.d, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.j, R.drawable.k, R.drawable.s};

        String[] poroda = {"Абиссинская кошка", "Бомбейская кошка", "Каракал", "Карельский бобтеил", "Мейн кун", "Скоттиш фолд", "Яванез", "Американская короткошерстная"};
        String[] group = {"популярные, короткошерстные", "короткошерстные, для детей", "редкие, короткошерстные", "редкие, короткошерстные", "популярные, длинношерстные, для детей", "популярные, короткошерстные", "длинношерстные, гипоаллергенные", "популярные, короткошерстные"};
        String[]  color = {"o", "g", "o", "b", "o", "u", "p", "e"};
        String[] country = {"Египет", "США", "Африка", "Россия", "США", "Шотландия", "США", "США"};
        String[]  ves = {"3", "3", "3", "3", "3", "3", "3", "3"};

        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i = 0; i<imageId.length;i++){

            User user = new User( poroda[i], group[i], color[i], country[i], ves[i],imageId[i]);
            userArrayList.add(user);


        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this, userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);

                i.putExtra("poroda", poroda[position]);
                i.putExtra("ves", ves[position]);
                i.putExtra("country", country[position]);
                i.putExtra("imageid", imageId[position]);
                startActivity(i);
               // MainActivity.this.onStop();


        }


        });

         if (getSupportActionBar() !=null) {
        getSupportActionBar().hide();
    }
    }

}