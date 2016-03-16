package com.danielsapps.flashlight;


import android.app.Activity;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;






/**
 * Created by daniel on 3/15/16.
 */
public class FlashLight extends Activity {
    CatView catView;
    Thread th;

    public boolean isOn() {
        return isOn;
    }

    boolean isOn=false;
    Camera cm=null;


    FlashLight(CatView catView){
        this.catView=catView;
    }

    public void toggleCamera() {

            if (isOn == false) {
                isOn = true;
                cm = Camera.open();
                Parameters p = cm.getParameters();
                p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                cm.setParameters(p);
                cm.startPreview();
                th = new Thread(this.catView);
                th.start();
            } else {
                isOn = false;
                th.interrupt();
                cm.stopPreview();
                cm.release();
            }
    }
}


