package org.example;


public class Compute {
        //以kmp算法计算所得关键词数组中各关键词的数量
       public static IndexList Compute_kmp(char[] string,char[] substring) {
           IndexList list=new IndexList();
           int[] next = GetNext(substring);
           int i = 0, j = 0;
           while (i < string.length) {
               if (j < substring.length) {
                   if (string[i] == substring[j]) {
                       i++;j++;
                       if(i==string.length&&j==substring.length){
                           list.add(i-j,i);
                           return  list;
                       }

                   } else {
                       j = next[j];
                       if(j==-1){
                           j=0;
                           while(string[i]!=substring[j]){
                               i++;
                               if(i>=string.length)
                                   return list;
                           }
                       }
                   }
               } else {
                   list.add(i-j,i);
                   j = 0;
               }
           }
           return list;
       }
       //求next数组
       private static int[] GetNext(char[] var){
           int i=0,j=-1;
           int[] next=new int[var.length];
           next[0]=-1;
           while(i<var.length-1){
                if(j==-1||var[i]==var[j]){
                    i++;j++;
                    next[i]=j;
                }else {
                    j=next[j];
                }
           }
           return  next;
       }

}
