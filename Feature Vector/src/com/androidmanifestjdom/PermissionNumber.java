package com.androidmanifestjdom;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class PermissionNumber {

	public static int GetPermissionNumber(String path) throws JDOMException, IOException{
		
			SAXBuilder saxBuilder = new SAXBuilder();

			Document doc = saxBuilder.build(path);

			Element root = doc.getRootElement();
			
			List<Element> uses_permission_List = root.getChildren("uses-permission");
			
			return uses_permission_List.size();
	}
}
