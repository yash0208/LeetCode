package Stack;

import java.util.Stack;

class BrowserHistory {
    Stack<String> regularStack;
    Stack<String> forwardStack;

    public BrowserHistory(String homepage) {
        regularStack = new Stack<>();
        forwardStack = new Stack<>();
        regularStack.push(homepage);
    }

    public void visit(String url) {
        regularStack.push(url);
        forwardStack.clear(); // Clear forward history on a new visit
    }

    public String back(int steps) {
        int backStep = Math.min(steps, regularStack.size() - 1); // Ensure we don't remove the last homepage
        for (int i = 0; i < backStep; i++) {
            forwardStack.push(regularStack.pop());
        }
        return regularStack.peek();
    }

    public String forward(int steps) {
        int forwardSteps = Math.min(steps, forwardStack.size()); // Ensure we don't exceed available forward history
        for (int i = 0; i < forwardSteps; i++) {
            regularStack.push(forwardStack.pop());
        }
        return regularStack.peek(); // Return the top of the current stack
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
