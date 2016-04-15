package ch.hasselba.xpagesservicelocator;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface ServerMapRemoteInterface extends Remote {
	HashMap<String, Object> getServerMapRemote() throws RemoteException; 
	void setServerMapRemote( HashMap<String, Object> serverMap ) throws RemoteException;
}
