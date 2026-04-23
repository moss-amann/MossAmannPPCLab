//package week14lab;
//Week 14 Lab

class threadNum implements Runnable{
    int sum = 0;
    public int getSum(){
        return sum;
    }
    @Override
    public void run() {
        
        for(int i = 0 ; i <= 100 ; i++ ){
            sum += i;
        }
    }
}

public class OneA {
    public static void main(String[] args){
        threadNum threadObj = new threadNum();
        Thread thread1 = new Thread(threadObj);
        System.out.println("Thread starting");
        thread1.start();
        try{
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sum from 1 to 100 = " + threadObj.getSum());
    }
}


/*1(a) Write a program that implements the Runnable interface to calculate the sum of numbers from 1 to
100. The main thread should wait for this calculation to finish before printing the result. Note that the
summation should be done in a thread, created with the Runnable interface, and the main() just displays
the result*/
