package leetcode.binary_search.h_indexii_275;

public class Solution {
    public int hIndex(int[] citations) {

        // 有h篇至少引用h次
        // 就是index = i时候  length - index就是引用次数超过citations[index]的个数
        // 只有当length - index >= citations[index]的时候才是最好的；
        int length = citations.length;
        int left = 0, right = length-1;
        int h = 0;
        int mid;
        while(left <= right && left>-1 && right<length) {
           
            mid = (right - left) / 2 + left;

            if(citations[mid] > length - mid ) {
                // 说明要向左移
                h = h > length - mid ? h : length - mid;
                right = mid - 1;
            } else if(citations[mid] < length - mid) {
                // 说明右移  还是得比较
                h = h > citations[mid] ? h : citations[mid];
               // h = citations[mid];
                left = mid + 1;
            } else {
                h = citations[mid];
                break;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] citations = {0,1,3,5,6};
        System.out.println("h = "+s.hIndex(citations));
    }
}
