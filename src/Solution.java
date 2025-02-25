import java.util.HashMap;

class Solution {
    public String intToRoman(int num) {
        String ans = "";
        HashMap<Integer,Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');
        String number = String.valueOf(num);
        return ans;

    }
}