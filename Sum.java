// Time Complexity : O(n) where n is number of nodes
// Space Complexity : O(H) stack space where H is height of the tree. 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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

<------Recursion---->
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumTree(root,0);
    }
    private int sumTree(TreeNode root, int currSum){
        //base
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return currSum*10 + root.val;
        } 
        
        //logic
        return sumTree(root.left, currSum*10 + root.val) + sumTree(root.right, currSum*10 + root.val);
    }
}

<----Iterative---->
//Time: O(n)
//Space: O(n)
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
class Solution {
    class Pair{
        int sum;
        TreeNode node;
        
        public Pair(TreeNode node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,0));
        
        while(stack != null && !stack.isEmpty()){
            Pair p = stack.pop();
            TreeNode node = p.node;
            int val = p.sum;
            if(node != null){
                val = val*10 + node.val;
                if(node.left == null && node.right == null){
                    sum += val;
                }
                stack.push(new Pair(node.right, val));
                stack.push(new Pair(node.left, val));
            }
        }
        return sum;
    }
}