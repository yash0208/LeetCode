package AmazonInterview.Stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack;
    int min;
    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val < min) minStack.push(min); min = val;
    }

    public void pop() {
        if(minStack.peek() == min) min = minStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
