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

        word.add(new Word("Red", "Wetetti"));
        word.add(new Word("Mustard Yellow", "Chiwiita"));
        word.add(new Word("Dusty Yellow", "Topiisa"));
        word.add(new Word("Green", "Chokokki"));
        word.add(new Word("Brown", "Takaaki"));
        word.add(new Word("Gray", "Topoppi"));
        word.add(new Word("Black", "Kululli"));
        word.add(new Word("White", "Kelelli"));


        /** Using WordAdapter aAnd ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);


    }
}
