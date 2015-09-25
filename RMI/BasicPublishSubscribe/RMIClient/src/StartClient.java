import java.rmi.Naming;

public class StartClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int portNum = 15550;
		String registryURL;
		Client client = new Client();
		
		
		try {
  		    
			
			System.setSecurityManager(new SecurityManager());
  		        
  		    registryURL = "rmi://localhost:" + portNum + "/RMIBasic";
  		    client.set_objExported((ServerInterface)Naming.lookup(registryURL));
			
  		    //client.set_objExported(_objExported);
  		    
  		    client.createAlert();

			//int result=hello.add(9,10);
			//System.out.println("Result is :"+result);
 
			}catch (Exception e) {
					e.printStackTrace();
				}

	}

}
