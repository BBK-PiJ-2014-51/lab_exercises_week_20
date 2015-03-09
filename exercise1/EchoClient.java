import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class EchoClient {
	
	public static void main(String[] args){
		EchoClient client = new EchoClient();
		client.launch();
	}
	
	private void launch() {
	// 1. If there is no security manager, start one
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			try {
				Remote service = Naming.lookup("//localhost:1099/echo");
				EchoService echoService = (EchoService) service;
				String receivedEcho = echoService.echo("Hello!");
				System.out.println("Received: " + receivedEcho);
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
