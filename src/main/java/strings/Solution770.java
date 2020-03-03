package strings;

class Solution770 {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 0, -1, -1, 0};
        int i = new Solution770().pivotIndexExt(nums);
        System.out.println(i);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    public int pivotIndexExt(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        long sum = 0;
        for (int x : nums) {
            sum += x;
        }

        long runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * runningSum + nums[i] == sum) {
                return i;
            }

            runningSum += nums[i];
        }

        return -1;
    }
}