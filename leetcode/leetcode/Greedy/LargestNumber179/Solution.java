package LargestNumber179;

class Solution {
    
    public String largestNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(!compare(nums[i], nums[j])) { // 说明nums[i]更大
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        String s = "";
        for (int i : nums) {
            s += String.valueOf(i);
        }

        return s.charAt(0) == '0' ? "0" : s;
    }

    boolean compare(int a, int b) {
 // 比较a + b 和比较 b + a
        String ab = String.valueOf(a) + String .valueOf(b);
        String ba = String .valueOf(b) + String.valueOf(a);
        for(int i = 0; i < ab.length(); i++) {
            int ab1 = Integer.valueOf(ab.charAt(i));
            int ba1 = Integer.valueOf(ba.charAt(i));
            if(ab1 > ba1) return true;
            if(ab1 < ba1) return false; 
        }
        return true;
    }


    // public String largestNumber(int[] nums) {
    //     // 排序
    //     sort(nums, 0, nums.length - 1);

    //     if (nums[0] == 0) return "0"; // "00000"

    //     StringBuilder sb = new StringBuilder();
    //     for (int num : nums) {
    //         sb.append(num);
    //     }
    //     return sb.toString();
    // }

    // private void sort(int[] data, int lo, int hi) {
    //     if (lo >= hi) return;
    //     // 分区
    //     int pivot = data[hi];

    //     int less = lo;
    //     int great = hi;

    //     int i = lo;
    //     while (i <= great) {
    //         String xy = data[i] + "" + pivot;
    //         String yx = pivot + "" + data[i];
    //         if (xy.compareTo(yx) > 0) {
    //             swap(data, i, less);
    //             less++;
    //             i++;
    //         } else if (xy.compareTo(yx) < 0) {
    //             swap(data, i, great);
    //             great--;
    //         } else {
    //             i++;
    //         }
    //     }

    //     sort(data, lo, less - 1);
    //     sort(data, great +1, hi);
    // }

    // public void swap(int[] nums, int i, int j) {
    //     int tmp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = tmp;
    // }

}