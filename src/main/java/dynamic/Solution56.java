package dynamic;

class Solution56 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = new Solution56().maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int prev = nums[0];
        int max = prev;
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            max = Math.max(prev, max);
        }
        return max;
    }
}