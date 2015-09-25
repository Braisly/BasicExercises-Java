
import java.util.Scanner;

public class Palindrome {

	public static boolean isPalindrome(int num){
		int rest=0,reverse=0,aux=num;
		
		
		while(aux>0)
		{
		  rest=aux%10;	
		  aux=aux/10;
		  reverse=reverse*10+rest;
		}
		
		if(num==reverse)	
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		Scanner input=new Scanner(System.in);
		
		//Insert a number to check 
		System.out.println("Introduce a number:\n");
		num=input.nextInt();

		System.out.println("Is " + num + " a palindrome? Answer: " + isPalindrome(num));
	}

}
