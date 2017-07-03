package com.example.android.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ArrayList<Word> word = new ArrayList<Word>();

        word.add(new Word("One", "Lutti", R.drawable.number_one));
        word.add(new Word("Two", "Otiiko", R.drawable.number_two));
        word.add(new Word("Three", "Tolookosu", R.drawable.number_three));
        word.add(new Word("Four", "Oyyisa", R.drawable.number_four));
        word.add(new Word("Five", "Massokka", R.drawable.number_five));
        word.add(new Word("Six", "Temmokka", R.drawable.number_six));
        word.add(new Word("Seven", "Kenekaku", R.drawable.number_seven));
        word.add(new Word("Eight", "Kawinta", R.drawable.number_eight));
        word.add(new Word("Nine", "Wo'e", R.drawable.number_nine));
        word.add(new Word("Ten", "Na'aacha", R.drawable.number_ten));

        /** This code section explains using a Linear Layout, a TextView and a for loop*/

//        LinearLayout mLinear = (LinearLayout) findViewById(R.id.root_numbers);
//
//        for (int index = 0; index < englishWords.size(); index++)
//        {
//            TextView mTextView1 = new TextView(this);
//            mTextView1.setText(englishWords.get(index));
//            mLinear.addView(mTextView1);
//        }

        /** Using WordAdapter and ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this,word );

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);




    }
}
