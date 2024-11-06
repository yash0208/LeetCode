package PrefixSum;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int leftSum=nums[left];
        int rightSum=nums[right];
        left++;
        right--;
        while(left<right){
            if(leftSum==rightSum){
                return left+1;
            }
            leftSum+=nums[left];
            rightSum+=nums[right];
            left++;
            right--;
        }
        return -1;
    }
}
