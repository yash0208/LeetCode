package Stack;

import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> strings = new Stack<>();
        String[] strs = path.split("/");
        for (String str : strs){
            if(str !=""){
                if(str == ".") continue;
                else if (str == ".."){
                    if (strings.peek()!=null) strings.pop();
                }
                else {
                    strings.push(str);
                }
            }
        }
        String ans = "";
        while (strings.peek()!=null) ans = "/" + ans + strings.pop();
        return ans;
    }
}
