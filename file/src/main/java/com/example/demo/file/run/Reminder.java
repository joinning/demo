package com.example.demo.file.run;

import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;

    public Reminder(int seconds){
        timer = new Timer();
        timer.schedule(new RemindTask(),seconds*1000);
    }
    class RemindTask extends TimerTask{
        public void run(){
            System.out.println("Time`s up");
            timer.cancel();
        }
    }

    public static void main(String[] args) {
        new Reminder(5);
        System.out.println("Task Scheduled");
    }
}
