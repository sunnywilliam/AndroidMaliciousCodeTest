package com.extract;

import java.io.File;
import java.io.FileWriter;

import com.androidmanifestjdom.XMLDom;

public class ExtractTrainAndPredict {
	public static void main(String[] args) throws Exception
	{
		File f1 = new File("G:\\AndroidResult\\train1.txt");
		
		File f2 = new File("G:\\AndroidResult\\test2.txt");
		
		FileWriter feature_vector1 = new FileWriter(f1);
		
		FileWriter feature_vector2 = new FileWriter(f2);
		
		String s1 = "G:\\AndroidNormalSoftwareForExperiment\\Normal_";
		
		String s2 = "G:\\AndroidMaliciousSoftwareForExperiment\\Malicious_";
		
		String s3 = "\\AndroidManifest.xml";
		
		int train_number = 0;
		
		int predict_number = 0;
		
		String sa="";
		
		String sb="";
		
		for(int i= 1;i<=600;i++)
		{
			sa= s1 + i + s3;
			
			sb= s2 + i + s3;
			
			if (new File(sa).exists() == true&&new File(sb).exists()==true)
			{
				System.out.print("train group "+i+" ");
				XMLDom.Get(sa,feature_vector1,1,i);
				System.out.print("train group "+i+" ");
				XMLDom.Get(sb,feature_vector1,2,i);
				train_number+=2;
			}
		}
		for(int j=601;j<=1068;j++)
		{
			sa= s1 + j + s3;
			
			sb= s2 + j + s3;
			
			if(new File(sa).exists()==true&&new File(sb).exists()==true)
			{
				System.out.print("test group "+j+" ");
				XMLDom.Get(sa, feature_vector2,1,j);
				System.out.print("test group "+j+" ");
				XMLDom.Get(sb, feature_vector2,2,j);
				predict_number+=2;
			}		
		}
		feature_vector1.close();
		feature_vector2.close();
		System.out.println("训练集向量数目"+train_number);
		System.out.println("测试集向量数目"+predict_number);
	}
}
