package org.example;
import com.hankcs.hanlp.HanLP;

import java.util.List;

public class Start {

    static double start(String var,String var1){
          //求得关键词数组
        List<String> keywordList = HanLP.extractKeyword(var, 100);
        List<String> keywordList_1 = HanLP.extractKeyword(var1, 100);
        //将List转换为String
        String[] _keywordList=Init.Convert_StringArray(keywordList);
        String[] _keywordList_1=Init.Convert_StringArray(keywordList_1);
         //合并关键词数组
        String[] keyWordSet=Duplicate_Remove.remove(_keywordList,_keywordList_1);

        return  SortAndCompute.Sort_Compute(var,var1,keyWordSet);

    }
}
