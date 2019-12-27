package array;

class Solution22 {
    public int maxProfit(int[] prices) {
        if (prices.length < 0) return 0;
        int ret = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - prices[i - 1] > 0)
                ret += prices[i] - prices[i - 1];
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 8};

        int i = new Solution22().maxProfit(nums);
        System.out.println(i);
    }
}