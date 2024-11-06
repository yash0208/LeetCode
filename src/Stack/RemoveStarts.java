package Stack;

import java.util.Stack;

public class RemoveStarts {
    public String removeStars(String s) {
        String ans="";
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
        return ans;
    }
    public String removeStarsWithArray(String s) {
        String ans="";
        char[] c=s.toCharArray();
        char[] c1=new char[s.length()];
        int index=0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='*'){
                index--;
            }
            else{
                c1[index]=c[i];
                index++;

            }
        }
        for(int i=0;i<index+1;i++){
            ans=ans+c1[i];
        }
        return ans;
    }

}
