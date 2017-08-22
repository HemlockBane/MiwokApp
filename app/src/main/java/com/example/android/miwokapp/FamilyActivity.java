package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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

        word.add(new Word("Father", "apa", R.drawable.family_father));
        word.add(new Word("Mother", "ata", R.drawable.family_mother));
        word.add(new Word("Son", "angsi", R.drawable.family_son));
        word.add(new Word("Daughter", "tune", R.drawable.family_daughter));
        word.add(new Word("Older Brother", "taachi", R.drawable.family_older_brother));
        word.add(new Word("Younger Brother", "chalitti", R.drawable.family_younger_brother));
        word.add(new Word("Older Sister", "tete", R.drawable.family_older_sister));
        word.add(new Word("Younger Sister", "kolitti", R.drawable.family_younger_sister));
        word.add(new Word("Grandmother", "ama", R.drawable.family_grandfather));
        word.add(new Word("Grandfather", "paapa", R.drawable.family_grandmother));


        /** Using WordAdapter aAnd ListView*/

        WordAdapter numbersAdapter = new WordAdapter(this, word, R.color.category_classless2);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word words = word.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, words.getAudioResourceId());

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
