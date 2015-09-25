
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	
	private List <Request> _alerts = new ArrayList <Request> ();

	protected ServerImplementation() throws RemoteException {
	}
	

	public void createAlert(int number, ClientInterface objClient) throws RemoteException{
		
		Request objRequest = new Request(number,objClient);
		_alerts.add(objRequest);
	}
	
	
	public void deleteClient(ClientInterface objClient) throws RemoteException{
		int i=0;
		
		for(i=0;i<_alerts.size();i++)
			if(_alerts.get(i).get_client()==objClient)
				_alerts.remove(i);
	}

	public List<Request> get_alerts() {
		return _alerts;
	}

	public void set_alerts(List<Request> _alerts) {
		this._alerts = _alerts;
	}

	
	
}
