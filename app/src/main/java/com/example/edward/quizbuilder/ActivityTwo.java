package com.example.edward.quizbuilder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


import java.io.*;

import java.util.*;



public class ActivityTwo extends AppCompatActivity
{
    TextView nameText;
    String str;
    String[] strings;
    Button btnText;
    TextView questionView, titleView;
    Map<String,String> map;
    ArrayList<String> questions, answers,ansKey;
//    Arraylist<String> answers;
    RadioButton rbtnOne, rbtnTwo, rbtnThree, rbtnFour;

    Random ran;
    int intQst;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Bundle extras = getIntent().getExtras();

        String fromBundle;

        if (extras != null) //exist
        {
            titleView = findViewById(R.id.titleView);
            fromBundle = extras.getString("KEY");
            this.titleView.setText("Hello, " + fromBundle.toString() + "!");
        }

        InputStream iS = this.getResources().openRawResource(R.raw.test);
        questionView = (TextView) findViewById(R.id.questionView);

        btnText = findViewById(R.id.btnText);
        map = new HashMap<String, String>();
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        rbtnOne = findViewById(R.id.rbtnOne);
        rbtnTwo =  findViewById(R.id.rbtnTwo);
        rbtnThree = findViewById(R.id.rbtnThree);
        rbtnFour = findViewById(R.id.rbtnFour);
        BufferedReader bReader = new BufferedReader(new InputStreamReader(iS));

        if (iS != null)
        {
            try
            {
                while ((str=bReader.readLine())!= null)
                {
                    if(str.contains(":"))
                    {
                        this.strings = str.split(":");
                        questions.add(strings[0]);
                        answers.add(strings[1]);
//                        sBuffer.append(str + "\n");
                        map.put(strings[0], strings[1]);
                    }
                }
//                txtView.setText(sBuffer);
                iS.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

//        Collections.shuffle(answers); //shuffle answers
//        Random ran = new Random(); //create random
////        int intAns = (ran.nextInt(answers.size())+1);
//        int intQst = (ran.nextInt(questions.size())+1);
        ran = new Random(); //create random;

        ansKey = new ArrayList<String>(4);

        intQst = (ran.nextInt(questions.size())+1);

        questionView.setText("Question \n" + questions.get(intQst));
        ansKey.add(map.get(questions.get(intQst)));
        answers.remove(map.get(questions.get(intQst)));//remove answer for list
//        questions.remove(intQst);
        Collections.shuffle(answers);
        ansKey.add(answers.get(0));
        ansKey.add(answers.get(1));
        ansKey.add(answers.get(2));
        Collections.shuffle(ansKey);//shuffle answer key
        rbtnOne.setText(ansKey.get(0).toString());
        rbtnTwo.setText(ansKey.get(1).toString());
        rbtnThree.setText(ansKey.get(2).toString());
        rbtnFour.setText(ansKey.get(3).toString());

//        answers.remove("One"); //check to see if it will remove answer once it have been selected.
        btnText.setOnClickListener(new View.OnClickListener(){
                                       @Override
                                       public void onClick(View view)
                                       {
                                           ansKey.clear();
                                           intQst = (ran.nextInt(questions.size())+1);

                                           questionView.setText("Question \n" + questions.get(intQst));
                                           ansKey.add(map.get(questions.get(intQst)));
                                           answers.remove(map.get(questions.get(intQst+1)));//remove answer for list
//                                           questions.remove(intQst);
                                           Collections.shuffle(answers);
                                           ansKey.add(answers.get(0));
                                           ansKey.add(answers.get(1));
                                           ansKey.add(answers.get(2));
                                           Collections.shuffle(ansKey);//shuffle answer key
                                           rbtnOne.setText(ansKey.get(0).toString());
                                           rbtnTwo.setText(ansKey.get(1).toString());
                                           rbtnThree.setText(ansKey.get(2).toString());
                                           rbtnFour.setText(ansKey.get(3).toString());

                                           rbtnOne.setTextColor(Color.BLACK);
                                           rbtnTwo.setTextColor(Color.BLACK);
                                           rbtnThree.setTextColor(Color.BLACK);
                                           rbtnFour.setTextColor(Color.BLACK);

                                           rbtnOne.setChecked(false);
                                           rbtnTwo.setChecked(false);
                                           rbtnThree.setChecked(false);
                                           rbtnFour.setChecked(false);
                                       }

                                   }
        );

//        ArrayList<String> answerSet = new ArrayList<>(4);
        //checking button function
        rbtnOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), map.get(questions.get(intQst)), Toast.LENGTH_SHORT).show();
                if (rbtnOne.getText() == map.get(questions.get(intQst)))
                {
                    rbtnOne.setTextColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    rbtnTwo.setTextColor(Color.BLACK);
                    rbtnThree.setTextColor(Color.BLACK);
                    rbtnFour.setTextColor(Color.BLACK);
                }
                else
                {
                    rbtnOne.setTextColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                    rbtnTwo.setTextColor(Color.BLACK);
                    rbtnThree.setTextColor(Color.BLACK);
                    rbtnFour.setTextColor(Color.BLACK);
                }
            }
        });

        rbtnTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (rbtnTwo.getText() == map.get(questions.get(intQst)))
                {
                    rbtnTwo.setTextColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    rbtnOne.setTextColor(Color.BLACK);
                    rbtnThree.setTextColor(Color.BLACK);
                    rbtnFour.setTextColor(Color.BLACK);
                }
                else
                {
                    rbtnTwo.setTextColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                    rbtnOne.setTextColor(Color.BLACK);
                    rbtnThree.setTextColor(Color.BLACK);
                    rbtnFour.setTextColor(Color.BLACK);
                }
            }
        });

        rbtnThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (rbtnThree.getText() == map.get(questions.get(intQst)))
                {
                    rbtnThree.setTextColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    rbtnTwo.setTextColor(Color.BLACK);
                    rbtnOne.setTextColor(Color.BLACK);
                    rbtnFour.setTextColor(Color.BLACK);
                }
                else
                {
                    rbtnThree.setTextColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                    rbtnTwo.setTextColor(Color.BLACK);
                    rbtnOne.setTextColor(Color.BLACK);
                    rbtnFour.setTextColor(Color.BLACK);
                }
            }
        });

        rbtnFour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (rbtnFour.getText() == map.get(questions.get(intQst)))
                {
                    rbtnFour.setTextColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    rbtnTwo.setTextColor(Color.BLACK);
                    rbtnThree.setTextColor(Color.BLACK);
                    rbtnOne.setTextColor(Color.BLACK);
                }
                else
                {
                    rbtnFour.setTextColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                    rbtnTwo.setTextColor(Color.BLACK);
                    rbtnThree.setTextColor(Color.BLACK);
                    rbtnOne.setTextColor(Color.BLACK);
                }
            }
        });
    }
}
