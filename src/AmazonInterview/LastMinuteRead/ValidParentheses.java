package AmazonInterview.LastMinuteRead;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(c == ']' && !characterStack.isEmpty() && characterStack.peek() == '[') characterStack.pop();
            if(c == ')' && !characterStack.isEmpty() &&  characterStack.peek() == '(') characterStack.pop();
            if(c == '}' && !characterStack.isEmpty() && characterStack.peek() == '{') characterStack.pop();
            else characterStack.push(c);
        }
        return characterStack.size() == 0;
    }
}
