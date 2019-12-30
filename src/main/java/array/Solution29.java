package array;

import java.util.*;

class Solution29 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = null;
        Map.Entry<Integer, Integer> next = null;
        for (int i = 0; i < len; i++) {
            iterator = entries.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((next.getKey() + nums[i]) == target) {
                    return new int[]{next.getValue(), i};
                }
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] twoSumEasy(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (hashMap.containsKey(difference) && hashMap.get(difference) != i) {
                return new int[]{i, hashMap.get(difference)};
            }
            hashMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public int[] twoSumBest(int[] nums, int target) {
        int volume = 2048;       //100000000000
        int bitMode = volume - 1; //011111111111

        // 定义一个长度为2048的数组？为什么是2048？
        int[] result = new int[volume];

        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (result[c] != 0) {
                return new int[]{result[c] - 1, i};
            }
            result[nums[i] & bitMode] = i + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        int[] ints = new Solution29().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}