package com.example.demo.file.run;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        BookCase b = new BookCase();
        Producer p = new Producer(b,1);
        Consumer c = new Consumer(b,1);
        p.start();
        c.start();
    }
}
