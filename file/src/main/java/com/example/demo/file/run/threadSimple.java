package com.example.demo.file.run;

class myThread1 extends Thread{
    public void run(){
        for(int i = 0;i < 5;i++){
            System.out.println("hello" + i);
        }
    }
}
public class threadSimple {
    public static void main(String[] args) {
        myThread1 thread1 = new myThread1();
        thread1.start();
        while (thread1.isAlive()){
            try {
//                Thread.sleep(10);
                thread1.join();//当前线程退出后返回
            }catch (InterruptedException e){}
        }
        System.out.println("Thread finished.");
    }
}
