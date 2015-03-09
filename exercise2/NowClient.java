import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class NowClient {
	
	public static void main(String[] args){
		NowClient client = new NowClient();
		client.launch();
	}
	
	private void launch() {
	// 1. If there is no security manager, start one
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			try {
				Remote service = Naming.lookup("//localhost:1099/echo");
				NowService nowService = (NowService) service;
				String received = nowService.getNow();
				System.out.println("Received: " + received);
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			} catch (RemoteException ex) {
				ex.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
