package LargestPerimeterTriangle076;

public class Solution {
    public int largestPerimeter(int[] nums) {
        mergeSort(nums);
        
        for(int i = nums.length - 1; i >= 2; i--) {
            int e1 = nums[i], e2 = nums[i - 1], e3 = nums[i - 2];
            if(e2 + e3 > e1) return e1 + e2 + e3;
        }
        return 0;
    }

    void mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    void mergeSort(int[] nums, int[] tmpArray, int left, int right) {
        if(left < right) {
            int center = (right - left) / 2 + left;
            mergeSort(nums, tmpArray, left, center);
            mergeSort(nums, tmpArray, center + 1, right);
            merge(nums, tmpArray, left, center + 1, right);
        } 
    }

    void merge(int[] nums, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(nums[leftPos] <= nums[rightPos]) tmpArray[tmpPos++] = nums[leftPos++];
            else tmpArray[tmpPos++] = nums[rightPos++];
        }

        while(leftPos <= leftEnd) tmpArray[tmpPos++] = nums[leftPos++];
        while(rightPos <= rightEnd) tmpArray[tmpPos++] = nums[rightPos++];
        for(int i = 0; i < numElements; i++, rightEnd--) 
            nums[rightEnd] = tmpArray[rightEnd];
    }
}
