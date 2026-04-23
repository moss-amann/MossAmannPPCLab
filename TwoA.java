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


public class TwoA{
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();
        Thread [] thread = new Thread[10];
        for(int i = 0; i < 10; i++) {
            thread[i] = new Thread(() -> {
                for(int j = 0; j < 1000; j++ ){
                    sharedCounter.increment();
                }
            });
            thread[i].start();
        }

        try{
            for(int i = 0; i < 10; i++){
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + sharedCounter.get());
/*         Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t4 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t5 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t6 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t7 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t8 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t9 = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        Thread t10 = new Thread(() -> {

            for(int i = 0; i < 1000; i++)
                sharedCounter.increment();
        });
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start(); */

        /*try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + sharedCounter.get());
        */
    }
}



/*
Create a shared Counter class with a synchronized increment method (counter++).
Start 10 threads that each increment the counter 1,000 times. Print final output of counter which must
be 10,000.
 */