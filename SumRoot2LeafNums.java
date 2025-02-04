// Approach: Traverse the tree in a DFS manner while keeping track of the current path sum. When a leaf node is encountered, update
// the path sum by adding the leaf’s value and include it in the global sum.
// Time Complexity: O(n) where n - node count
// Space Complexity: O(h) for recursion stack. where h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

import java.util.List;
import java.util.ArrayList;

public class SumRoot2LeafNums {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    private int sum;

    int sumRoot2Leaf(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        List<Integer> path = new ArrayList<>();
        sum = 0;
//        traverse1(root, path);
        traverse(root, sum);
        return sum;
    }

    void traverse(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            pathSum = pathSum * 10 + root.val;
            sum += pathSum;
            return;
        }
        pathSum = pathSum * 10 + root.val;
        traverse(root.left, pathSum);
        traverse(root.right, pathSum);
    }

    void traverse1(TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) {
            int s = 0;
            for (int i = 0; i < path.size(); i++) {
                s = s * 10 + path.get(i);
            }
            s = s * 10 + root.val;
            sum += s;
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            traverse1(root.left, path);
        }
        if (root.right != null) {
            traverse1(root.right, path);
        }
        path.remove(path.size() - 1); // backtrack**
    }

    public static void main(String[] args) {
        SumRoot2LeafNums sumr2l = new SumRoot2LeafNums();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(1);
        System.out.println("Sum of root to leaf numbers: " + sumr2l.sumRoot2Leaf(root));
    }
}