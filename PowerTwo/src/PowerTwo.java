import java.util.Scanner;

public class PowerTwo {
	
	public static boolean isPowerTwo(int num){
		
		if(num%2==0)
			return true;
		else	
			return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		Scanner input = new Scanner(System.in);
		
		while(num!=1)
		{
			System.out.println("Introduce a number distinct of 1:\n");
			num=input.nextInt();
			if(num==1)
				break;
			System.out.println("Is " + num + " power of two? Answer: " + isPowerTwo(num) + "\n");
		}
			
		

	}

}
