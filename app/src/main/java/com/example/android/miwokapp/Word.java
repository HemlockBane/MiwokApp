package com.example.android.miwokapp;

/**
 * Created by Polymath on 24/06/2017.
 */

public class Word {
    private String mDefaultTranslation;

    private  String mMiwokTranslation;

    private  int mImageResourceId;


    public Word (String defaultTranslation, String miwokTranslation, int imageResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    public String getDefaultTranslation () {

        return mDefaultTranslation;
    }

    public String getMiwokTranslation () {
        return mMiwokTranslation;

    }

    public int getmImageResourceId () {
        return mImageResourceId;
    }
}
