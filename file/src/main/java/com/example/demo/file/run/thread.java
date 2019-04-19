package com.example.demo.file.run;


class myThread extends Thread{

    myThread(String str){
        super(str);
    }
    public void run(){
        for(int i =0;i < 10;i++){
            System.out.println(getName() + ": Hello" + i);
            try {
                sleep((int) Math.random() * 1000);
            }catch (InterruptedException e){}
        }
    }
}
public class thread{
    public static void main(String[] args) {
        myThread thread1 = new myThread("thread1");
        myThread thread2 = new myThread("thread2");
        thread1.start();
        thread2.start();
    }

}
