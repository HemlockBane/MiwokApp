package com.example.android.miwokapp;

/**
 * Created by Polymath on 24/06/2017.
 */

public class Word {
    private static final int HAS_NO_IMAGE = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = HAS_NO_IMAGE;
    private int mAudioResourceId;


    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }


    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

    }

    public String getDefaultTranslation() {

        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;

    }

    public int getImageResourceId() {

        return mImageResourceId;
    }

    public boolean hasImage() {

        return mImageResourceId != HAS_NO_IMAGE;
    }

    public int getAudioResourceId() {

        return mAudioResourceId;
    }


}
