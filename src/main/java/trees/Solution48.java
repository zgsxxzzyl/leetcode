package trees;

class Solution48 {
    /*public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }*/

    TreeNode pre = null;

    public static void main(String[] args) {
//        {3, 9, 20, null, null, 15, 7}
        TreeNode treeNode = TreeNode.create(new Integer[]{1, 2, 3, 4, 5});
        boolean i = new Solution48().isValidBST(treeNode);
        System.out.println(i);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);

    }
}