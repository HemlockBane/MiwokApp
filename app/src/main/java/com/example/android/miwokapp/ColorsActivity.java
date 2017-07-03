package com.example.android.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ArrayList<Word> word = new ArrayList<Word>();

        word.add(new Word("Red", "Wetetti", R.drawable.color_red));
        word.add(new Word("Mustard Yellow", "Chiwiita", R.drawable.color_mustard_yellow));
        word.add(new Word("Dusty Yellow", "Topiisa", R.drawable.color_dusty_yellow));
        word.add(new Word("Green", "Chokokki", R.drawable.color_green));
        word.add(new Word("Brown", "Takaaki", R.drawable.color_brown));
        word.add(new Word("Gray", "Topoppi", R.drawable.color_gray));
        word.add(new Word("Black", "Kululli", R.drawable.color_black));
        word.add(new Word("White", "Kelelli", R.drawable.color_white));


        /** Using WordAdapter aAnd ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);


    }
}
