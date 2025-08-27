
//void based
public class SumRootToLeaf {
    int result;
    public int sumNumbers(TreeNode root) 
    {
        this.result=0;
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root,int currNum)
    {
        if(root==null) return;
        currNum=currNum*10+ root.val;
        
        if(root.left==null && root.right==null)
        {
          result+=currNum;
        }
        helper(root.left,currNum);
        helper(root.right,currNum);
    }    
}

//int based recursion
class SumRootToLeaf2 {
    public int sumNumbers(TreeNode root) 
    {
        
        return helper(root,0);
        
    }
    private int helper(TreeNode root,int currNum)
    {
        if(root==null) return 0;
        currNum=currNum*10+ root.val;
        
        if(root.left==null && root.right==null)
        {
          return currNum;
        }
        int left= helper(root.left,currNum);
        int right=helper(root.right,currNum);
        return left+right;
    }    
}



 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
