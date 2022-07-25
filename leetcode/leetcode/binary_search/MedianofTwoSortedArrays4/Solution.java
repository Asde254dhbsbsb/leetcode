package leetcode.binary_search.MedianofTwoSortedArrays4;

// 二分兼寻找第k小元素
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        

        int m = nums1.length;
        int n = nums2.length;
        int a = findMinK(nums1, nums2, 0, 0, (m + n + 1)/2);
        int b = findMinK(nums1, nums2, 0, 0, (m + n + 2)/2);
        System.out.println("a="+a+" b="+b);
        return (a+b)*1.0/2.0;
    }
    
    public int findMinK(int[] nums1, int[] nums2, int index1, int index2, int k) {
        // 越界
        if(index1 == nums1.length) return nums2[index2 + k - 1];
        if(index2 == nums2.length) return nums1[index1 + k - 1];
        if(k == 1)  return nums1[index1] > nums2[index2] ? nums2[index2] : nums1[index1];
        
        // 长度达不到 k/2怎么办？那就直接以他的长度作为
        // if(k/2 > nums1.length - index1) {
        //     if(nums1[nums1.length - 1] > nums2[index2 + k/2 - 1])  
        //         return findMinK(nums1, nums2, index1, index2 + k/2, k - k/2);
        //     else 
        //         return findMinK(nums1, nums2, nums1.length, index2, k - (nums1.length - index1));

        // } else if(k/2 > nums2.length - index2) {
        //     if(nums2[nums2.length - 1] > nums1[index1 + k/2 - 1])  
        //         return findMinK(nums1, nums2, index1 + k/2, index2, k - k/2);
        //     else 
        //         return findMinK(nums1, nums2, index1, nums2.length, k - (nums2.length - index2));
        // }
 
        // if(nums1[index1 + k/2 - 1] > nums2[index2 + k/2 - 1]) {
        //     return findMinK(nums1, nums2, index1, index2 + k/2, k-k/2);
        // } else {
        //     return findMinK(nums1, nums2, index1 + k/2, index2, k-k/2);
        // } 

        // 优化这一部分  下标直接存起来不用分类
        int i1 = index1 + Math.min(k/2, nums1.length - index1) - 1;
        int i2 = index2 + Math.min(k/2, nums2.length - index2) - 1;
        

        if(nums1[i1] > nums2[i2]) return findMinK(nums1, nums2, index1, i2 + 1, k - (i2 - index2 + 1));
        else return findMinK(nums1, nums2, i1 + 1, index2, k - (i1 - index1 + 1));

    }
}
