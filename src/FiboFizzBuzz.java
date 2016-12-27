import java.util.Scanner;

/**
 * Created by jeremypitt on 12/27/16.
 */
public class FiboFizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int limit = getLimitCounter(scanner);
        fibBuzz(counter, limit);
    }

    private static void fibBuzz(int counter, int limit) {
        int a = 1;
        int b = 1;
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
}
