package com.dataprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JudgeSame {
	public static void main(String[] args) throws IOException
	{
		
		String s1 = "G:\\AndroidMaliciousSoftwareForExperiment\\Malicious_";
		
		String s2 = "G:\\AndroidNormalSoftwareForExperiment\\Normal_";
		
		String s3 = "\\AndroidManifest.xml";
		
		for(int i=1;i<=1068;i++)
		{
			for(int j=i+1;j<=1068;j++)
			{
				File f1=new File(s1+i+s3);
				File f2=new File(s1+j+s3);
				if(f1.exists()&&f2.exists())
				{
					System.out.print("Malicious "+i+" "+j);
					if(compareFileContentByChar(f1,f2))
					{
						System.out.println("Malicious"+i+"与"+"Malicious"+j+"相同");
					}
					System.out.println();
				}
				File f3=new File(s2+i+s3);
				File f4=new File(s2+j+s3);
				if(f3.exists()&&f4.exists())
				{
					System.out.print("Normal "+i+" "+j);
					if(compareFileContentByChar(f3,f4))
					{
						System.out.println("Normal"+i+"与"+"Normal"+j+"相同");
					}
					System.out.println();
				}
			}	
		}
		System.out.println("Completed!");
		
	}
	 public static boolean compareFileContentByChar(File f1 ,File f2) throws IOException{
	        FileInputStream fis1 = new FileInputStream(f1);
	        FileInputStream fis2 = new FileInputStream(f2);
	        int b = 0;
	        int c = 0;
	        while(true){
	            b = fis1.read();
	            c = fis2.read();
	            if(b!=-1 && c!=-1){
	                if(b!=c){
	                	fis1.close();
	                	fis2.close();
	                    return false;
	                }
	            }else{
	                break;
	            }
	        }
	        fis1.close();
        	fis2.close();
	        return true;
	    }
}

