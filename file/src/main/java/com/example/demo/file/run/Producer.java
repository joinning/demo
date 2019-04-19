package com.example.demo.file.run;

public class Producer extends Thread {
    private BookCase bookCase;
    private int number;

    public Producer(BookCase b,int number){
        bookCase = b;
        this.number = number;
    }

    public void run(){
        for (int i = 0;i < 10;i++){
            String book = "Book" + i;
            bookCase.put(book);
            System.out.println("Producer " + this.number + "put: " + book);
            try {
                sleep((int)Math.random() * 1000);
            }catch (InterruptedException e){}
        }
    }
}
