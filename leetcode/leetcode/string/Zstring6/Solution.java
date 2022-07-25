package leetcode.string.Zstring6;

public class Solution {
    int getZ(int numsRow, int length) {
        if(numsRow == 2) {
            return length/numsRow + length%numsRow;
        }
        if(length < numsRow) return 1;
        int n = (length - numsRow)/(2*numsRow-2);
        if((length - numsRow)%(2*numsRow-2) != 0) n+=1;
        return n+1;
    }

    public String convert(String s, int numRows) {
        // 0个Z numRows n个Z numRows + 2*(numRows-1)*n
        if(numRows == 1) return s;
        int n = getZ(numRows, s.length());
        System.out.println("n="+n);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i < numRows; i++) { // i 行数

            for(int j = 1;j <= n; j++) { // Z个数
                if(i == 0 && (j*2-2)*(numRows - 1) < s.length()) { // 第一行第j个Z
                    sb.append(s.charAt((j*2-2)*(numRows - 1)));
                } else if(i == numRows - 1 && (j*2-1)*(numRows - 1) < s.length()) { //最后一行
                    sb.append(s.charAt((j*2-1)*(numRows - 1)));
                } else if(i > 0 && i < numRows - 1) { //
                    if(j == 1 && i < s.length()) {
                        sb.append(s.charAt(i)); 
                    }
                    if(j > 1) { //不是第一个Z
                        if(s.length() > (j-1)*2*(numRows-1) - i) {
                            sb.append(s.charAt((j-1)*2*(numRows-1) - i));
                        }
                        if(s.length() > (j-1)*2*(numRows-1) + i) {
                            sb.append(s.charAt((j-1)*2*(numRows-1) + i));
                        }
                    }
                }
            }
        }
        return new String(sb);
    }
}
