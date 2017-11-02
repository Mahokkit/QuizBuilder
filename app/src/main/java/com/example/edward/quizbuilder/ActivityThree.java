package com.example.edward.quizbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityThree extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Button againBtn = findViewById(R.id.againBtn);
        Bundle toThree = getIntent().getExtras();

        String fromBundle;

        if (toThree != null) //exist
        {
            TextView score = findViewById(R.id.scoreView);
            fromBundle = toThree.getString("SCORE");
            score.setText("You got " + fromBundle.toString() + " out of 10!");
        }
        againBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
