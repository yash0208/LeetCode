package AmazonInterview.TwoPointer.OppositeDirection;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int cap = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(max,cap);
            if (height[left] < height[right]) left++;
            else right --;
        }
        return max;
    }
}
