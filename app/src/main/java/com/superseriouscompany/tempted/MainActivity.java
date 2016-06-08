package com.superseriouscompany.tempted;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mLiveMosquito;
    private ImageView mDeadMosquito;
    private Handler mDurationHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLiveMosquito = (ImageView) findViewById(R.id.liveMosquitoImg);
        mDeadMosquito = (ImageView) findViewById(R.id.deadMosquitoImg);
    }

    public void squash(View view) {
        mLiveMosquito.setVisibility(View.GONE);
        mDeadMosquito.setVisibility(View.VISIBLE);
        mDurationHandler.postDelayed(resurrectMosquitoRunnable, 3000);
    }

    protected Runnable resurrectMosquitoRunnable = new Runnable() {
        @Override
        public void run() {
            mDeadMosquito.setVisibility(View.GONE);
            mLiveMosquito.setVisibility(View.VISIBLE);
        }
    };
}
