package hash_map.LongestPalindrome409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        boolean flag = false;
        int length = 0;
        Map<Character, Integer> letterMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) 
            if(letterMap.containsKey(s.charAt(i))) 
                letterMap.put(s.charAt(i), letterMap.get(s.charAt(i)) + 1);
            else letterMap.put(s.charAt(i), 1);
        for(Integer i:letterMap.values()) {
            if(i % 2 == 1 && !flag) { // 存在奇数就+1
                length++;
                flag = true;
            }
            if(i % 2 == 1) length += i - 1;
            if(i % 2 == 0) length += i;
        }
        return length;
     }

    
}

