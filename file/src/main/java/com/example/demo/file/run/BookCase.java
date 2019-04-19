package com.example.demo.file.run;



public class BookCase {

    private String Book;
    private boolean available = false;

    public synchronized String get(){
        while (available == false){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        available = false;
        notifyAll();
        return Book;
    }

    public synchronized void put(String newBook){
        while (available == true){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        Book = newBook;
        available = true;
        notifyAll();

    }
}
