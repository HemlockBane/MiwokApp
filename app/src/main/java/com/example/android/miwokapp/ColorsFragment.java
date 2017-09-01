package com.example.android.miwokapp;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mAudioChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> word = new ArrayList<>();

//        word.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
//        word.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
//        word.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
//        word.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
//        word.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
//        word.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
//        word.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
//        word.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
//        word.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
//        word.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));

        word.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        word.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        word.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        word.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        word.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        word.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        word.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        word.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));


//

        /** Using WordAdapter and ListView*/

        WordAdapter numbersAdapter = new WordAdapter(getActivity(), word, R.color.category_classless);

        ListView numberListView = (ListView) rootView.findViewById(R.id.list);

        numberListView.setAdapter(numbersAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word words = word.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mAudioChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(getActivity(), words.getAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });


        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mAudioChangeListener);
        }
    }

}
