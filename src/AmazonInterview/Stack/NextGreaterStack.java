package AmazonInterview.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterStack {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        int len = nums.length;
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]){
                ans[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> secondStack = new Stack<>();
        int[] ans = new int[nums2.length]; Arrays.fill(ans, -1);
        for (int i = 0; i < nums2.length; i++) {
            while (!secondStack.isEmpty() && nums2[secondStack.peek()] < nums2[i]){
                ans[secondStack.pop()] = nums2[i];
            }
            secondStack.push(i);
        }
        int[] solution = new int[nums1.length];
        Arrays.fill(solution,-1);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    solution[i] = ans[j];
                }
            }
        }
        return solution;
    }
}
