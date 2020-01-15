// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        List result = new ArrayList();
        sumtree(root,result,0);	// recursively call the function to traverse through the array to find all the paths 
        int num = 0;
        
        for(int i = 0; i < result.size(); i++){		// once the numbers corresponding to the path are obtained, add them to give the final answer
            num += (int)result.get(i);
        }
        
        return num;
    }
    public void sumtree(TreeNode root,List res,int sum){
        if(root==null) return;		// if the root is equal to null, return 
        
        sum=sum*10+root.val;		// since every number we encounter can be represented in by multiplying 10 and add them to the previous value
        
        if(root.left==null&&root.right==null){		// if we reach the leaf, add the sum to the list
            res.add(sum);
        }
        
        sumtree(root.left,res,sum);			// recursively traverse through both left and right side of each root
        
        sumtree(root.right,res,sum);
    }
}