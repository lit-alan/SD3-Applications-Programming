package generics;

public class TestEntry {

    public static void main(String[] args) {
        Entry<String, Integer> e1 = new Entry("Dave", 40);
        Entry<String, Integer> e2 = new Entry("Mary", 66);
        
        Entry<Integer, String> e3 = new Entry(25525, "Eve");
        Entry<String, String> e4 = new Entry("Peter", "66");    
        Entry<Integer, Integer> e5 = new Entry(12, 30);

        System.out.println(e1.getKey() + ": " + e1.getValue());
        System.out.println(e2.getKey() + ": " + e2.getValue());
        System.out.println(e3.getKey() + ": " + e3.getValue());
        System.out.println(e4.getKey() + ": " + e4.getValue());
        System.out.println(e5.getKey() + ": " + e5.getValue());
       
    }

}
