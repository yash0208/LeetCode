package AmazonInterview.TwoPointer.SlidingWindow.VariableSize;

public class LongestPalindrom {
    public boolean isPalindrom(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left<=right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isPalindrom(s.substring(i,j+1))) ans = s.substring(i,j+1).length() > ans.length() ? s.substring(i,j+1) : ans;
            }
        }
        return ans;
    }


}
