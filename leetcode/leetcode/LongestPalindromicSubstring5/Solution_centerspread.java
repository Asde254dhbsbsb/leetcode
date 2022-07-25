package leetcode.LongestPalindromicSubstring5;

/*中心扩散法*/
//  1.以单个字符为中心 共n个
//  2.以双字符中间为中心 共n-1个
public class Solution_centerspread {

    public static void main(String[] args) {
        Solution_centerspread sl = new Solution_centerspread();
        String s = "aabacb";
        System.out.println(sl.longestPalindrome(s));
    }
    String longestPalindrome(String s) {
        int n = s.length();
        int beginIndex = 0, endIndex = 0;
        //  1.以单个字符为中心 共n个，但是0和n-1无需考虑
        for (int i = 1; i < n - 1; i++) {
            int l = i,r = i;
            while(l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)){
                l--;
                r++;
            }
            if(r - l > endIndex - beginIndex) {
                beginIndex = l;
                endIndex = r;
            }
        }
        //  2.以双字符中间为中心 共n-1个
        for(int i = 0; i < n - 1; i++){
            int l = i, r = i+1;
            if(s.charAt(l) == s.charAt(r)){
                while(l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)){
                    l--;
                    r++;
                }
                if(r - l > endIndex - beginIndex) {
                    beginIndex = l;
                    endIndex = r;
                }
            }
        }
         return s.substring(beginIndex, endIndex + 1);
    }
}
