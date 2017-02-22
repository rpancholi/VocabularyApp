package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.textArea;
import static com.example.android.miwok.R.id.textImage;

/**
 * Created by Rupesh on 2/13/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);
        this.colorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        Word currentWord = getItem(position);

        LinearLayout textArea = (LinearLayout) listItemView.findViewById(R.id.textArea);
        int color = ContextCompat.getColor(getContext(), this.colorResourceId);

        textArea.setBackgroundColor(color);

        ImageView textImage = (ImageView) listItemView.findViewById(R.id.textImage);
        if(currentWord.getImageResourceId() != 0) {
            textImage.setImageResource(currentWord.getImageResourceId());
            textImage.setVisibility(View.VISIBLE);
        } else {
            textImage.setVisibility(View.GONE);
        }

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }
}
