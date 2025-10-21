import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int original = n, sum = 0, digits = 0;

        int temp = n;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        if (sum == original)
            System.out.println("Number is an Armstrong number");
        else
            System.out.println("Number is not an Armstrong number");
    }
}
