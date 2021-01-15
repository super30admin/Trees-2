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

//Iterative solution
//TC: O(N) -> N : no. of nodes in the tree
//SC: O(H) -> H: height of the tree
//Did it run successfully on Leetcode? : Yes
class Pair{
    TreeNode key;
    int value;
    Pair(TreeNode k, int v)
    {
        this.key = k;
        this.value = v;
    }
    public TreeNode getKey()
    {
        return this.key;
    }
    public int getValue()
    {
        return this.value;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        
       int result = 0;
       int currSum = 0;
       Stack<Pair> stack = new Stack();
       while (root != null || !stack.isEmpty())
       {       
           while ( root != null)
           {
               currSum = currSum * 10 + root.val;
               stack.push(new Pair(root, currSum));
               root = root.left;
           }
        
           Pair p = stack.pop();
           root = p.getKey();
           currSum = p.getValue();
           
          if (root.left == null && root.right == null)
              result = result + currSum;
           
           root = root.right;
       }
       return result;
    }
}


// Recursive solution
// TC: O(N) -> N : no. of nodes in the tree
// SC: O(H) -> H: height of the tree
// Did it run successfully on Leetcode? : Yes
// class Solution { 
//     int result = 0;
//     public int sumNumbers(TreeNode root) {
//         if (root == null)
//             return 0;
        
//        helper(root, 0);
//        return result;
//     }
//     private void helper(TreeNode root, int currSum)
//     {
//         //base
//         if (root == null)
//             return;        
//         // logic
//         currSum = currSum * 10 + root.val;
//         helper(root.left, currSum);
//         if ( root.left == null && root.right == null)
//             result = result + currSum;
//         helper(root.right, currSum);
//     }
// }
