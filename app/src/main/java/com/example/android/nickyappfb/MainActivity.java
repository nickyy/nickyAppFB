package com.example.android.nickyappfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    Button button;
    private static final String TAG = "MainActivity";
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setCurrentScreen(this, "June 1 - screen 1", null);
        Log.d(TAG, "*** Screenname: " + this.getClass().getSimpleName());

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "testID");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "testName");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        onButtonClick();
    }

    public void onButtonClick(){
        button = findViewById(R.id.button_page2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
            Intent myIntent = new Intent(getBaseContext(), MainActivity2.class);
            startActivity(myIntent);
            }
        });
    }

    public void onResume(){
        super.onResume();
        mFirebaseAnalytics.setCurrentScreen(this, "June 1 - screen 1", null);

    }
}