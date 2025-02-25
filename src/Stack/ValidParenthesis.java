package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            char peek = stack.peek();
            if(stack.isEmpty()) stack.push(c);
            else if (peek == '{' && c =='}') stack.pop();
            else if (peek == '[' && c ==']') stack.pop();
            else if (peek == '(' && c ==')') stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}
