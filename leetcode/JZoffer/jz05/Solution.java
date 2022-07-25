package jz05;

public class Solution {
    public String replaceSpace(String s) {
// 输入：s = "We are happy."
// 输出："We%20are%20happy."
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
