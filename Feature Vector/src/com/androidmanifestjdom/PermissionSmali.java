package com.androidmanifestjdom;

import java.io.File;
import java.io.IOException;

public class PermissionSmali {
    // 递归方式 计算文件的大小
    private long getTotalSizeOfFilesInDir(File file) {
        if (file.isFile())
            return file.length();
        File[] children = file.listFiles();
        long total = 0;
        if (children != null)
            for (File child : children)
                total += getTotalSizeOfFilesInDir(child);
        return total;
    }
    public static float getPermissionSmali(int flag,int id) throws Exception, IOException{
    	String s1 = "G:\\AndroidNormalSoftwareForExperiment\\Normal_";
    	String s2 = "G:\\AndroidMaliciousSoftwareForExperiment\\Malicious_";
    	String s3 = "\\smali";
    	String s4 ="\\AndroidManifest.xml";
    	String fileName="";
    	String path="";
    	if(flag==1)
    	{
    		fileName=s1+id+s3;
    		path=s1+id+s4;
    	}
    	else if(flag==2)
    	{
    		fileName=s2+id+s3;
    		path=s2+id+s4;
    	}
		File f=new File(fileName);
        long total = new PermissionSmali().getTotalSizeOfFilesInDir(f);
        int number=PermissionNumber.GetPermissionNumber(path);
        float result=(float)(number)*1000000/total;
        return result;
    }
}