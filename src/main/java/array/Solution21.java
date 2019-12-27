package array;

public class Solution21 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int j = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre = nums[i];
                continue;
            }
            if (pre == nums[i]) {
                continue;
            } else {
                pre = nums[i];
                nums[++j] = pre;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int i = new Solution21().removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}