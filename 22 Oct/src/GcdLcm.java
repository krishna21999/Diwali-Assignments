import java.util.Scanner;

public class GcdLcm {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 2 nums");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int GCD=1;
		int LCM=b;
		
		for(int i=1;i<a;i++)//HCF
		{
			if(a%i==0 && b%i==0)
			{
				GCD = i;
			}
		}
		
		System.out.println("GCD is "+ GCD);
		
		for(int i=b;i<a*b;i++)//LCM
		{
			if(i%a==0 && i%b==0)
			{
				LCM = i;
				break;
			}
		}
		
		System.out.println("LCM is "+LCM);
	}