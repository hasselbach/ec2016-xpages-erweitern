package ec2016.concurrent;

import java.util.concurrent.ExecutorService;

import lotus.domino.NotesException;
import lotus.domino.Session;

import com.ibm.domino.xsp.module.nsf.NSFComponentModule;
import com.ibm.domino.xsp.module.nsf.NotesContext;
import com.ibm.domino.xsp.module.nsf.SessionCloner;
import com.ibm.xsp.application.XPagesExecutor;

public class DemoExecutor {
	private final NSFComponentModule module;
	private final SessionCloner sessionCloner = SessionCloner
			.getSessionCloner();

	public DemoExecutor() {
		// get the current NSFComponentModule
		this.module = NotesContext.getCurrent().getModule();
	}

	public void doIt() {
		// aquire the Executor
		ExecutorService exService = XPagesExecutor.acquire();

		// run the Runnable
		exService.execute(new DemoRunnable(this.module));
	}

	class DemoRunnable implements Runnable {
		private final NSFComponentModule module;

		public DemoRunnable(NSFComponentModule module) {
			this.module = module;
		}

		public void run() {
			try {

				// init the NotesThread
				NotesContext context = new NotesContext(this.module);
				NotesContext.initThread(context);

				// now do the job...
				System.out.println("Starting the job...");
				Session session = null;
				try {
					// grab the session
					session = sessionCloner.getSession();
					int i=0; 
					while( i<10 ) {
						System.out.println("Running as "
								+ session.getEffectiveUserName() + " -> " + i);
						i++;
						Thread.sleep(1000);
					}
					
				} catch (NotesException e) {
					e.printStackTrace();
				} finally {
					try {
						session.recycle();
					} catch (Exception e) {
					}
				}
				System.out.println("Done!");

			} catch (InterruptedException ie) {
				// handle interruption here
			} finally {
				// kill the Notes thread
				NotesContext.termThread();
			}
		}

	}

}