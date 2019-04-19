package com.example.demo.file.run;

import jdk.nashorn.internal.ir.RuntimeNode;

class Runner extends Thread{
    private int step = 0;
    public void run(){
        while (step< 50000){
            step++;
            try {
                Thread.sleep(1);
            }catch (InterruptedException e){}
        }
    }
    public int getStep(){
        return step;
    }
}
public class Race {
    public static void main(String[] args) {
        Runner runner[] = {new Runner(),new Runner()};
//        runner[0].setPriority(Thread.MAX_PRIORITY);
//        runner[1].setPriority(Thread.MIN_PRIORITY);

        runner[0].setPriority(2);
        runner[1].setPriority(2);

        runner[0].start();
        runner[1].start();

        while (runner[0].isAlive() && runner[1].isAlive()){
            try {
                Thread.sleep(5000);
            }catch (Exception e){}
            System.out.println("runner 0:" + runner[0].getStep());
            System.out.println("runner 1:" + runner[1].getStep());
        }
    }
}
