package ec2016.component;

import java.io.Serializable;

import javax.faces.component.UIComponentBase;

public class DemoComponent extends UIComponentBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public DemoComponent() {
		super();
	}

	@Override
	public String getFamily() {
		return "ec2016.component";
	}

}
