package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer myTimer ;
    TextView quesTextView ;
    TextView resTextView;
    TextView timerTextView;
    TextView ansTextView;
    Button goBtn;
    Button button1;
    Button button2 ;
    Button button3 ;
    Button button4 ;
    int qCount = 0;
    int rCount =0;



    int realAns;
   public boolean checker=false;

    public String questionGenerator()
    {
        String ans ="";
        int fNum = (int)(Math.random()*50);
        int sNum = (int)(Math.random()*50);
        ans = fNum +"+"+sNum;

        return ans;
    }

    public void optionsGenerator(String real)
    {


        int realOp = (int)(Math.random()*4);
        String [] nums = real.split("\\+");
        realAns = 0;
        for(int i =0; i<=1;i++)
        {
            realAns+=Integer.parseInt(nums[i]);

        }
          String tag = "button"+(realOp+1);

        Button cBtn = (Button)findViewById(getResources().getIdentifier(tag,"id",getPackageName()));
        cBtn.setText(""+realAns);

        for(int i =0;i<=3;i++)
        {

           if(i!=realOp)
           {

               String tags = "button"+(i+1);
               Button icBtn = (Button)findViewById(getResources().getIdentifier(tags,"id",getPackageName()));
               icBtn.setText(""+(realAns+2*(i+1)));

           }



        }

    }
    public void check(View view)
    {

        qCount++;

        Button samp = (Button)view;
        if(Integer.parseInt(samp.getText().toString())==realAns)
        {
            rCount++;
        }

        resTextView.setText(rCount+"/"+qCount);


        String qstr = questionGenerator();
        quesTextView.setText(qstr);
        optionsGenerator(qstr);


    }




    public void loadGame(View view)
    {


        String qstr = questionGenerator();
        ansTextView.setVisibility(View.INVISIBLE);
     goBtn.setVisibility(View.INVISIBLE);
        quesTextView.setText(qstr);
     quesTextView.setVisibility(View.VISIBLE);
     timerTextView.setVisibility(View.VISIBLE);
     resTextView.setVisibility(View.VISIBLE);
     button1.setVisibility(View.VISIBLE);
     button2.setVisibility(View.VISIBLE);
     button3.setVisibility(View.VISIBLE);
     button4.setVisibility(View.VISIBLE);

      optionsGenerator(qstr);





        myTimer.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         quesTextView = (TextView)findViewById(R.id.quesTextView);
         timerTextView = (TextView)findViewById(R.id.timerTextView);
         resTextView = (TextView)findViewById(R.id.resTextView);
         resTextView.setText(rCount+"/"+qCount);
         ansTextView = (TextView)findViewById(R.id.ansTextView);
         goBtn = (Button)findViewById(R.id.goBtn);
         button1 = (Button)(findViewById(R.id.button1));
         button2 = (Button)(findViewById(R.id.button2));
         button3 = (Button)(findViewById(R.id.button3));
         button4 = (Button)(findViewById(R.id.button4));


        myTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timerTextView.setText(millisUntilFinished/1000+"s");


            }

            @Override
            public void onFinish() {
                ansTextView.setVisibility(View.VISIBLE);
                 ansTextView.setText("Game Finished,Right Answers "+rCount);
                 goBtn.setText("Try Again");
                quesTextView.setVisibility(View.INVISIBLE);
                timerTextView.setVisibility(View.INVISIBLE);
                resTextView.setVisibility(View.INVISIBLE);
                goBtn.setVisibility(View.VISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                qCount=0;
                rCount=0;
                resTextView.setText(rCount+"/"+qCount);

            }
        };





    }
}
