package trees;

class Solution47 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        int i = new Solution47().maxDepth(treeNode);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        TreeNode right = root;
        int dep = 0;
        while (right != null) {
            right = right.right;
            dep++;
        }
        return dep;
    }
}