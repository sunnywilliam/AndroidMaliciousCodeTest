package com.androidmanifestjdom;

import java.io.FileWriter;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XMLDom {
	static String[] feature=new String[24];
	static String[] vector=new String[24];
	public static void init()
	{
		feature[1]="android.permission.WRITE";
		feature[2]="android.permission.UPDATE_DEVICE_STATS";
		feature[3]="com.android.alarm.permission.SET_ALARM";
		feature[4]="android.permission.INSTALL_PACKAGES";
		feature[5]="com.android.browser.permission.WRITE_HISTORY_BOOKMARKS";
		feature[6]="android.permission.WRITE_SECURE_SETTINGS";
		feature[7]="com.android.browser.permission.READ_HISTORY_BOOKMARKS";
		feature[8]="android.permission.RECEIVE_SMS";
		feature[9]="android.permission.SEND_SMS";
		feature[10]="android.intent.action.BATTERY_CHANGED_ACTION";
		feature[11]="android.intent.action.DATA_SMS_RECEIVED";
		feature[12]="android.intent.action.AIRPLANE_MODE";
		feature[13]="android.provider.Telephony.SMS_RECEIVED";
		feature[14]="com.google.android.c2dm.intent.RECEIVE";
		feature[15]="android.intent.action.QUICKBOOT_POWERON";
		for(int i=1;i<=15;i++)
		{
			vector[i]=(i)+":"+0;
		}
	}
	public static void Get(String path,FileWriter feature_vector,int flag,int id) throws Exception{
		init();
		try{
			
			SAXBuilder saxBuilder = new SAXBuilder();

			Document doc = saxBuilder.build(path);

			Element root = doc.getRootElement();
			
			List<Element> uses_permission_List = root.getChildren("uses-permission");
			
			for(int i=0;i<uses_permission_List.size();i++){
				
				Element e_uses_permission = uses_permission_List.get(i);
				
				for(int i1=1;i1<=9;i1++)
				{
					if(e_uses_permission.getAttributes().get(0).getValue().equals(feature[i1]))
					{
						vector[i1]=(i1)+":"+1;
					}
				}
			}
			Element e_application = root.getChild("application");
			
			List<Element> receiver_List = e_application.getChildren("receiver");
				
			for(int j=0;j<receiver_List.size();j++){
				
				Element e_receiver = receiver_List.get(j);
				
				if(e_receiver.getChildren().size()!=0)
				{
					Element e_intent_filter = e_receiver.getChild("intent-filter");
					
					List<Element> action_List = e_intent_filter.getChildren("action");
							
					for(int k=0;k<action_List.size();k++){
						
						Element e_action = action_List.get(k);
					
						for(int i2=10;i2<=15;i2++)
						{
							if(e_action.getAttributes().get(0).getValue().equals(feature[i2]))
							{
								vector[i2]=(i2)+":"+1;
							}
						}								
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		String temp="";
		if(flag==1)
		{
			temp+=1;
		}
		else if(flag==2)
		{
			temp+=2;
		}
		for(int i3=1;i3<=15;i3++)
		{
			temp=temp+" "+vector[i3];
		}
		temp=temp+" 16:"+PermissionSmali.getPermissionSmali(flag, id);
		feature_vector.append(temp+"\n");
		System.out.println(temp);
	}
}
