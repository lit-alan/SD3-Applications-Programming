package sd3.src.com;

import java.util.Arrays;

public class TestCountOperation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       
        CountOperationForIntArr countOdd = (int i) -> { return i % 2 != 0; };
        CountOperationForIntArr countEven = (int i) -> { return i % 2 != 0; };
        CountOperationForIntArr countSeven = (int i) -> { return i == 7; };
        
        System.out.println("Number of odd numbers in " + Arrays.toString(nums) + " is " + countIt(nums, countOdd) );
        System.out.println("Number of even numbers in " + Arrays.toString(nums) + " is " +countIt(nums, countEven) );
        System.out.println("Number of 7's numbers in " + Arrays.toString(nums) + " is "  + countIt(nums, countSeven) );
        
        String[] names = {"Alan", "Aoife", "Erin", "Dave", "Jackie", "James", "Mike"};
        CountOperationForStringArr startsWithA = (String s) -> { return s.startsWith("A"); };
        CountOperationForStringArr endsWithE = (String s) -> { return s.endsWith("e"); };
        CountOperationForStringArr startsWithAAndEndsWithE = (String s) -> { return s.startsWith("A") && s.endsWith("e"); };
        
        System.out.println("Number of names starting with \'A\' "+ countIt(names, startsWithA));
        System.out.println("Number of names ending with \'e\' " + countIt(names, endsWithE));
        System.out.println("Number of names starting with \'A\' and ending with \'e\' " + countIt(names, startsWithAAndEndsWithE));
    
    }
       
    public static int countIt(int arr[], CountOperationForIntArr op) {

        int count = 0;

        for (int i : arr) {

            if (op.test(i)) {
                count++;
            }

        }

        return count;

    }
    
    public static int countIt(String arr[], CountOperationForStringArr op) {

        int count = 0;

        for (String s : arr) {

            if (op.test(s)) {
                count++;
            }

        }

        return count;

    }
}