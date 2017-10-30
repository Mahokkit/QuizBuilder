package com.example.edward.quizbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/**
 * Created by Edward on 10/30/17.
 */

public class ActivityTwo extends AppCompatActivity
{
    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        nameText = (TextView) findViewById(R.id.nameText);

        String fromBundle = "";
        Bundle extras = getIntent().getExtras();

        if (extras != null) //exist
        {
            fromBundle = extras.getString("KEY");
            nameText.setText(fromBundle);
        }
    }
}
