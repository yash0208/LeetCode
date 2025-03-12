package AmazonInterview.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            queue.add(entry);
            if(queue.size() > k) queue.poll();
        }
        int[] arr = new int[k];
        int i = 0;
        while (!queue.isEmpty()){
            arr[i] = queue.poll().getValue();
            i++;
        }
        return arr;
    }
}
