package leetcode.ReverseInteger7;

import java.util.ArrayList;
/*字符串反转，然后捕获溢出异常 */

public class Solution {
    public int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }
    
    // public int reverse(int x) {
    //     // 假设环境不允许存储 64 位整数（有符号或无符号）。
    //     // 把每一个都存起来，发现不在范围内的直接赋值0
    //     if(x == 0) return 0;
    //     if(x < 0) {
    //         int min = Integer.MIN_VALUE;
    //         ArrayList<Integer> minI = new ArrayList<>();
    //         while(min < 0) {
    //             Integer e =   (min % 10)*(-1);
    //             minI.add(e);
    //             min /= 10;
    //         }

    //         ArrayList<Integer> xI = new ArrayList<>();
    //         while(x < 0) {
    //             Integer e = (x % 10) * (-1);
    //             xI.add(e);
    //             x /= 10;
    //         }

    //         if(judge(minI, xI)) return convert(xI, -1);
    //         return 0;


    //     } else{
    //         int max = Integer.MAX_VALUE;
    //         ArrayList<Integer> maxI = new ArrayList<>();
    //         while(max > 0) {
    //             Integer e = max % 10;
    //             maxI.add(e);
    //             max /= 10;
    //         }
    //         ArrayList<Integer> xI = new ArrayList<>();
    //         while(x > 0) {
    //             Integer e = x % 10;
    //             xI.add(e);
    //             x /= 10;
    //         }
    //         if(judge(maxI, xI))
    //             return convert(xI, 1);
    //         return 0;
    //     }
    // }
    
    // boolean judge(ArrayList<Integer> maxI, ArrayList<Integer> xI) {
    //     if(xI.size() < maxI.size()) return true;
    //     // 一定相等
    //     for(int i = xI.size()-1, j = xI.size()-1-i; i >= 0; i--)  
    //         if(xI.get(j) < maxI.get(i)) return true;
    //         else if(xI.get(j) > maxI.get(i)) return false;
        
    //     return true;
    // }

    // int convert(ArrayList<Integer> xI, int flag) {
    //     int sum = 0;
    //     for(int i = 0; i < xI.size(); i++) {
    //         sum = (sum * 10 + xI.get(i)) * flag;
    //         if(flag == -1) flag = 1;
    //     }
    //     return sum;
    // }

}
