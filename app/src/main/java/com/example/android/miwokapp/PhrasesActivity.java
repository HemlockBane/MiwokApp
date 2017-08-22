package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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

        word.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        word.add(new Word("What is your name?", "tinna oyaase'na", R.raw.phrase_what_is_your_name));
        word.add(new Word("My name is", "oyaaset", R.raw.phrase_my_name_is));
        word.add(new Word("How are you feeling?", "michakas", R.raw.phrase_how_are_you_feeling));
        word.add(new Word("I'm feeling good?", "kuchi achit", R.raw.phrase_im_feeling_good));
        word.add(new Word("Are you coming?", "senes'aa", R.raw.phrase_are_you_coming));
        word.add(new Word("Yes I'm coming?", "haa'aanam", R.raw.phrase_yes_im_coming));
        word.add(new Word("I'm coming", "aanam", R.raw.phrase_im_coming));
        word.add(new Word("Let's go", "yoowutis", R.raw.phrase_lets_go));
        word.add(new Word("Come here", "anni'nem", R.raw.phrase_come_here));


        /** Using WordAdapter and ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word, R.color.category_classless2);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word words = word.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.getAudioResourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
