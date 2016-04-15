package ec2016.phaselisteners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class DebugPhaseListener implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
		System.out
				.println("+++++ After Phase " + event.getPhaseId().toString());

	}

	public void beforePhase(PhaseEvent event) {
		System.out.println("+++++ Before Phase "
				+ event.getPhaseId().toString());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
