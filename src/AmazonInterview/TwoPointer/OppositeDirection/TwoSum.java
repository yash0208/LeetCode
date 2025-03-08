package AmazonInterview.TwoPointer.OppositeDirection;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int num = numbers[left] + numbers[right];
            if (num == target) return new int[]{left + 1,right + 1};
            else if (num < target) left++;
            else right--;
        }
        return new int[]{-1,-1};
    }
}
