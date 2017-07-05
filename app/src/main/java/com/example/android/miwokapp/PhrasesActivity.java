package com.example.android.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ArrayList<Word> word = new ArrayList<Word>();

        word.add(new Word("Where are you going?", "minto wuksus", R.drawable.color_red));
        word.add(new Word("What is your name?", "tinna oyaase'na", R.drawable.color_mustard_yellow));
        word.add(new Word("My name is...", "oyaaset", R.drawable.color_dusty_yellow));
        word.add(new Word("How are you feeling?", "michaksas", R.drawable.color_green));
        word.add(new Word("I'm feeling good", "kuchi achit", R.drawable.color_brown));
        word.add(new Word("Are you coming?", "aanas'aa", R.drawable.color_gray));
        word.add(new Word("Yes, I'm coming?", "haa'aanam", R.drawable.color_black));
        word.add(new Word("I'm coming?", "aanam", R.drawable.color_white));
        word.add(new Word("Let's go", "yoowutis", R.drawable.color_white));
        word.add(new Word("Come here", "anni'nem", R.drawable.color_white));


        /** Using WordAdapter aAnd ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);
    }
}
