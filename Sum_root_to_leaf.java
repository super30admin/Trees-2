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
    //Time O(N)
    //Space O(N)
    public int sumNumbers(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        int result = 0 ,currSum = 0;
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                currSum = currSum*10 + root.val;
                stack.push(new Node(root,currSum));
                root = root.left;
            }
            Node p = stack.pop();
            root = p.node;
            currSum = p.currSum;
            if(root.left == null && root.right == null)
            {
                result += currSum;
            }
            root = root.right;
        }
        return result;
    }
    class Node
    {
        TreeNode node;
        int currSum;
        public Node(TreeNode node, int currSum)
        {
            this.node = node;
            this.currSum = currSum;
        }
    }
}