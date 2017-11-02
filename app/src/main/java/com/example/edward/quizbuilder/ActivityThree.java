package com.example.edward.quizbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityThree extends AppCompatActivity
{
    TextView score = findViewById(R.id.scoreView);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Bundle toThree = getIntent().getExtras();

        String fromBundle;

        if (toThree != null) //exist
        {
            fromBundle = toThree.getString("SCORE");
            this.score.setText("You got " + fromBundle.toString() + " out of 10!");
        }

    }
}
