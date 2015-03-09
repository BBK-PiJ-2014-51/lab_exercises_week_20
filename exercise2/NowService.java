import java.rmi.Remote;
import java.rmi.RemoteException;


public interface NowService extends Remote{

	public String getNow() throws RemoteException;
}
