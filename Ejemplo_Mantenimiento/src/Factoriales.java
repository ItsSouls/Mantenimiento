import java.util.Scanner;

public class Factoriales {
    public static int compute(int number){
        int result = 1;
        if (number != 0) {
            result = number * compute(number - 1);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int n = scan.nextInt();
        int result = compute(n);
        System.out.println("The factorial of " + n + " is " + result);
    }
}
