package com.svm;
import java.io.IOException;
public class Test 
{
	public static void main(String[] args) throws IOException 
	{
	    String[] arg ={ "trainfile\\train1.txt", //存放SVM训练模型用的数据的路径
	                    "trainfile\\model_r.txt"};  //存放SVM通过训练数据训练出来的模型的路径
	    String[] parg={"trainfile\\test2.txt",   //这个是存放测试数据
	                   "trainfile\\model_r.txt",  //调用的是训练以后的模型
	                   "trainfile\\out_r.txt"};  //生成的结果的文件的路径
	    System.out.println("........SVM运行开始.........."); 
	    svm_train.main(arg);   //训练对象调用静态方法
	    svm_predict.main(parg);  //分类对象调用静态方法
	}
}
