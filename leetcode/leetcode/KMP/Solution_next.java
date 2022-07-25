package leetcode.KMP;

import java.util.Arrays;

public class Solution_next{

    //   vector<int> commpute_next(string pattern){
    //             vector<int>next(pattern.size() + 1, 0);
    //             next[0] = -1;
    //             next[1] = 0; // 长度为1的字符串没有前后缀
    //             int i = 2; // i表示next数组的索引
    //             int k = 0; // 指针指向pattern的位置
    //             while (i < next.size()) {
    //              // 如果当前字符匹配成功
    //                 if (pattern[i - 1] == pattern[k]) {// pattern索引比next索引小1
    //                     next[i] = k + 1;
    //                     k = next[i];
    //                     ++i;
    //             // 如果指针已经指向pattern[0]却还没有匹配成功
    //                 } else if (k == 0){
    //                     next[i] = 0;
    //                     ++i;
    //                 } else{
    //                     k = next[k]; //可以利用已匹配成功的信息，让指针不进行回退，查找next数组
    //                 }
    //             }
    //             return next;
    //         }
        // kmp第一种写法
        public int[] commpute_next(String pattern){
            int[] next = new int[pattern.length() + 1];
            next[0] = -1;
            next[1] = 0; // 长度为1的字符串没有前后缀
            int i = 2;
            int k = 0;
            while(i  < next.length){
                // 如果当前字符串匹配成功；
                if(pattern.charAt(i - 1) == pattern.charAt(k)){ // pattern索引比next索引小1
                    next[i] = k + 1;
                    k = next[i];
                    ++i;
                    // 如果指针已经指向pattern[0]却还没有匹配成功
                } else if(k == 0){
                    next[i] = 0;
                    ++i;
                } else {
                    k = next[k]; // 可以利用已匹配成功的信息，让指针不进行回退，查找next数组；
                }
            }
            return next;
        }
        // kmp第二种写法
        public int[] commpute_next1(String s){
            int n = s.length();
            int[] fail = new int[n];
            Arrays.fill(fail, -1);
            for (int i = 1; i < n; ++i) {
                int j = fail[i - 1];
                while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                    j = fail[j];
                }
                if (s.charAt(j + 1) == s.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            return fail;
        }


    

        public static void main(String[] args) {
            Solution_next sln = new Solution_next();
            System.out.println(Arrays.toString(sln.commpute_next("abcabctern")));
            System.out.println(Arrays.toString(sln.commpute_next1("abcabctern")));
        }
    
}