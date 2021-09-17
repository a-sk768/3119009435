package org.example;

import java.util.Iterator;
import java.util.List;

public class Init {
    //将List转换为String
    static String[] Convert_StringArray(List<String> var) {
        String[] s = new String[var.size()];
        int i = 0;
        Iterator<String> it = var.iterator();
        while (it.hasNext()) {
            s[i] = it.next();
            i++;
        }
        return  s;
    }
}
