package com.example.demo.file.run;


public class Consumer extends Thread {

    private BookCase bookCase;
    private int number;

    public Consumer(BookCase b,int number){
        bookCase = b;
        this.number = number;
    }

    public void run(){
        String book = "";
        for(int i = 0;i < 10;i++){
            book = bookCase.get();
            System.out.println("Consumer:" + this.number+"got: " + book);
        }
    }
}
