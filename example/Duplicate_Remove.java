package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Duplicate_Remove {
    //去除重复出现的关键词
    public static String[] remove(String[] str1,String[] str2){
        HashSet<String> hashSet=new HashSet<>();
        int i=0;
        hashSet.addAll(Arrays.asList(str1));
        hashSet.addAll(Arrays.asList(str2));
        String[] newString=new String[hashSet.size()];
       Iterator<String> it=hashSet.iterator();
       while (it.hasNext()){
           newString[i]= it.next();
           i++;
       }
       return newString;
    }
}
