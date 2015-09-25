
public class StringReverse {

	public static String reverse(String chain)
	{
		String auxChain = null;
		int i=chain.length();
		
		for(;i>=0;i--)
		{
			if(i==chain.length())
				auxChain=chain.substring(i);
			else
				auxChain=auxChain+chain.substring(i,i+1);			
		}
		
	 	return auxChain;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chain="lorry";
		
		System.out.println("The word " + chain + ", its reverse word is " + reverse(chain));

	}

}
