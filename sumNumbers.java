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
//Time Complexity: O(n)
// Space Complexity: O(height of tree)
// Leetcode: 129. Sum Root to Leaf Numbers
class Solution {
    
    int result;
    public int sumNumbers(TreeNode root) {
        result=0;
        int sum=0;
        calculate(root,sum);
        return result;
    }
    
	// Using recursion
    public void calculate(TreeNode node,int sum)
    {
        sum=sum*10+node.val;
        // Check if node is the leaf node
        if(node.right==null && node.left==null)
        {
            
            result+=sum;
           
        }
        // Check if node has node.left!=null && node.right==null 
        else if(node.right==null)
        {
            calculate(node.left,sum);
            
        }
         // Check if node has node.right!=null && node.left==null 
        else if(node.left==null)
        {
             calculate(node.right,sum);
        }
        else
        {
            calculate(node.left,sum);
            calculate(node.right,sum);
        }
       
            
    }
}

/*


//Time Complexity: O(n)
// Space Complexity: O(height of tree)
// Using backtracking
class Solution {
    
    int sum=0;
    int result=0;
    public int sumNumbers(TreeNode root) {
       
        
        calculate(root);
        return result;
    }
    
    // Using backtracking
    public void calculate(TreeNode node)
    {
        sum=sum*10+node.val;
        // Check if node is the leaf node
        if(node.right==null && node.left==null)
        {
            result+=sum;
            
            
           
        }
        // Check if node has node.left!=null && node.right==null 
        else if(node.right==null)
        {
             calculate(node.left);
           
            
        }
         // Check if node has node.right!=null && node.left==null 
        else if(node.left==null)
        {
             calculate(node.right);
           
            
        }
        else
        {
            calculate(node.left);
            calculate(node.right);
           
        }
         sum=sum/10;
       
            
    }
}
*/