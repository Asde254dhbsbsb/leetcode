package PlaceFlowers605;
// 防御式编程思想，不用考虑边界条件，连续三个0就可以种一朵花
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0, count = 1;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) count += 1;
            else count = 0;
            if(count == 3) {
                num += 1;
                count = 1;
            }
        }
        if(count == 2) num += 1;
        return num == n;
    }
}
