package jz11;
import java.util.Arrays;

public class Solution {
    public int minArray(int[] numbers) {
        // 二分！！！！！！！
        int left = 0;
        int right = numbers.length-1;
        
        while(left < right){
            int mid = left + (right-left)/2;
            if(numbers[mid] > numbers[right]){ // mid > right说明mid在大的有序数组那里
                left = mid+1;
            }else if(numbers[mid] < numbers[right]){ // mid < right 说明mid在小的有序数组里
                right = mid;
            }else if(numbers[mid] == numbers[right]){ // 相等就把right--去除这个相等的值
                right--;
            }
        }
        return numbers[left];
        // if(numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        // int left = 0, right = numbers.length - 1;
        // while(true) {
        //     if(right - left <= 1) return Math.min(numbers[right], numbers[left]);
        //     int mid = (right - left) / 2 + left;
        //     // int midl = (mid - 1 + numbers.length) % numbers.length;
        //     // int midr = (mid + 1 ) % numbers.length;
        //     if(numbers[mid] <= numbers[left] && numbers[mid] <= numbers[right] && numbers[left] != numbers[right]) {
        //         right = mid;
        //     } else if(numbers[mid] >= numbers[left] && numbers[mid] >= numbers[right] && numbers[left] != numbers[right]) {
        //         left = mid;
        //     } else if(numbers[left] == numbers[right] ) {
        //         return Math.min(minArray(Arrays.copyOfRange(numbers, left, mid + 1)), minArray(Arrays.copyOfRange(numbers, mid, right + 1)));
        //     }
        // }

    }
}
