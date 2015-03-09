import java.rmi.Remote;
import java.rmi.RemoteException;


public interface EchoService extends Remote{

	public String echo(String s) throws RemoteException;
}
