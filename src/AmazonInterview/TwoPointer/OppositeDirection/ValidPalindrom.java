package AmazonInterview.TwoPointer.OppositeDirection;

public class ValidPalindrom {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else{
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
