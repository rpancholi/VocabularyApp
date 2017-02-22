package com.example.android.miwok;

/**
 * Created by Rupesh on 2/13/2017.
 */

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId;

    public Word(String defaultTranslation, String miwokTranslation){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }


    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImageResourceId(){ return imageResourceId; }


}
