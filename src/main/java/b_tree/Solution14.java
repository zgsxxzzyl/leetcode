package b_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/14/
 */
public class Solution14 {

    public static List inorder(TreeNode node, int sum, LinkedList temp, List result) {
        if (node != null) {
            sum -= node.val;
            temp.addLast(node.val);
            if (node.left != null) {
                inorder(node.left, sum, temp, result);
            }
            if (node.right != null) {
                inorder(node.right, sum, temp, result);
            }
            if (sum == 0) {
                LinkedList right = new LinkedList();
                right.addAll(temp);
                result.add(right);
            }
            sum += node.val;
            temp.removeLast();
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1};

        nums = new Integer[]{1, 2};
        TreeNode node = TreeNode.create(nums);
        System.out.println(new Solution14().hasPathSum(node, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        List inorder = inorder(root, sum, new LinkedList(), new ArrayList());
        return inorder != null && inorder.size() > 0;
    }

    /**
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    /**
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}