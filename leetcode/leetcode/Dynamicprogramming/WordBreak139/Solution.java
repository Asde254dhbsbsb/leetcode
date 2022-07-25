package WordBreak139;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String str:wordDict) {
            wordSet.add(str);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // for(int i = 1; i <= s.length(); i++) {
        //     // 最多往前推20个
        //     for(int j = 1; j <= Math.min(i, 20); j++) { // 1 到 i  1 到 20
        //         dp[i] = dp[i-j] && wordSet.contains(s.substring(i-j, i));  
        //         if(dp[i]) break;
        //     }
        // }
        // 如果不考虑这个20的话直接遍历也可以
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordSet.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }

        


// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        
        // 从0遍历
        // 在dp[0][k1] 一直到 dp[k1][k2] ... dp[kn][s.length()-1];
    public static void main(String[] args) {
        String s =  "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        Set<String> wordSet = new HashSet<>();
        for(String str:wordDict) {
            wordSet.add(str);
        }
        Solution sl = new Solution();
        System.out.println(sl.wordBreak(s, wordDict));
        
    
    }
}
