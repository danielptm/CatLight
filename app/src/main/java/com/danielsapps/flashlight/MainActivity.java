package com.danielsapps.flashlight;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private FlashLight fl=null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView catImageViewer = (ImageView) findViewById(R.id.catView);
        CatView catView = new CatView(catImageViewer);

        fl = new FlashLight(catView);

        ImageButton tButton = (ImageButton) findViewById(R.id.toggleLight);


        tButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
//                        ImageView catImageViewer = (ImageView) findViewById(R.id.catView);
                            fl.toggleCamera();
                        }
                    }
        );
    }

    @Override
    protected void onPause(){
        if(fl.isOn==true) {
            fl.toggleCamera();
        }
        super.onPause();
    }
}

//TODO  Add a meow sound clip, so that when someone presses the button a meow occurs.
//TODO checkout how to take payments and set up a paypal account
//TODO check out how to get advertisements on the app.
