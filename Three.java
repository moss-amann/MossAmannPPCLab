//import java.util.ArrayList;
import java.util.Random;
public class Three {
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
        int[] numArray = new int[n];
        Random rand = new Random();
        for (int i = 0; i < numArray.length; i++){
            numArray[i] = rand.nextInt(100);
        }
        long startTime = System.nanoTime();
        //calculate the sum of squares of the intefers in the array using loop
        int sum = 0;
        for(int i = 0; i < numArray.length ; i++){
            sum += numArray[i] * numArray[i];
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("----Using Loop-----");
        System.out.println("Sum: " + sum);
        System.out.println("Duration: " + duration);

        //Calculate using threads
        int middle = n / 2;
        SumSquares t1 = new SumSquares(numArray, 0, middle);
        SumSquares t2 = new SumSquares(numArray, middle, n);

        //restart start time?
        startTime = System.nanoTime();
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //new sum
        sum = t1.getSum() + t2.getSum();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("----Using Threads-----");
        System.out.println("Sum: " + sum);
        System.out.println("Duration: " + duration);
        


    }
}

class SumSquares extends Thread {
    private int[] numArray;
    private int beg, end;
    private int sumSquares;
    
    public SumSquares(int [] numArray, int beg, int end) {
        this.numArray = numArray;
        this.beg = beg;
        this.end = end;
        this.sumSquares = 0;
    }

    public void run() {
        for(int i = beg; i < end; i++) {
            sumSquares += numArray[i] * numArray[i];
        }
    }

    public int getSum() {
        return sumSquares;
    }
}
/*3. Write a java program that takes an integer, n, as command line 
argument. Then it should create an array of n small integer 
(say between 1 and 100). The task is to calculate the sum of squares of the
integers in the array. You can do this calculation in a straight-forward 
way using a loop. Do it, and see how many nanoseconds it takes, for a chosen 
value of n.
 Then do the same task, by taking the first half the array and 
summing up square in one thread, and summing up the squares of the rest in another
thread, and then combining the results to get the total sum. 
Time the second way doing the task.*/