package dynamic;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 斐波那契数
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 */
class Solution54 {
    public static void main(String[] args) {
        int i = new Solution54().climbStairs(5);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = 1;
            } else if (i == 1) {
                nums[i] = 2;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }
        return nums[n - 1];
    }
}
