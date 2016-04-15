package ec2016.phaselisteners;

import java.util.Map;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

import ch.hasselba.xpages.JSFUtils;

import com.ibm.xsp.context.ExternalContextEx;
import com.ibm.xsp.context.FacesContextExImpl;

public class TokenController implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private static final String PROTECT_TARGET = "/example20_survey.xsp";
	private static final String BADTOKEN_TARGET = "/example21_generateKey.xsp";
	private static final String PARAM_ID = "id";
	private static final String PARAM_HASH = "hash";

	@SuppressWarnings("unchecked")
	public void beforePhase(PhaseEvent event) {

		FacesContextExImpl fc = (FacesContextExImpl) FacesContextExImpl
				.getCurrentInstance();
		ExternalContextEx ec = (ExternalContextEx) fc.getExternalContext();

		String uri = ((HttpServletRequest) ec.getRequest()).getRequestURI();
		System.out.println("URI " + uri);
		if (!(uri.endsWith(PROTECT_TARGET)))
			return;

		Map<String, String> parameterMap = ec.getRequestParameterMap();
		String paramId = parameterMap.get(PARAM_ID);
		String paramHash = parameterMap.get(PARAM_HASH);
		System.out.println("Hash: " + paramHash + " // " + paramId);
		if (paramId == null || paramHash == null) {
			JSFUtils.redirectToPage(BADTOKEN_TARGET);
			return;
		}

		if (!(ch.hasselba.xpages.MD5Utils.isValidHash(paramId, paramHash))) {
			JSFUtils.redirectToPage(BADTOKEN_TARGET);
			return;
		}

	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public void afterPhase(PhaseEvent arg0) {
	}
}
