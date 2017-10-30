package com.example.edward.quizbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    Button startBtn;
    EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        nameText = (EditText) findViewById(R.id.nameText);

        startBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent("ActivityTwo");
                Bundle extras = new Bundle();
                extras.putString("KEY", nameText.getText().toString());
                i.putExtras(extras);
                startActivityForResult(i,1);
            }
        });
    }
}
