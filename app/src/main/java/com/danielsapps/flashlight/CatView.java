package com.danielsapps.flashlight;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by daniel on 3/16/16.
 */
public class CatView extends Activity implements Runnable{
    ImageView catImageViewer;
    int chooseCat=0;

    CatView(ImageView catImageViewer){
        this.catImageViewer= catImageViewer;



    }

    Handler handler = new Handler(){

        public void handleMessage(Message msg){
            Uri path;
            switch(chooseCat) {
                case 0: catImageViewer.setImageResource(R.mipmap.k1); chooseCat++; break;
                case 1: catImageViewer.setImageResource(R.mipmap.k2); chooseCat++; break;
                case 2: catImageViewer.setImageResource(R.mipmap.k3); chooseCat++; break;
                case 3: catImageViewer.setImageResource(R.mipmap.k4); chooseCat++; break;
                case 4: catImageViewer.setImageResource(R.mipmap.k5); chooseCat++; break;
                case 5: catImageViewer.setImageResource(R.mipmap.k6); chooseCat=0; break;
            }
        }
    };


    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(2500);
                handler.sendEmptyMessage(0);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
