package com.dataprocessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.androidmanifestjdom.XMLDom;

public class ExtractPermissionAndAction {
	public static void main(String[] args) throws IOException 
	{
		File file_uses_permission1 = new File("G:\\AndroidResult\\malicious_permission.txt");
		
		FileWriter fw_uses_permission1 = new FileWriter(file_uses_permission1);
		
		File file_action1 = new File("G:\\AndroidResult\\malicious_action.txt");
		
		FileWriter fw_action1 = new FileWriter(file_action1);
		
		File file_uses_permission2 = new File("G:\\AndroidResult\\normal_permission.txt");
		
		FileWriter fw_uses_permission2 = new FileWriter(file_uses_permission2);
		
		File file_action2 = new File("G:\\AndroidResult\\normal_action.txt");
		
		FileWriter fw_action2 = new FileWriter(file_action2);
		
		String s1 = "G:\\AndroidMaliciousSoftwareForExperiment\\Malicious_";
		
		String s2 = "G:\\AndroidNormalSoftwareForExperiment\\Normal_";
		
		String s3 = "\\AndroidManifest.xml";
		
		for(int count= 1;count<=600;count++)
		{
			String ss1= s1 + count + s3;
			
			if (new File(ss1).exists() == true)
			{
				System.out.println("The malicious "+count+" apk's permissions and actions are");
				
				XMLDom.Get(s1 + count + s3,fw_uses_permission1,fw_action1);
				
			}
			
			String ss2= s2 + count + s3;
			
			if (new File(ss2).exists() == true)
			{
				System.out.println("The normal "+count+" apk's permissions and actions are");
				
				XMLDom.Get(s2 + count + s3,fw_uses_permission2,fw_action2);
				
			}
		}
		
		fw_uses_permission1.close();
		
		fw_action1.close();
		
		fw_uses_permission2.close();
		
		fw_action2.close();
		
		System.out.println("600个恶意软件的permission和action提取完毕！");
		
		System.out.println("600个正常软件的permission和action提取完毕！");
	}
}
