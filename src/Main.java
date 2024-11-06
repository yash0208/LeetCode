class Solution {
    public static int compress(char[] chars) {
        int count = 0;
        for(int i=1; i<chars.length; i++){
            if(chars[i]!=chars[i-1]){
                count=count+2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[] chars= {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
}