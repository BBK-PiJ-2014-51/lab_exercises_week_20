
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Echo extends UnicastRemoteObject implements EchoService{

	public Echo() throws RemoteException {
		super();
	}

	@Override
	public String echo(String s) {
		System.out.println("Returning " + s + " to client.");
		return s;
	}
		
}