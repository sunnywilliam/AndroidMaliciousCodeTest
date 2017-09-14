package com.dataprocessing;

import java.io.File;

public class VerifyNumber {
	
	public static void main(String[] args ){		
		String s1 = "G:\\AndroidMaliciousSoftwareForExperiment\\Malicious_";
		String s2 = "G:\\AndroidNormalSoftwareForExperiment\\Normal_";
		String s3 = "\\AndroidManifest.xml";
		int real_number1 = 1608;
		int real_number2 = 1608;
		for(int i=1;i<=1068;i++)
		{
			if(new File(s1+i+s3).exists() == false)
			{
				real_number1--;
				System.out.println("Malicious_"+i+"不存在");
			}
			if(new File(s2+i+s3).exists() == false)
			{
				real_number2--;
				System.out.println("Normal_"+i+"不存在");
			}
		}
		if(real_number1 == 1608)
		{
			System.out.println("所有的恶意软件反编译成功！");
		}
		if(real_number2 == 1608)
		{
			System.out.println("所有的正常软件反编译成功！");
		}
	}
}
