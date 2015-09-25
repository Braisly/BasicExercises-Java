import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientImplementation extends UnicastRemoteObject implements ClientInterface {

	protected ClientImplementation() throws RemoteException {
	}
	
	public void notification(int number) throws RemoteException {
		
		System.out.println("Well done! You guessed the number! Congratulations!");
		
		
	}
	
	
	public void createAlert() throws RemoteException{
		int number;

		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce a number:\n");
		number=input.nextInt();
		
		try {

			ClientImplementation objClient = new ClientImplementation();
			
			Client client = new Client();
			//hola.get_objExported();*/
			//Request objRequest = new Request(number,objClient);
			client.get_objExported().createAlert(number,objClient);
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Your number will be tested!");
	}
	
	
}
