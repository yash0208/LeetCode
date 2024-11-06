package Stack;

import java.util.Stack;

public class asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();  // The top asteroid in the stack is smaller and gets destroyed
                } else if (stack.peek() == -asteroid) {
                    stack.pop();  // Both asteroids are equal and destroy each other
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;  // The current asteroid is destroyed
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
