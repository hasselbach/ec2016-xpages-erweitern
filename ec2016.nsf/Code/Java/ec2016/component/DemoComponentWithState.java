package ec2016.component;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

public class DemoComponentWithState extends UIComponentBase {

	private static final long serialVersionUID = 1L;
	private String myValue;

	public DemoComponentWithState() {
		super();
	}

	@Override
	public String getFamily() {
		return "ec2016.component";
	}

	@Override
	public Object saveState(FacesContext fc) {
		Object[] obj = new Object[1];
		obj[0] = super.saveState(fc);
		obj[1] = myValue;
		return obj;
	}

	@Override
	public void restoreState(FacesContext fc, Object obj) {
		Object[] values = (Object[]) obj;
		super.restoreState(fc, values[0]);
		this.myValue = ((String) values[1]);
	}
}
