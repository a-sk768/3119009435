package org.example;
import java.io.*;
import java.util.Scanner;

public class MainApp {


    public static void main(String[] args) {
        StringBuffer content1=new StringBuffer();
        StringBuffer content2=new StringBuffer();
        int size=200;
        FileReader file=null;
        int count=0;
        char[] chars=new char[size];
        //加载原文本
        System.out.println("请输入原文件路径：");
        Scanner scanner=new Scanner(System.in);
        String path= scanner.nextLine();
        try {
            file =new FileReader(path);
            while (((count=file.read(chars))!=-1)){
                content1.append(new String(chars,0,count));
                if(content1.length()==0){
                    System.out.println("请选择有内容的文件");
                    return;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(file!=null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //加载对比文本
        System.out.println("请输入对比文件路径：");
        Scanner scanner1=new Scanner(System.in);
        path=scanner1.nextLine();
        try {
            file =new FileReader(path);
            while (((count=file.read(chars))!=-1)){
                content2.append(new String(chars,0,count));
            }
            if(content2.length()==0){
                System.out.println("请选择有内容的文件");
                return;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(file!=null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Double result=100*Start.start(content1.toString(),content2.toString());

        //向指定文件输出结果
        path="D:\\test\\result.txt";
        FileWriter output=null;
        try {
            output=new FileWriter(path);
            output.write(result.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(output!=null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("相似率："+result.toString().substring(0,5)+"%");
        System.out.println("结果放在该文件中：");
        System.out.println(path);
    }


}
/*

 */



