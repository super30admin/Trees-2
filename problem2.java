//time- O(N)- N # of nodes in the tree
//space- O(H)- height of the tree

class Solution {
    int total=0;
  public int sumNumbers(TreeNode root) {
  //preorder! with slight modification

      
       calSum(0, root);
      
      return total;
  }
  
  public void calSum(int s, TreeNode root){
    
      if(root==null) return ; //null check is imp here!(edge case)
      
      s=s*10+root.val;
      
      if(root.left==null && root.right==null) total+=s; //base case
      
      calSum(s,root.left);
      calSum(s,root.right);
      
      System.out.println("end is reached");

  }
}