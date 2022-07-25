package leetcode.KMP;


public class Solution {

    public int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        int i = kmp(haystack, needle);
        System.out.println(i);
        return i;
    }

    public int kmp(String haystack, String needle){
        int[][] dfa = new int[26][needle.length()];
        // 第一个匹配的情况下
        dfa[needle.charAt(0) - 'a'][0] =  1;
        // 初始重启状态
        int X = 0;
        // 从1开始遍历因为为0时的值已经设置过了
        for(int i = 1; i < needle.length(); i++){
            for(int j = 1;j < 26; j++){
                dfa[j][i] = dfa[j][X];
            }
            // 匹配成功 状态 +1
            dfa[needle.charAt(i) - 'a'][i] = i+1;
            // 记录重启状态== >为此次匹配的值和上次重启状态的dfa值
            X = dfa[needle.charAt(i) - 'a'][X];

        }
        //进行search
        int i = 0, j = 0;
        for(i = 0; i < haystack.length() && j < needle.length(); i++){
            // 根据文本的字符来和模板进行匹配依次更新状态，文本结束或模板匹配完成结束匹配！
            j = dfa[haystack.charAt(i) - 'a'][j];
        }
        if(j == needle.length()) return i - j;
        else return -1;
    }
    
}
