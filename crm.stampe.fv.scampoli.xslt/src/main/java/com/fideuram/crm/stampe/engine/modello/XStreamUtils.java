package com.fideuram.crm.stampe.engine.modello;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XStreamUtils {
	public XStream readXStream() {
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		return xstream;
	}
}
