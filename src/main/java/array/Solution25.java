package array;

class Solution25 {
    /*public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }*/

    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num = 1; num < nums.length; num += 2) {
            x = x ^ nums[num - 1] ^ nums[num];
        }
        return x ^ nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2, 4, 5};
        int i = new Solution25().singleNumber(nums);
        System.out.println(i);
    }
}