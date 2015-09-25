import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

	private static  ServerInterface _objExported;
	//private static ClientInterface _objClient;
	

	
	
	
	public void createAlert() throws RemoteException{
		int number;

		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce a number:\n");
		number=input.nextInt();
		
		try {

			ClientImplementation objClient = new ClientImplementation();
			
			_objExported.createAlert(number,objClient);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Your number will be tested!");
	}





	public static ServerInterface get_objExported() {
		return _objExported;
	}





	public static void set_objExported(ServerInterface _objExported) {
		Client._objExported = _objExported;
	}
	
} //End class Client
