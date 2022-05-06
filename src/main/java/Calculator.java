import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {
        int addResult = add(5, 3);
        int subtractResult = subtract(5, 3);
        System.out.printf("5 + 3 = %s%n5 - 3 = %s", addResult, subtractResult);
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
