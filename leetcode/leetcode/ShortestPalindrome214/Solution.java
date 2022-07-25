package leetcode.ShortestPalindrome214;


public class Solution{
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.shortestPalindrome("ba"));
    }
    public String shortestPalindrome(String s) {
        if(s.length() <= 1) return s;
        // 寻找最长的前缀回文串
        // 如何寻找呢？
        int n = s.length();
        int left=0,rigth=0;
            // 奇数中心扩散 从0到n/2 以及从[0,1]到[n/2-1,n/2]
        int l=0,r=0;
        for(int i = 1; i <= n/2; i++){
            l=i;
            r=i;
            while(l > 0 && r < n-1 && s.charAt(l-1) == s.charAt(r+1)){
                l--;
                r++;
            }
            if(l == 0 && r-l > rigth-left) {
                left = l;
                rigth = r;
            }
        }
        int index = (n - 1)/2;
        // 偶数中心扩散 从0到n/2 以及从[0,1]到[n/2,n/2+1]
        for(int i=0; i <= index; i++){
            l = i;r = i + 1;
            if(s.charAt(l) == s.charAt(r)){
                while(l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)){
                    l--;
                    r++;
                }
                if(l == 0 && r-l > rigth-left) {
                    left = l;
                    rigth = r;
                }
            }
        }
        String p = s.substring(rigth+1);
        StringBuffer p1 = new StringBuffer(p);
        p1 = p1.reverse();
        return p1+s;
    }

    
}