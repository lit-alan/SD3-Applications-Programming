package lambdas.basic;

public class TestMathOperation {

    public static void main(String[] args) {
        new TestMathOperation();
    }

    public TestMathOperation() {
         MathOperation addition = (int a, int b) -> a + b;
         System.out.println("10 + 20 = " + operate(10, 20, addition));
         
         MathOperation subtraction = (a, b) -> b - a;
         System.out.println("\n20 - 10 = " + operate(10, 20, subtraction));
         
         MathOperation multiplication = (int a, int b) -> { return a * b; };
         System.out.println("\n10 * 20 = " + operate(10, 20, multiplication));
         
         MathOperation division  = (int a, int b) -> b / a;
         System.out.println("\n20 / 10  = " + operate(10, 20, division));
    }//end method
    
    public int operate(int a, int b, MathOperation math) {
        
        return math.operation(a, b);
    }//end method

}//end class
