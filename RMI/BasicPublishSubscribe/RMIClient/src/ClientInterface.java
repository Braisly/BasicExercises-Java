import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
	
	public abstract void notification(int number) throws RemoteException;
	public void createAlert() throws RemoteException;

}
