/**
 * 
 * Idea is to use recursion.
 * 
 * Space Complexity: O(lg n) average case, O(n) worst case
 * Time Complexity: O(n), n is the number of nodes in the tree
 * 
 * Leetcode Result:
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
 * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
 */
public class SumRootLeaf {

    public int sumNumbers(TreeNode root) {
        return sumNumber(root, 0);
    }

    private int sumNumber(TreeNode root, int sum) {
        // base case: root is null
        if (root == null) {
            return 0;
        }
        // case: leaf node
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        // recurse on left and right and sum them up.
        return sumNumber(root.left, sum * 10 + root.val) + sumNumber(root.right, sum * 10 + root.val);
    }
}