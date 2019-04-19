package com.example.demo.file.run;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Alert {

    Timer timer;
    public Alert(){
        timer = new Timer();
        timer.schedule(new RemindTask(),0,1*1000);
    }
    class RemindTask extends TimerTask {
        int numWarning = 3;
        public void run(){
            if(numWarning > 0){
                System.out.println("Alert");
                numWarning--;
            }else {
                System.out.println("Time`s up");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Alert();
    }
}
