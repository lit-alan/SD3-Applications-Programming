package sd3.src.com;

public class TestGenericCountOperation {
    
    public static void main(String[] args) {
        String[] names = {"Alan", "Aoife", "Erin", "Dave", "Jackie", "James", "Mike"};
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        CountOperation countNamesStartingWithA = (Object o) -> { String s = (String)o; return s.startsWith("A");};

        System.out.println("Names starting with \'A\' " + countIt(names, countNamesStartingWithA));
        
        CountOperation countSevens = (Object o) -> { int i = (Integer)o; return i == 7;};
        
        System.out.println("Number of 7's in the array " + countIt(nums, countSevens)); 
    }
    
    public static <T> int countIt(T arr[], CountOperation op) {
        int count = 0;

         for (T i : arr) {
             if (op.test(i))
                 count++;
         }
         return count;
    }

}//end class
