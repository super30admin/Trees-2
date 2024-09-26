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
 
 // Iterative Solution 
 // Time Complexity: O(N)
 // Space Complexity: O(h) where h is the height of the tree;
 
 class Solution {
    class Pair{
        TreeNode node;
        int val;
        public Pair(TreeNode node, int val)
        {
            this.node = node;
            this.val = val;
        }
        public int getValue()
        {
            return this.val;
        }
        public TreeNode getNode(){
            return this.node;
        }
    }
    public int sumNumbers(TreeNode root) {
        Stack<Pair>st = new Stack<>();
        int result = 0;
        int sum = 0;
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                sum = sum * 10 + root.val;
                st.push(new Pair(root, sum));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.getNode();
            sum = p.getValue();
            if(root.left == null && root.right == null)
                result = result + sum;
            root = root.right;
        }
        return result;
    }
}
*/

// Recursive Solution;
// Time Complexity: O(N)
// Space Complexity: O(h)
class Solution {
    int result = 0; //global variable;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int sum) //note we need sum as a local variable and result as // global
    {
        //base
        if(root == null)
            return;
        
        //logic
        if(root.left == null && root.right == null)
            result = result + sum * 10 + root.val;
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
}