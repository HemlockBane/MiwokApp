package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
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

        word.add(new Word("Red", "Wetetti", R.drawable.color_red, R.raw.color_red));
        word.add(new Word("Mustard Yellow", "Chiwiita", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        word.add(new Word("Dusty Yellow", "Topiisa", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        word.add(new Word("Green", "Chokokki", R.drawable.color_green, R.raw.color_green));
        word.add(new Word("Brown", "Takaaki", R.drawable.color_brown, R.raw.color_brown));
        word.add(new Word("Gray", "Topoppi", R.drawable.color_gray, R.raw.color_gray));
        word.add(new Word("Black", "Kululli", R.drawable.color_black, R.raw.color_black));
        word.add(new Word("White", "Kelelli", R.drawable.color_white, R.raw.color_white));

        /** Using WordAdapter aAnd ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word, R.color.category_classless2);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word words = word.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, words.getAudioResourceId());

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
