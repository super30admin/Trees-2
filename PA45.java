//Leetcode 129. Sum Root to Leaf Numbers
//Recursive solution
//Time complexity: O(n)
//Space Complexity: O(n) 

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        result=0;       
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int tsum){
        if(root==null){
            return 0;
        }
        tsum= tsum*10+root.val;        
        if(root.left==null && root.right==null){
            result= result+tsum;
        }        
        helper(root.left,tsum );
        helper(root.right,tsum );
        return result;
        
    }
    
}


=============================================================================

//Iterative solution
//Time complexity: O(n)
//Space Complexity: O(n) 
class Solution {
    class Nodes{
            TreeNode node;
            int sVal=0;
             Nodes(TreeNode node, int sVal){
                 this.node = node;
                 this.sVal= sVal;
             } 
           public TreeNode getNode(){
               return this.node;
           }
             public int getsum(){
               return this.sVal;
           }
            
        }
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res=0;
        
        int tsum=0;
        Stack<Nodes> st = new Stack<>();
      
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                tsum=tsum*10+root.val;
                st.push(new Nodes(root,tsum));
                root=root.left;
            }    
            Nodes n = st.pop();
            TreeNode t= n.getNode();
            tsum = n.getsum();
            if(t.left==null && t.right==null){
              
                res= res+ n.getsum();
            }
            root= t.right;    
            
        }
        
        return res;
        
        
    }
}