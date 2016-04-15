package ec2016.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import ch.hasselba.xpages.JSFUtils;

public class ValidatorBean {

	private String binding;

	public void validatePassword(FacesContext fc, UIComponent uiComponent,
			Object parameters) {

		UIInput confirmComponent = (UIInput) JSFUtils.resolveVariable(binding);
		String confirm = (String) confirmComponent.getSubmittedValue();

		if (!parameters.equals(confirm)) {
			FacesMessage msg = new FacesMessage("Passwords are not equal.");
			throw new ValidatorException(msg);
		}

	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getBinding() {
		return binding;
	}
}
