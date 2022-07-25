package Greedy.MaximumSwap670;

import java.util.Stack;
// 记录各个数字最后一次出现的下标， 然后从后面往前面找，找比当前值大的下标；从9到0
public class Solution {
    // String s = String.valueOf(num);
    // int len = s.length();
    // char[] charArray = s.toCharArray();

    // // 记录每个数字出现的最后一次出现的下标
    // int[] last = new int[10];
    // for (int i = 0; i < len; i++) {
    //     last[charArray[i] - '0'] = i;
    // }

    // // 从左向右扫描，找到当前位置右边的最大的数字并交换
    // for (int i = 0; i < len - 1; i++) {
    //     // 找最大，所以倒着找
    //     for (int d = 9; d > charArray[i] - '0'; d--) {
    //         if (last[d] > i) {
    //             swap(charArray, i, last[d]);
    //             // 只允许交换一次，因此直接返回
    //             return Integer.parseInt(new String(charArray));
    //         }
    //     }
    // }
    // return num;
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        boolean flag = true;
        int maxIndex = 0, i = 0; 
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(; i < s.length(); i++) {
            if(stack.peek() < s.charAt(i)) {
                flag = false;
                break;
            }
            stack.push(s.charAt(i));
        }
        if(flag) return num;
        char max = s.charAt(i); maxIndex = i;
        for(int j = i + 1; j < s.length(); j++) {
            if(s.charAt(j) >= max) {
                max = s.charAt(j);
                maxIndex = j;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for(int j = 0; j < i; j++) {
            if(max > s.charAt(j)) {
                sb.replace(j, j + 1, s.charAt(maxIndex) + "");
                sb.replace(maxIndex, maxIndex + 1, s.charAt(j) + "");
                break;
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
