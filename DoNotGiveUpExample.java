//package wee16lab;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

@FunctionalInterface
interface DoNotGiveUp<T> {
    T execute();
}


public class DoNotGiveUpExample {
    public static void main(String args[]){
        DoNotGiveUp<String> TryThreeTimes = () -> {
            Random random = new Random();
            for(int i = 1; i <= 3; i++){
                int num = random.nextInt(100) + 1;
                System.out.println("Attempt" + i + ": Generated " + num);
                if(num > 50){
                    return "You succeeded!";
                }
            }
            return "Failed";
        };

        DoNotGiveUp<String> TryForEver = () -> {
            for(int i = 1; i <= 1000; i++){
                double num = Math.random();
                System.out.println("Attempt " + i + ": Generated " + num);
                if(num < 0.4) {
                    return "You succeeded";
                }
            }
            return "Failed";
        };

        System.out.println("TryThreeTimes Result:");
        System.out.println(TryThreeTimes.execute());

        System.out.println();

        // Test TryForEver
        System.out.println("TryForEver Result:");
        System.out.println(TryForEver.execute());
            
    }
}

