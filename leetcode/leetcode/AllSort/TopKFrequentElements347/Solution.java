import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Entry<Integer,Integer> entry : entrySet) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }
        int[] resl = new int[k];
        for (int i = 0; i < resl.length; i++) {
            resl[i] = pq.poll().getKey();
        }
        return resl;
    }

}