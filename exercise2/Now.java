
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Now extends UnicastRemoteObject implements NowService{

	
	public Now() throws RemoteException {
		super();
	}

	@Override
	public String getNow() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println("Returning "  + dateFormat.format(date) + " to client.");
		return dateFormat.format(date);
	}
		
}