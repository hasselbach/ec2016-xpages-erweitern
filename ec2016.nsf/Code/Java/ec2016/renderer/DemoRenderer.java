package ec2016.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class DemoRenderer extends Renderer {

	public DemoRenderer() {
		super();

	}

	@Override
	public void encodeEnd(FacesContext fc, UIComponent uiComponent)
			throws IOException {

		ResponseWriter rw = fc.getResponseWriter();
		rw.startElement("div", uiComponent);
		rw.writeAttribute("style",
				"background-color:red; width:100%; height:100%", "style");

		super.encodeEnd(fc, uiComponent);

		rw.endElement("div");
	}
}
