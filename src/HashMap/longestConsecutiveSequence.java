package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestConsecutiveSequence {

        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],nums[i]+1);
            }
            int ans = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                int currentKey = entry.getValue();
                int count = 0;
                while (map.containsKey(currentKey)){
                    count++;
                    currentKey = map.get(currentKey);
                }
                ans = Math.max(count,ans);
            }
            return ans;
        }

}
