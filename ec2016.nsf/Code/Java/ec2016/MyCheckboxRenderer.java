package ec2016;

import java.io.IOException;

import javax.faces.context.FacesContext;

import com.ibm.xsp.component.FacesAjaxComponent;
import com.ibm.xsp.renderkit.html_extended.HtmlBasicRenderer;

public class MyCheckboxRenderer extends HtmlBasicRenderer implements
		FacesAjaxComponent {

	public boolean handles(FacesContext fc) {
		// TODO Auto-generated method stub
		return false;
	}

	public void processAjaxRequest(FacesContext fc) throws IOException {

		String str = fc.getExternalContext().getRequestPathInfo();

		if (str.startsWith("/foo")) {
			// processAjaxGetRows(fc);
		}

	}
}
