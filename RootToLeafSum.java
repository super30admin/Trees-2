
// Time Complexity :O(N) number of nodes
// Space Complexity :O(h) height of the tree
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english: Do any traversal and take the current sum as well in helper method 
// Your code here along with comments explaining your approach

public class RootToLeafSum {

    int result =0;

    public int sumNumbers(TreeNode root) {

    if(root==null)
        return result;

     helper(root,0); 

      return result;
    }
    public void helper(TreeNode root, int sum){
      // base Condition
      if(root==null)
        return;
      // logic 
        System.out.println(" Root "+root.val+ "-----Sum "+sum);
       
        int newSum = sum*10+root.val;
        
      if(root.left==null && root.right ==null){
           result+= newSum;
          System.out.println("Result "+ result);
           return;
      }
        
        
        helper(root.left,newSum);
        // st.pop()
        
        System.out.println("up --->  Root "+root.val+ "-----Sum "+sum);
      
        helper(root.right,newSum);
        // st.pop()
        
        System.out.println("down --->  Root "+root.val+ "-----Sum "+sum);
  }

}
