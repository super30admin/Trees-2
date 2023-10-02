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
 // Time Complexity : O(n) where n is number of elements in the tree
 // Space Complexity: O(h) where h is the height of the tree
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
        {
          return 0;
        }       
        int sum = 0;
       // Stack s to store values
       Stack<TreeNode> s = new Stack<TreeNode>();
       // Stack currSum to store current sum till that node
       Stack<Integer> cSum = new Stack<Integer>();
       int currSum = 0;
       while(root!=null || !s.isEmpty())
       {
           while(root != null)
           {
               s.push(root);
               cSum.push(currSum*10+root.val);
               currSum = currSum*10+root.val;
               root = root.left;
           }
           root = s.pop();
           currSum = cSum.pop();
           if(root.left==null && root.right == null)
           {
               sum+=currSum;
           }
           root = root.right;
       }

       return sum;

    }

}

