package array;

import java.util.Arrays;

class Solution28 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesBest(int[] nums) {
        int index = 0;
        for(int i = 0 ;i < nums.length ; i++){
            if(nums[i]!= 0){
                if(index != i){
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new Solution28().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}