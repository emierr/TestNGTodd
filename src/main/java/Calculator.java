
public class Calculator {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println(a + " + " + b + " = " + add(a, b));
        System.out.println(a + " - " + b + " = " + subtract(a, b));
    }

    public static int add(int number1, int number2) {
        int result = number1 + number2;
        return result;
    }

    public static int subtract(int number1, int number2) {
        int result = number1 - number2;
        return result;
    }
}
