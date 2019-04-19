package com.example.demo.file.run;

class myThread2 extends Thread{
    public void run(){
        try {
            sleep(5000);
        }catch (InterruptedException e){}
    }
}
public class ThreadAccess {
    public static void main(String[] args) {
        myThread2 thread1 = new myThread2();
        myThread2 thread2 = new myThread2();
        thread1.start();
        thread2.start();

        int n = Thread.activeCount();
        System.out.println("Active threads count:" + n);

        Thread tarray[] = new Thread[Thread.activeCount()];
        Thread.enumerate(tarray);

        System.out.println("Active threads:");
        for(int i = 0;i< tarray.length;i++){
            System.out.println(tarray[i].getName());
        }
    }
}
