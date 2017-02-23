package com.example.android.miwok;

/**
 * Created by Rupesh on 2/13/2017.
 */

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId;
    private int audioID;

    public Word(String defaultTranslation, String miwokTranslation, int audioID){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioID = audioID;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioID){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.audioID = audioID;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }


    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImageResourceId(){ return imageResourceId; }

    public int getAudioID(){ return audioID; }


}
