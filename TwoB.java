//package week14lab;

//package week14lab;

class Counter {
    private int c = 0;

    public synchronized void increment(){
        c++;
    }
    public int get(){
        return c;
    }
}


public class TwoB{
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();
        Thread [] thread = new Thread[10];
        for(int i = 0; i < 10; i++) {
            thread[i] = new Thread(() -> {
                for(int j = 0; j < 1000; j++ ){
                    sharedCounter.increment();
                }
            });
            //thread[i].start();
            
        }

        try{
            for(int i = 0; i < 10; i++){
                thread[i].start();
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + sharedCounter.get());

    }
}



/*
Create a shared Counter class with a synchronized increment method (counter++).
Start 10 threads that each increment the counter 1,000 times. Print final output of counter which must
be 10,000.
 */

public class TwoB{
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();
        Thread [] thread = new Thread[10];
        for(int i = 0; i < 10; i++) {
            thread[i] = new Thread(() -> {
                for(int j = 0; j < 1000; j++ ){
                    sharedCounter.increment();
                }
            });
            //thread[i].start();
            
        }

        try{
            for(int i = 0; i < 10; i++){
                thread[i].start();
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + sharedCounter.get());

    }
}



/*
Create a shared Counter class with a synchronized increment method (counter++).
Start 10 threads that each increment the counter 1,000 times. Print final output of counter which must
be 10,000.
 */