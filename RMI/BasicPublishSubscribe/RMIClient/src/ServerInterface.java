import java.rmi.*;

public interface ServerInterface extends Remote {
	
	public abstract void createAlert(int number, ClientInterface objClient) throws RemoteException;
	public abstract void deleteClient(ClientInterface objClient) throws RemoteException;

}
