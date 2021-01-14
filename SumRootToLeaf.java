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
class Pair{
    TreeNode node;
    int sum;
    Pair(TreeNode node,int sum){
        this.node = node;
        this.sum = sum;
    }
}
class Solution {
    
    
    /*
    method 2: recursive approach
    */

    int result;
    public int sumNumbers(TreeNode root) 
    {
              
        if(root == null){
            return 0;
        }      
        this.result = 0;
        return helper(root,0);
    }
    
    private int helper(TreeNode root,int currSum)
    {
        
        if(root == null){
            return 0;
        }
         if(root.left == null && root.right == null){
            return currSum * 10 + root.val;
             
             
        } 
      
        currSum = currSum * 10 + root.val;       
        return helper(root.left,currSum) + helper(root.right,currSum);
    }
}      
    
    /*
    method 1: ietrative approach
    time complexity: O(n)
    space complexity:O(n)
    */
//         int result = 0;
//         int currSum = 0;
//         Stack<Pair>stack = new Stack<>();
        
//         while(!stack.isEmpty() || root != null){
            
//             while(root != null)
//             {
//                 currSum = currSum * 10 + root.val;               
//                 Pair p = new Pair(root,currSum);
//                 stack.push(p);
//                 root = root.left;
//             }
            
//             Pair p = stack.pop();
//             root = p.node;
//             currSum = p.sum;
            
//             if(root.left == null && root.right == null){
//                 result += currSum;
//             }
//             root = root.right;
//         }
//         return result;
//     }
