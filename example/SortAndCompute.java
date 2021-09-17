package org.example;


public class SortAndCompute {

    static  double Sort_Compute(String content1,String content2,String[] keyWordSet){
        char[] charContent1=content1.toCharArray();
        char[] charContent2=content2.toCharArray();
        int[] keyWordNum1=new int[keyWordSet.length];
        int[] keyWordNum2=new int[keyWordSet.length];
        int head,tail;
        Sort(keyWordSet,0, keyWordSet.length-1);
        for (int i=0;i<keyWordSet.length;i++){
            //获得关键词所在位置下标的链表
            IndexList list=Compute.Compute_kmp(charContent1,keyWordSet[i].toCharArray());

            Node node= list.getHead();
            keyWordNum1[i]=list.getSize();
            if(keyWordNum1[i]!=0) {
                while ((node = node.next) != null) {
                    head = node.headIndex;
                    tail = node.tailIndex;
                    for (int j = head; j < tail; j++) {
                        charContent1[j] = '*';//查找完成后，将已查找的关键词所在位置置为“*”
                    }
                }
            }
        }
        for (int i=0;i<keyWordSet.length;i++){
            IndexList list=Compute.Compute_kmp(charContent2,keyWordSet[i].toCharArray());
            Node node= list.getHead();
            keyWordNum2[i]=list.getSize();
            if(keyWordNum2[i]!=0) {
                while ((node = node.next) != null) {
                    head = node.headIndex;
                    tail = node.tailIndex;
                    for (int j = head; j < tail; j++) {
                        charContent2[j] = '*';
                    }
                }
            }
        }
       return compute_Cosine(keyWordNum1,keyWordNum2);

    }
    //使用快速排序
    // 因为使用kmp算法，关键词数组中又可能存在某个关键词是另一个关键词前缀的情况
    // ，故将关键词数组按字符长度排序，为辅助实现在原文中删除已查找关键词功能提供基础
   private static void Sort(String[] var,int i,int j){
            if(i==j||j<0||i>j) return;
            String key=var[i];
            int low=i,high=j;
            while (low<high){
                while (var[high].toCharArray().length
                        <=key.toCharArray().length
                        &&low<high){
                    high--;
                }
                if(low<high){
                    var[low]=var[high];
                }
                while (var[low].toCharArray().length
                        >=key.toCharArray().length
                        &&low<high){
                    low++;
                    }
                if(low<high){
                    var[high]=var[low];
                }
            }
            var[high]=key;
            Sort(var,i,high-1);
            Sort(var,high+1,j);
   }
   //计算余弦相似度
   private static double compute_Cosine(int[] var1,int[] var2){
         double molecule=0,denominator=0;
         for(int i=0;i< var1.length;i++){
             molecule+=var1[i]*var2[i];
         }
         double m=0;
         for(int i=0;i<var1.length;i++){
             m+=(double) var1[i]*var1[i];
         }
         denominator+=Math.sqrt(m);
       for(int i=0;i<var2.length;i++){
           m+=(double) var2[i]*var2[i];
       }
         denominator*=Math.sqrt(m);
       return molecule/denominator;
   }
}
