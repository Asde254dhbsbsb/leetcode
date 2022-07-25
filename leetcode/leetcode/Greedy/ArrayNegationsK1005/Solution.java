package ArrayNegationsK1005;

public class Solution {

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {-8,3,-5,-3,-5,-2};
        int k = 6;
        System.out.println(sl.largestSumAfterKNegations(nums, k));
    }
    // boolean flag = false; //  是否有0
    public int largestSumAfterKNegations(int[] nums, int k) {
        if(nums.length == 1) {
            if(k % 2 == 0) return nums[0];
            return -nums[0];
        }

        mergeSort(nums);
        int i = 0;int end = 0;
        for(; i < nums.length && k > 0 && nums[i] < 0; i++) {
            if(nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
                end = i;
            }
        }     
        int sum = 0;
        for (int j : nums) 
            sum += j;
        
        if( k % 2 == 0) {
            return sum;
        }
        int min = nums[end];
        end++;
        if(end < nums.length && nums[end] < min) min = nums[end];
        return sum - 2*min;
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
        // if(nums[left] == 0 && !flag) flag = true;
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
