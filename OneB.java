//package week14lab;

public class OneB {
    public static void main(String [] args){
        sumThread newSumThread = new sumThread();
        newSumThread.start();
        try{
            newSumThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Sum from 1 to 100 = " + newSumThread.getSum());


    }
}

class sumThread extends Thread {
    int sum = 0;
    @Override 
    public void run() {
        for(int i = 0 ; i <=100 ; i++){
            sum += i;
        }
    }
    public int getSum(){
        return sum;
    }
}