package ch.hasselba.xpagesservicelocator.library;





import ch.hasselba.xpagesservicelocator.activator.Activator;

import com.ibm.xsp.library.AbstractXspLibrary;

public class XPagesServiceLocatorLibrary extends AbstractXspLibrary{

	private final static String LIBRARY_ID = XPagesServiceLocatorLibrary.class.getName();

	static {
		if (Activator._debug) {
			System.out.println(XPagesServiceLocatorLibrary.class.getName() + " loaded");
		}
	}

	public XPagesServiceLocatorLibrary() {
		if (Activator._debug) {
			System.out.println(XPagesServiceLocatorLibrary.class.getName() + " created");
		}
	}

	public String getLibraryId() {
		return LIBRARY_ID;
	}

	@Override
	public String getPluginId() {
		return Activator.PLUGIN_ID;
	}
	
	@Override
	public String[] getDependencies() {
		return new String[] { "com.ibm.xsp.core.library",
				"com.ibm.xsp.extsn.library", "com.ibm.xsp.domino.library",
				"com.ibm.xsp.designer.library" };
	}

	@Override
	public boolean isGlobalScope() {
		return true;
	}

}
