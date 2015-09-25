
import java.util.List;
import java.util.Random;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Server {

	
	
	private static List<Request> _alerts = new ArrayList<Request> ();
	private static ServerImplementation _exportedObj;
	
	
	
	public static void checkNumber(int number){
		int i=0;
		
		_alerts=_exportedObj.get_alerts();
				
		synchronized(_alerts){
					for(i=0;i<_alerts.size();i++)
					{
						if(number==_alerts.get(i).get_number())
						{
							try {
								_alerts.get(i).get_client().notification(number);
								_alerts.get(i).get_client().createAlert();
								_alerts.remove(i);

							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							

							
							
							i--; //There is one element less inside the ArrayList
							
						} //end if
						
					} //end for
					
		} //end synchronized
				
				
	}

	
	
	
	
	public static void generateRandomNumber(){
		int randNumber=0;
		Random rand = new Random();
	
		randNumber = rand.nextInt(3) + 1;
		
		//Current random number
		System.out.println(randNumber);
		
		if(_alerts!=null)
			checkNumber(randNumber);
	}
	
	
	
    private static void startRegistry(int RMIPortNum)throws RemoteException {
        try {
            java.rmi.registry.Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();
            // This call will throw an exception
            // if the registry does not already exist
        } catch (RemoteException e) {
            // No valid registry at that port.
            java.rmi.registry.Registry registry = LocateRegistry.createRegistry(RMIPortNum);
        }
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int portNum = 15550;
		String registryURL;
		
		Timer timer = new Timer();
		TimerTask tRandomNumber = new TimerTask() {
				@Override
				public void run()//Thread
				{
					generateRandomNumber();
				}
		};
		
		
		try {
			//Create  RMI connection and stablish the server
			
			
			System.setSecurityManager(new SecurityManager());
			_exportedObj = new ServerImplementation();

			
			
			startRegistry(portNum);
			//Server RMI who exports the object
			//LocateRegistry.createRegistry(portNum);

			// register the object under the name “ABC”
			registryURL = "rmi://localhost:" + portNum + "/RMIBasic";
			Naming.rebind(registryURL, _exportedObj);
			System.out.println("Server ready!");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		timer.schedule(tRandomNumber, 0, 60000);
	}
}
