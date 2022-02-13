import java.util.Scanner;

public class Aufgabe15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        
        System.out.println("Enter first operand: ");
        input = sc.nextLine();
        int op1 = Integer.parseInt(input);

        System.out.println("Enter second operand: ");
        input = sc.nextLine();
        int op2 = Integer.parseInt(input);

        System.out.println("> " + op1 + " * " + op2 + " = " + (op1 * op2));

        try {
            Math.multiplyExact(op1, op2);
        } catch (ArithmeticException e) {
            System.out.println("Es gab einen Overflow!");
        }

        sc.close();
    }
}
