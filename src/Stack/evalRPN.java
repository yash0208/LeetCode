package Stack;

import java.awt.*;
import java.awt.font.ShapeGraphicAttribute;
import java.util.Stack;

public class evalRPN {

        public int evalRPN(String[] tokens) {
            int ans = 0;
            Stack<String> stack = new Stack<>();
            for(String str: tokens){
                if(str == "+"){
                    int first = Integer.valueOf(stack.pop());
                    int second = Integer.valueOf(stack.pop());
                    ans = ans + first + second;
                }
                else if(str == "-"){
                    int first = Integer.valueOf(stack.pop());
                    int second = Integer.valueOf(stack.pop());
                    ans = ans +(second - first);
                }
                else if(str == "*"){
                    int first = Integer.valueOf(stack.pop());
                    int second = Integer.valueOf(stack.pop());
                    ans = ans + (second * first);
                }
                else if(str == "/"){
                    int first = Integer.valueOf(stack.pop());
                    int second = Integer.valueOf(stack.pop());
                    ans = ans + (second / first);
                }
                else{
                    stack.push(str);
                }
            }
            return  ans;
        }

}
