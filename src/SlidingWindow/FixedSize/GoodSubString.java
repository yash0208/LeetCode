package SlidingWindow.FixedSize;

import java.util.HashSet;
import java.util.Set;

public class GoodSubString {
    public int countGoodSubstrings(String str) {
        char[] s = str.toCharArray();
        if(s.length<3)return 0;
        char a=s[0],b=s[1],c=s[2];
        int res=0;
        for(int i=3;i<=s.length-1;i++)
        {
            if(a!=b && b!=c && c!=a)res++;
            a=b;
            b=c;
            c=s[i];
        }
        if(a!=b && b!=c && c!=a)res++;
        return res;
    }
}
