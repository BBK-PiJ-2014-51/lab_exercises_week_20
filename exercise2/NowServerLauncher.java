
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class NowServerLauncher {
	public static void main(String[] args){
		NowServerLauncher server = new NowServerLauncher();
		server.launch();
	}
	private void launch() {
		// 1. If there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			// 2. Create the registry if there is not one
			LocateRegistry.createRegistry(1099);
			// 3. Create the server object
			Now server = new Now();
			// 4. Register (bind) the server object on the registy.
			// 	The registry may be on a different machine
			String registryHost = "//localhost/";
			String serviceName = "echo";
			Naming.rebind(registryHost + serviceName, server);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
}
