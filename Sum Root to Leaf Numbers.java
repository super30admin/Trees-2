// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
      int result;
    public int sumNumbers(TreeNode root) {
        //edge
        if(root==null) return 0;
        
        helper(root,0);
        return result;
    }
    private int helper(TreeNode root, int sum)
    {
        // edge 
    
      if(root==null) return result;
        //action
        sum=sum*10+root.val;
        if(root.left==null && root.right==null)
        {
            result+=sum;
        }
        
        //recursion
        
         helper(root.left,sum);
        //st.pop()
        helper(root.right,sum);
        
        return result;
    }
}
