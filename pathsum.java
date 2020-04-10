#Time Complexity : O(n)
#Space Complexity : O(max depth)


class Solution {
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        int k=0;
        
        return leafsum(root,k,sum); 
     
        
    }
        
        public boolean leafsum(TreeNode p,int k,int sum)
        {
            if(p==null)
                return false;
            else if(p.left==null && p.right==null){
                return ((k+p.val)== sum);
            }
            else 
            {
              return (leafsum(p.left,k+p.val,sum)||leafsum(p.right,k+p.val,sum)); 
              
            }
     }
    
    
    
   
    
    
    
}