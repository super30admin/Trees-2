
//approach -2
//take just global variable num, and return the value from leaf directly
//logic : prev*10 + curr val; when node is 1 -> 2 ; we have num as 12
//Tc: O(n)
//Sc: stack space:O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int num = 0;

    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        // base case
        if (root == null)
            return num;

        // leaf check
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }

        int case1 = dfs(root.left, num * 10 + root.val);
        int case2 = dfs(root.right, num * 10 + root.val);

        return case1 + case2;
    }
}

// approach-3
// iterative approach - take two stacks - s and nums, at every node, we'll push
// root and tcurrent sum in stack.
// we've two variables here , sum as global varibale and num as local variable
// we'll push root and it's current (num) = num*10+root.val to stack, so at leaf
// check we dont need to do it again!

class Solution {

    public int sumNumbers(TreeNode root) {
        int sum = 0; // global sum
        int num = 0; // local loop sum storing in stack

        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        while (root != null || !s.isEmpty()) {

            while (root != null) {
                s.push(root);
                num = num * 10 + root.val;
                nums.push(num);
                root = root.left;
            }
            // done with left tree

            // get the root and last num value from the stack
            root = s.pop();
            num = nums.pop();

            // check for the leaf node condition before going to right node
            if (root.left == null && root.right == null) {
                sum += num;
            }
            root = root.right; // we go to right node regardless of the condition check, cause what if it's top
                               // node, then we still have to go to it's right part, correct?!
        }
        return sum;
    }
}