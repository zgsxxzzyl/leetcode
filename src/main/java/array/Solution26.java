package array;

import java.util.*;

class Solution26 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1_map = parseMap(nums1);
        Map<Integer, Integer> nums2_map = parseMap(nums2);

        List arr = new ArrayList<Integer>();
        nums1_map.forEach((k, v) -> {
            if (nums2_map.containsKey(k)) {
                if (nums1_map.get(k) > nums2_map.get(k)) {
                    Integer integer = nums2_map.get(k);
                    for (int i = 0; i < integer; i++) {
                        arr.add(k);
                    }
                } else {
                    Integer integer = nums1_map.get(k);
                    for (int i = 0; i < integer; i++) {
                        arr.add(k);
                    }
                }
            }
        });
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = (int) arr.get(i);
        }
        return res;
    }

    private Map<Integer, Integer> parseMap(int[] nums1) {
        Map<Integer, Integer> nums1map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1map.containsKey(nums1[i])) {
                nums1map.put(nums1[i], nums1map.get(nums1[i]) + 1);
            } else {
                nums1map.put(nums1[i], 1);
            }
        }
        return nums1map;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] res = new Solution26().intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}