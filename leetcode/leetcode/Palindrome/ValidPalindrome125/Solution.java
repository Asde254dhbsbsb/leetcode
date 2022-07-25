package ValidPalindrome125;
// 双指针
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        int p1 = 0, p2 = s.length() - 1;
        s = s.toLowerCase();
        while(p1 < p2) {
            while(p1 < s.length() && judgeAa1(s.charAt(p1))) p1++;
            while(p2 >= 0 && judgeAa1(s.charAt(p2))) p2--;
            if(p1 >= p2) break;
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++;
            p2--;
        }
// 统一转成大写：ch & 0b11011111 简写：ch & 0xDF
// 统一转成小写：ch | 0b00100000 简写：ch | 0x20
        return true;
    }

    boolean judgeAa1(Character cr) {
        if(cr - '0' >= 0 && cr - '0' <= 9) return false;
        if(cr - 'a' >= 0 && cr - 'a' <= 25) return false;
        if(cr - 'A' >= 0 && cr - 'A' <= 25) return false;
        return true;
    }
}
