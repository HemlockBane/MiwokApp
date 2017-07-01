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

        word.add (new Word("One","Lutti"));
        word.add (new Word("Two", "Otiiko"));
        word.add (new Word("Three","Tolookosu"));
        word.add (new Word("Four","Oyyisa"));
        word.add (new Word("Five", "Massokka"));
        word.add (new Word("Six", "Temmokka"));
        word.add (new Word("Seven", "Kenekaku"));
        word.add (new Word("Eight", "Kawinta"));
        word.add (new Word("Nine", "Wo'e"));
        word.add (new Word("Ten", "Na'aacha"));

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
