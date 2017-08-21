package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static android.os.Build.VERSION_CODES.M;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        final ArrayList<Word> word = new ArrayList<>();

        word.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        word.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        word.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        word.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        word.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        word.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        word.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        word.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        word.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        word.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));


//

        /** Using WordAdapter and ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word, R.color.category_classless);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word words = word.get(position);

                mMediaPlayer.release();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.getAudioResourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });


    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
