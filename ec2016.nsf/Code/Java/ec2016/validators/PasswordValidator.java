package ec2016.validators;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ch.hasselba.xpages.JSFUtils;

public class PasswordValidator implements Validator {

	private final static String VAR_NAME_PASSWORDRETYPE = "httpPasswordRetype";
	private final static String ERR_MSG_PASSWORDS_NOMATCH = "Passwords are not equal.";
	private final static String ERR_MSG_PASSWORDS_INSECURE = "Password must have a length of six characters and contain at least a digit, a lower and an upper character.";
	private final static Pattern passwordPattern = Pattern.compile("(?=.{6,})" + // ""
			// followed
			// by
			// 6+
			// symbols
			"(?=.*[a-z])" + // --- ' ' --- at least 1 lower
			"(?=.*[A-Z])" + // --- ' ' --- at least 1 upper
			"(?=.*[0-9])" + // --- ' ' --- at least 1 digit
			".*"); // the actual characters

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String password = (String) value;
		UIInput confirmComponent = (UIInput) JSFUtils
				.resolveVariable(VAR_NAME_PASSWORDRETYPE);

		String confirm = (String) confirmComponent.getSubmittedValue();

	/*	Matcher matcher = passwordPattern.matcher(password);
		if (matcher.matches() == false) {
			throw new ValidatorException(new FacesMessage(
					ERR_MSG_PASSWORDS_INSECURE));
		}*/

		// Compare the password with the confirm password.
		if (!password.equals(confirm)) {
			confirmComponent.setValid(false);
			throw new ValidatorException(new FacesMessage(
					ERR_MSG_PASSWORDS_NOMATCH));
		}

	}

}