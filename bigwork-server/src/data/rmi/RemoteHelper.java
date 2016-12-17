package data.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
		final String ip = "172.28.159.223";
		DateRemoteObject dataRemoteObject;
		try {
			dataRemoteObject = new DateRemoteObject();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://"+ip+":8888/DateRemoteObject",
					dataRemoteObject);
			System.out.println("server begin");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
