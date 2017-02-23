package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private Button playButton, pauseButton;
    private TextView songTitle;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;

    private double startTime = 0;
    private double finalTime = 0;
    private double seekTime = 0;

    private Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songTitle = (TextView) findViewById(R.id.songTitle);
        playButton = (Button) findViewById(R.id.playButton);
        pauseButton = (Button) findViewById(R.id.pauseButton);
        mediaPlayer = MediaPlayer.create(this, R.raw.satievalseballet);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        songTitle.setText("Erik Satie = Valse Ballet Op 62");
        seekBar.setClickable(false);

        playButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Playing Song", Toast.LENGTH_SHORT).show();

                mediaPlayer.start();
                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                seekBar.setMax((int) finalTime);

                seekBar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Song Paused", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekTime = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Seeking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo((int)seekTime);
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
