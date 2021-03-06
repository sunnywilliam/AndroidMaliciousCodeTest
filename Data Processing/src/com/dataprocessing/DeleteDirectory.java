package com.dataprocessing;

import java.io.File;

public class DeleteDirectory {
	
	public static void doDeleteEmptyDir(String str)
	{
		boolean success=(new File(str)).delete();
		
		if(!success)
		{
			System.out.println("ɾ����Ŀ¼ʧ�ܣ�");
		}
	}
	public static boolean doDeleteDir(File dir)
	{
		if(dir.isDirectory())
		{
			String[] children=dir.list();
			
			for(int i=0;i<children.length;i++)
			{
				boolean success = doDeleteDir(new File(dir, children[i]));
				
				if(!success)
				{
					return false;
				}
			}
		}
		return dir.delete();
	}
}
