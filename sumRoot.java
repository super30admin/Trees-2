//TC: O(n)
//SC: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode root;
    int sum;
    Pair(TreeNode root, int sum) {
        this.root = root;
        this.sum = sum;
    }
    public TreeNode getKey() {
        return this.root;
    }
    
    public int getValue() {
        return this.sum;
    }
}
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        
        // Stack<Pair> stack = new Stack<>();
        // int currSum = 0;
        // int result = 0;
        // while(root!=null || !stack.isEmpty()) {
        //     //left
        //     while(root!=null) {
        //         currSum = currSum * 10 + root.val;
        //         stack.push(new Pair(root, currSum));
        //         root = root.left;
        //     }
        //     Pair p = stack.pop();
        //     root = p.getKey();
        //     currSum = p.getValue();
        //     if(root.left==null && root.right==null) {
        //         result += currSum;
        //     }
        //     root = root.right;
        // }
        // return result;
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int currSum) {
        //base
        if(root == null) return;
        currSum = currSum*10 + root.val;
        helper(root.left, currSum);
        if(root.left == null && root.right == null) {
            result += currSum;
        }
        helper(root.right, currSum);
    }
}














