package org.example;
import java.io.*;
import java.util.Date;
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
        Date date1 =new Date(System.currentTimeMillis());
        try {
             file =new FileReader(path);
            while (((count=file.read(chars))!=-1)){
                content1.append(new String(chars,0,count));
            }
        Date date2 =new Date(System.currentTimeMillis());
            System.out.println(date2.getTime()-date1.getTime());
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
        Date date3 =new Date(System.currentTimeMillis());
        Double result=100*Start.start(content1.toString(),content2.toString());
        Date date4 =new Date(System.currentTimeMillis());
        System.out.println(date4.getTime()-date3.getTime());

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
        System.out.println("相似率："+result.toString()+"%");
        System.out.println("结果放在该文件中：");
        System.out.println(path);
    }


}






    /*public static void main(String[] args)
    {
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。" +
            "一般将程序员分为程序设计人员和程序编码人员，" +
            "但两者的界限并不非常清楚，特别是在中国。" +
            "软件从业人员分为初级程序员、高级程序员、系统" +
            "分析员和项目经理四大类。";
        char[] s = content.toCharArray();
        System.out.println(s.length);
        List<String> keywordList = HanLP.extractKeyword(content, 5);
        Object[] a=keywordList.toArray();
        System.out.println(keywordList);
        System.out.println(a[1]);

    }
*/

