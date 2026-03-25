import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map;

/** The goal of this practice is not to "get the answer" through AI or some other means, but for you to think through the questions and
* come up with a strategy. You can decide not to do it at your own cost.
*/

/**
* In the following, write code to achieve what's asked. You don't need to but if you want to very the accuracy of your code,
* include statements to print the result.
*/

/** Submit to the TA, and he will assign you a grade based on a few selected responses.  */

//NOTE: For all questions regarding the Fruit List, the operations performed are done on the fruit list, 
// not the set created. Therefore there are duplicates in the list



public class Week10_labs
{
    public static void main(String[] args)
	{
        List<String> fruit = Arrays.asList("cherry","banana","berry","apple","cherry","kiwi","fig","date","lemon","honeydew","cherry","elderberry","apple","banana","grape");
		System.out.println("fruit List: " + fruit);

		// Collect elements into a Set
		System.out.println(" ");
		Set<String> fruitSet = fruit.stream().collect(Collectors.toSet()); 
		System.out.println("fruitSet Set: " + fruitSet);
		System.out.println(" ");

        // Collect the fruit into groups based on their first character
		Map<Character, List<String>> fruitGroupByChar = fruit.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
		System.out.println("fruitGroupByChar Collection: " + fruitGroupByChar);
		System.out.println(" ");

		// Group fruit by the length of the name
		Map<Integer, List<String>> fruitGroupByLength = fruit.stream().collect(Collectors.groupingBy(word -> word.length()));
		System.out.println("fruitGroupByLength Collection: " + fruitGroupByLength);
		System.out.println("");

		//Collect the fruit that has erry in it
		List <String> erryFruit = fruit.stream().filter(word -> (word.contains("erry"))).collect(Collectors.toList());
		System.out.println("erryFruit: " + erryFruit);
		System.out.println("");

		//Create a partition of fruit based on if it contains erry
		Map<Boolean, List<String>> containsErry = fruit.stream().collect(Collectors.partitioningBy(word -> word.contains("erry")));
		System.out.println("partionedErryFruit: " + containsErry);
		System.out.println("");

		//collect/ the fruit that has 5 or less symbols
		List <String> fiveOrLess = fruit.stream().filter(word -> (word.length() <= 5)).collect(Collectors.toList());
		System.out.println("fruit with 5 or less symbols: " + fiveOrLess);
		System.out.println("");

		//find the total number of symbols in all the fruit stored
		//NOTE: This will return the total number of symbols in the entire list, not a list of all lengths of individual fruits
		int totalSymbols = fruit.stream().collect(Collectors.summingInt(word -> word.length()));
		System.out.println("totalSymbols: " + totalSymbols);
		System.out.println("");


		List<Integer> data = Arrays.asList(87, 23, 45, 100, 6, 78, 92, 44, 13, 56, 34, 99, 82, 19, 1012, 78, 45, 90, 23, 56, 78, 100, 3, 43, 67, 89, 21, 34, 10);

        // Partition data based on if >=50
		Map<Boolean, List<Integer>> greaterThan50 = data.stream().collect(Collectors.partitioningBy(num -> num >= 50));
		System.out.println("greaterThan50: " + greaterThan50);
		System.out.println("");

		//divide data into groups based on the remainder when divided by 7
		Map<Integer, List<Integer>> remainder7Groups = data.stream().collect(Collectors.groupingBy(num -> num%7));
		System.out.println("remainder7: " + remainder7Groups);
		System.out.println("");

		//find the sum of the data
		int sum = data.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum: " + sum);
		System.out.println("");

		//collect the unique values
		List<Integer> uniqueList = data.stream().distinct().collect(Collectors.toList());
		System.out.println("uniqueList: " + uniqueList);
		System.out.println("");

        //compute the cube of each values
		List<Integer> cubedData = data.stream().map(num -> (num*num*num)).collect(Collectors.toList());
		System.out.println("cubedList" + cubedData);
		System.out.println("");

		//find the sum of the cubes of each value
		int sumCube = data.stream().map(num -> (num*num*num)).collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum of all cubed values: " + sumCube);
		System.out.println();

		//increase the value of each element by 5
		List<Integer> plusFive = data.stream().map(num -> num + 5).collect(Collectors.toList());
		System.out.println("Value + 5: " + plusFive);
		System.out.println("");

		//compute the cube of the even values
		List<Integer> evenCubed = data.stream().filter(num -> (num % 2) == 0).map(num -> num*num*num).collect(Collectors.toList());
		System.out.println("even ints cubed: " + evenCubed);
		System.out.println();

   }
}
