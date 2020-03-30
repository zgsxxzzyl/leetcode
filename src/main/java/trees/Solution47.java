package trees;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution47 {

    public static void main(String[] args) {
//        {3, 9, 20, null, null, 15, 7}
        TreeNode treeNode = TreeNode.create(new Integer[]{1, 2, 3, 4, 5});
        int i = new Solution47().maxDepth(treeNode);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthExt(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }

}