package ch.hasselba.xpagesservicelocator;

import java.rmi.RemoteException;

public class ServiceLocatorFactory {

	static private ServiceLocatorFactory instance;
	static private ServiceLocator serviceLocator;

	static {
		synchronized (ServiceLocatorFactory.class) {
			if (instance == null) {
				instance = new ServiceLocatorFactory();
				try {
					serviceLocator = new ServiceLocator();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static public ServiceLocatorFactory getInstance() {
		return instance;
	}

	public static ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public static void setServiceLocator(ServiceLocator serviceLocator) {
		ServiceLocatorFactory.serviceLocator = serviceLocator;
	}

}
