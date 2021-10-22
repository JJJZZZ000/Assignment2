package Question3;

public class Question3 {
    // Dynamic programming strategy
    public static int thisIsIterative(int n){
        if(n < 0) return -10;
        // create a array to store thisIsIterative(i)
        int[] result = new int[n+1];
        // initialize the first two Integer
        result[0] = 2;
        result[1] = 5;
        for(int i = 2; i <= n; i++){
            // the value of thisIsIterative(n) could be calculated by the previous value;
            // the previous values are stored so we can extract them without recalculation;
            result[i] = result[i-1] + result[i-2] * 3 + i * 2;
        }
        // the final one of the array is what we want
        return result[n];
    }

    public static void main(String[] args){
        // test the method.
        System.out.println("thisIsIterative("+"-15"+") is " + thisIsIterative(-5));
        System.out.println("thisIsIterative("+"3"+") is " + thisIsIterative(3));
        System.out.println("thisIsIterative("+"7"+") is " + thisIsIterative(7));
        System.out.println("thisIsIterative("+"10"+") is " + thisIsIterative(10));
        System.out.println("thisIsIterative("+"15"+") is " + thisIsIterative(15));
    }
}
