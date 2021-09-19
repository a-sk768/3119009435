package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TEST {
    public static void main(String[] args) {
        StringBuffer content1=new StringBuffer();
        StringBuffer content2=new StringBuffer();
        int size=200;
        FileReader file=null;
        int count=0;
        char[] chars=new char[size];
        String[] path={"D:\\test\\orig_0.8_del.txt",
                       "D:\\test\\orig_0.8_del.txt",
                       "D:\\test\\orig_0.8_dis_1.txt",
                       "D:\\test\\orig_0.8_dis_10.txt",
                       "D:\\test\\orig_0.8_dis_15.txt"};
        try {
            file =new FileReader("D:\\test\\orig.txt");
            while (((count=file.read(chars))!=-1)){
                content1.append(new String(chars,0,count));
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
        int i= 0;
        for (;i< path.length;i++) {
            try {
                file = new FileReader(path[i]);
                while (((count = file.read(chars)) != -1)) {
                    content2.append(new String(chars, 0, count));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Double result=100*Start.start(content1.toString(),content2.toString());
            System.out.println("相似率："+result.toString().substring(0,5)+"%");
        }
    }
}
