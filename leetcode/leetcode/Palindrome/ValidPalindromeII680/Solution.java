package ValidPalindromeII680;

public class Solution {
    public boolean validPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2) {
            if(s.charAt(p1) != s.charAt(p2)) {
                return judge(s, p1 + 1, p2) || judge(s, p1, p2 - 1);
            }
            p1++;
            p2--;
        }
        return true;
    }
    boolean judge(String s, int p1, int p2) {
        while(p1 < p2) {
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }
}
