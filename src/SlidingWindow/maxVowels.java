package SlidingWindow;

/**
 * Approach
 * take i and j
 * convert string to array
 * take a loop while j reaches till length
 * if char at j is vowel localsum++
 * if window size matches take ans comparison as well as remove one count if char at i is vowel
 * increment i
 * return ans
 */
public class maxVowels {
    public static int maxVowels(String s, int k) {
        int ans=0;
        int i=0,j=0;
        int length=s.length();
        char[] charArr=s.toCharArray();
        int localCount=0;
        while(j<length){
            if(charArr[j]=='a' || charArr[j]=='e' || charArr[j]=='i' || charArr[j]=='o' || charArr[j]=='u'){
                localCount++;
            }
            if(j-i+1==k){
                ans=Math.max(ans,localCount);
                if(charArr[i]=='a' || charArr[i]=='e' || charArr[i]=='i' || charArr[i]=='o' || charArr[i]=='u'){
                    localCount--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="abciiidef";
        int k=3;
        System.out.println(maxVowels(s,k));
    }
}
