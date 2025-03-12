package AmazonInterview.Stack;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String current = new String(chars);
            if (!map.containsKey(current)) {
                map.put(current, new ArrayList<>());
            }
            map.get(current).add(s);
        }
        List<List<String >> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
