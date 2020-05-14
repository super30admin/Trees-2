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

 // sum root to leaf members
 //Time o(n) n - no of nodes
 //space o(h) h - height of the tree
class Solution {
    class Pair{
        TreeNode root;
        int sum;
        Pair(TreeNode root, int sum){
            this.root = root;
            this.sum = sum;
        }
    }
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if(root == null)
            return res;
        Stack<Pair> stack = new Stack<>();
        int sum = 0;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                sum = sum*10 + root.val;
                stack.push(new Pair(root,sum));
                root = root.left;
            }
            Pair p = stack.pop();
            root = p.root;
            sum = p.sum;
            //leaf node
            if(root.left == null && root.right == null){
                res = res + sum;
            }
            root = root.right;
        }
        return res;
    }
}



//Need to solve the other type, Construct binary tree from inorder and postorder