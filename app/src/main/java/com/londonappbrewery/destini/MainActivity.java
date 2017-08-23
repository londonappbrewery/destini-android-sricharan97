package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
     TextView storyText;
     Button upperButton;
     Button lowerButton;
    int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = (TextView)findViewById(R.id.storyTextView);
        upperButton = (Button)findViewById(R.id.buttonTop);
        lowerButton = (Button)findViewById(R.id.buttonBottom);



        // TODO: Steps 6, 7, & 9 - Set a listeners on buttons:

            upperButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(mStoryIndex==1){
                       displayT3_story();
                   }else if(mStoryIndex==2){
                       displayT6_end();
                   }else if(mStoryIndex==3){
                       displayT3_story();
                   }else{
                       displayT6_end();
                   }

                }
            });
            lowerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(mStoryIndex==1){
                       displayT2_story();
                   }else if(mStoryIndex==2){
                       displayT5_end();
                   }else if(mStoryIndex==3){
                       displayT4_end();
                   }else {
                       displayT5_end();
                   }

                }
            });







    }
    private void displayT3_story(){
        storyText.setText(R.string.T3_Story);
        upperButton.setText(R.string.T3_Ans1);
        lowerButton.setText(R.string.T3_Ans2);
        mStoryIndex++;

    }
    private void displayT2_story(){
        storyText.setText(R.string.T2_Story);
        upperButton.setText(R.string.T2_Ans1);
        lowerButton.setText(R.string.T2_Ans2);
        mStoryIndex+=2;

    }

    private void displayT4_end(){
        storyText.setText(R.string.T4_End);
        makeInvisible();
        showingalert();

    }
    private void displayT5_end(){
        storyText.setText(R.string.T5_End);
        makeInvisible();
        showingalert();
        }
    private void displayT6_end(){
        storyText.setText(R.string.T6_End);
        makeInvisible();
        showingalert();
        }
    private void makeInvisible(){
        upperButton.setVisibility(View.GONE);
        lowerButton.setVisibility(View.GONE);
    }
     private void showingalert(){
         AlertDialog.Builder alert = new AlertDialog.Builder(this);
         alert.setTitle("Game over");
         alert.setCancelable(false);


         alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 finish();
             }
         });
         alert.show();
     }


    }
