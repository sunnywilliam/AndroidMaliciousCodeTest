package com.androidmanifestjdom;

import java.io.FileWriter;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XMLDom {
	public static void Get(String path,FileWriter fw_uses_permission,FileWriter fw_action){
		try{
			
			SAXBuilder saxBuilder = new SAXBuilder();

			Document doc = saxBuilder.build(path);

			Element root = doc.getRootElement();
			
			List<Element> uses_permission_List = root.getChildren("uses-permission");
			
			for(int i=0;i<uses_permission_List.size();i++)
			{
				Element e_uses_permission = uses_permission_List.get(i);
				
				fw_uses_permission.append(e_uses_permission.getAttributes().get(0).getValue()+"\n");
				
				System.out.println(e_uses_permission.getAttributes().get(0).getValue());
			}
			Element e_application = root.getChild("application");
			
			List<Element> receiver_List = e_application.getChildren("receiver");
				
			for(int j=0;j<receiver_List.size();j++)
			{
				Element e_receiver = receiver_List.get(j);
				
				if(e_receiver.getChildren().size()!=0)
				{
					Element e_intent_filter = e_receiver.getChild("intent-filter");
					
					List<Element> action_List = e_intent_filter.getChildren("action");
							
					for(int k=0;k<action_List.size();k++)
					{
						Element e_action = action_List.get(k);
					
						fw_action.append(e_action.getAttributes().get(0).getValue()+"\n");
						
						System.out.println(e_action.getAttributes().get(0).getValue());								
					}
				}
			}	
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
