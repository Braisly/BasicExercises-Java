import java.util.Scanner;

public class CheckEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		boolean type=false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce a number:\n");
		//Keep the number to check
		num=input.nextInt();
		
		if(num%2==0)
			type=true;
		else	
			type=false;
		
		System.out.println(type);
	}

}
