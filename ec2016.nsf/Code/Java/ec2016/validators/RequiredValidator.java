package ec2016.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.ibm.xsp.validator.FacesRequiredValidator;

public class RequiredValidator implements FacesRequiredValidator {

	public String getRequiredMessage() {
		return "NO!";
	}

	public void validate(FacesContext paramFacesContext,
			UIComponent paramUIComponent, Object paramObject)
			throws ValidatorException {
		FacesMessage msg = new FacesMessage("NO!");
		throw new ValidatorException(msg);

	}

}
