import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;
/*
 * 数组做哈希表！！！！！
 * 
 */
class Solution {
    
// 小写字母可以用26大小的数组做哈希表
    public List<Integer> findAnagrams(String s, String p) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> {return o1 - o2;});
        Map.Entry<String, Integer> entry1 = new AbstractMap.SimpleEntry<>("key", 1);
    
        if(p.length() > s.length()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        int left = 0, right = p.length() - 1;
        while(true) {
            if(Arrays.equals(sCount, pCount)) list.add(left);
            --pCount[s.charAt(left) - 'a'];
            left++;
            right++;
            if(right < s.length()) ++pCount[s.charAt(right) - 'a'];
            else break;
        }
        return list;
    }
    // public List<Integer> findAnagrams(String s, String p) {
    //     if(p.length() > s.length()) return new ArrayList<>();
    //     Map<Character, Integer> pMap = new HashMap<>();
    //     Map<Character, Integer> tMap = new HashMap<>();
    //     Set<Character> set = new HashSet<>();
    //     int wl = p.length();
    //     List<Integer> list = new ArrayList<>();

    //     for (int i = 0; i < wl; i++) {
    //         Character c = p.charAt(i);
    //         pMap.put(c, pMap.getOrDefault(c, 0) + 1);
    //         if(!set.contains(c)) set.add(c);
    //     }

    //     for(int i = 0; i < wl; i++) {
    //         Character c = s.charAt(i);
    //         tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    //     }
    //     for(Character c : pMap.keySet()) {
    //         int v = tMap.getOrDefault(c, 0) - pMap.get(c);
    //         if ( v == 0) set.remove(c);
    //         pMap.put(c, v);
    //     }
    //     int left = 0, right = wl - 1;
    //     while(true) {
    //         if(set.size() == 0) list.add(left);
    //         Character l = s.charAt(left);
    //         left++;
    //         if(pMap.containsKey(l)) {
    //             int v = pMap.get(l);
    //             if(v == 1) set.remove(l);
    //             else 
    //                 if(!set.contains(l)) set.add(l);
    //             pMap.put(l, v - 1);
    //         }
    //         right ++;
    //         if(right < s.length()) {
    //             Character r = s.charAt(right);
    //             if(pMap.containsKey(r)) {
    //                 int v = pMap.get(r);
    //                 if(v == -1) set.remove(r);
    //                 else 
    //                     if(!set.contains(r)) set.add(r);
    //                 pMap.put(r, v + 1);
    //             }
    //         } else break;
    //     }
    //     return list;
    // }
}