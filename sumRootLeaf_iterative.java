// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Pair  {
    int prev;
    TreeNode node;
    
    public Pair(int prev, TreeNode node)
    {
        this.prev=prev;
        this.node=node;
    }
    
    public TreeNode getNode()
    {
        return this.node;
    }
    
    public int getPrev()
    {
        return this.prev;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        /* Iterative Other way */
        if(root==null) return 0;
        
        Stack<Pair> stack=new Stack<>();
        int currSum=0;
        int result=0;
        
        while(root!=null || !stack.isEmpty())
        {
            /* Traverse left */
            while(root!=null)
            {
                stack.push(new Pair(currSum, root));
                currSum=currSum*10+root.val;
                root=root.left;
            }
            
            /* Pop From Stack */
            Pair current = stack.pop();
            root=current.getNode();
            currSum=current.getPrev()*10+root.val;
            
            /* Check if Current Root is leaf node */
            
            if(root.left==null && root.right==null)
                result+=currSum;
    
            /* Go right. */
            
            root=root.right;
            
        }
        
        return result;
    }
}