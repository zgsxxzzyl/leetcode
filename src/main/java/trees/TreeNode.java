package trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode create(Integer[] nums, int index) {
        TreeNode top = null;
        if (index < nums.length) {
            Integer value = nums[index];
            if (value == null) {
                return null;
            }
            top = new TreeNode(value);
            top.left = create(nums, index * 2 + 1);
            top.right = create(nums, index * 2 + 2);
            return top;
        }
        return top;
    }
}