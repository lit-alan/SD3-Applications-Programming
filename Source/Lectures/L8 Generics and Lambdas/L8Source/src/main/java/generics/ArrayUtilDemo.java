package generics;

public class ArrayUtilDemo {

    public static void main(String[] args) {
        String[] friends = {"Peter", "Paul", "Mary"};
        Integer[] ages = {45, 12, 65};
        
        
        for (String friend : friends) {
            System.out.print(friend + ", "); //prints Peter, Paul, Mary, 
        }

        
        ArrayUtil.swap(friends, 0, 2);
        System.out.println("");
        for (String friend : friends) {
            System.out.print(friend + ", "); //prints  Mary, Paul, Peter,
        }

        System.out.println("");
        for (Integer age : ages) {
            System.out.print(age + ", "); //prints  45, 12, 65.
        }

        System.out.println("");
        ArrayUtil.swap(ages, 1, 2);
        for (Integer age : ages) {
            System.out.print(age + ", "); //prints 45, 65, 12,
        }

        /////////////////////////////////////////////////////////////
        System.out.println("\n");
        String[] arr1 = ArrayUtil.swap(0,1,friends);
        for (String s : arr1) {
            System.out.print(s + ", "); //prints Paul, Mary, Peter,
        }
       
        
        Integer[] arr2 = ArrayUtil.swap(1,2,ages);
        System.out.println("");
        for (Integer i : arr2) {
            System.out.print(i + ", "); //prints  45, 12, 65, 
        }
                              
        Integer[] arr3 = ArrayUtil.swap(1,2,3,4,5,6,7,8,9);
     
        System.out.println("");
        for (Integer i : arr3) {
            System.out.print(i + ", "); //prints 3, 5, 4, 6, 7, 8, 9,
        }
    
        String[] arr4 = ArrayUtil.swap(0,1,"Tom", "Mary", "Eve", "Joe", "Ger");
        System.out.println("");
        for (String s : arr4) {
            System.out.print(s + ", "); //prints Mary, Tom, Eve, Joe, Ger,
        }
        
       
       


        
    }//end main

}//end class
