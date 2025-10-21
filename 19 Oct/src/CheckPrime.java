import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		int n = sc.nextInt();
		
		boolean isPrime = true;
		
		if(n<=1) {
			isPrime = false;
		}else {
			for(int i =2; i<n; i++) {
				if(n%i==0) {
					isPrime = false;
				}
			}
		}
		if(isPrime) {
			System.out.println("Number is Prime");
		}else {
			System.out.println("Number is not prime");
		}
		
	}

}
