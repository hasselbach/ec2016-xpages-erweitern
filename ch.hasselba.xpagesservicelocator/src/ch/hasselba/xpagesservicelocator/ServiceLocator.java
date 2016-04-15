package ch.hasselba.xpagesservicelocator;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map.Entry;

public class ServiceLocator extends java.rmi.server.UnicastRemoteObject
		implements ServerMapRemoteInterface {

	private static final long serialVersionUID = 1L;
	private int thisPort;
	private String thisAddress;
	private Registry registry;

	protected ServiceLocator() throws RemoteException {

		try {
			thisAddress = (InetAddress.getLocalHost()).toString();
		}

		catch (Exception e) {
			throw new RemoteException("can't get inet address.");
		}

		thisPort = 3232;
		System.out.println("this address=" + thisAddress + ",port=" + thisPort);
		try {
			registry = LocateRegistry.createRegistry(thisPort);
			registry.rebind("rmiServer", this);
		}

		catch (RemoteException e) {
			throw e;
		}

	}

	private ServerMap servermap = new ServerMap();

	public synchronized ServerMap getServerMap() {
		return servermap;
	}

	public synchronized void setServerMap(ServerMap map) {
		servermap = map;
	}

	@Override
	public HashMap<String, Object> getServerMapRemote() throws RemoteException {
		HashMap map = new HashMap<String, Object>();
		for( Entry<String, Object> entry  : getServerMap().entrySet() ){
			System.out.println( "Get: " + entry.getKey() + " -> " + entry.getValue() );
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}

	@Override
	public void setServerMapRemote(HashMap<String, Object> serverMap) throws RemoteException {
		
		for( Entry<String, Object> entry  : serverMap.entrySet() ){
			System.out.println( "Set: " + entry.getKey() + " -> " + entry.getValue() );
			servermap.put(entry.getKey(), entry.getValue());
		}
		
		
	}
}
