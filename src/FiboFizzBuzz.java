import java.util.Scanner;

/**
 * Created by jeremypitt on 12/27/16.
 */
public class FiboFizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fiboType = getFiboType(scanner);
        int limit = getLimitCounter(scanner);
        switch (fiboType){
            case "Standard": fibBuzz(limit);
            case "Custom": customFibBuzz(limit, scanner);
            default:
                System.out.println("Error: Invalid type");
        }
    }

    private static String getFiboType(Scanner scanner){
        System.out.println("Which type of Fibonacci would you like to run? [Standard | Custom]");
        String typeChoice = scanner.nextLine();
        return typeChoice;
    }

    private static void fibBuzz(int limit) {
        int counter = 1;
        int a = 1;
        int b = 1;
        doFiboMath(limit, counter, a, b);
    }

    private static void doFiboMath(int limit, int counter, int a, int b) {
        while (counter < limit) {

            int c = a + b;
            a = b;
            b = c;

            if (c % 3 == 0 && c % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (c % 3 == 0) {
                System.out.println("Fizz");
            } else if (c % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(c);
            }
            counter++;
        }
    }

    private static void customFibBuzz(int limit, Scanner scanner){
        int counter = 1;
        System.out.println("Enter the first number:");
        int firstNum = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the second number:");
        int secondNum = Integer.parseInt(scanner.nextLine());
        if (secondNum < firstNum) {
            int temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;
        }

        doFiboMath(limit, counter, firstNum, secondNum);
    }

    public static int getLimitCounter(Scanner scanner) {
        System.out.println("How deep down the rabbit hole do you wanna go?");
        String cycleString = scanner.nextLine();
        //TODO: validate integer input
        try {
            Integer.parseInt(cycleString);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input");
            System.exit(0);
        }
        return Integer.parseInt(cycleString);
    }

    private static void joeFibBuzz(int limit) {
        int movingVal = 1;
        int holdingVal = 1;
        for(int i = 1; i<= limit; i++){
            int newVal = movingVal + holdingVal;
            movingVal = holdingVal;
            holdingVal = newVal;
            System.out.println(newVal);
        }
    }
}
