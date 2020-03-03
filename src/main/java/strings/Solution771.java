package strings;

/**
 * 1.排序，取最后两个数字判断即可
 */
class Solution771 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        int i = new Solution771().dominantIndex(nums);
        System.out.println(i);
    }

    public int dominantIndex(int[] nums) {
        int maxindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxindex])
                maxindex = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxindex && nums[maxindex] < nums[i] * 2)
                return -1;
        }
        return maxindex;
    }
}