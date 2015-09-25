import java.util.Scanner;

public class checkPrime {

	public static boolean isPrime(int prime)
	{ //10
		int i;
		for(i=2;i<prime;i++)
		{
			if(prime%i==0)
				return false;
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		//boolean prime=false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce a number:\n");
		num=input.nextInt();
		
		
		System.out.println("Is "+ num +" a prime number? Answer:" + isPrime(num));

	}

}
