//Iterative solution

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
class Solution {
    public class Pair{
        TreeNode node;
        int value;
      Pair(TreeNode node,int value){
          this.node = node;
          this.value = value;
      }
        public TreeNode getKey(){ return this.node;}
       
        public int getValue(){ return this.value; }        
    }
   
    public int sumNumbers(TreeNode root) {
    int currSum = 0; int result = 0;
     Stack<Pair>st = new Stack<>();  
     while( root!= null || !st.isEmpty()){
         while( root != null){
             currSum = currSum * 10 + root.val;
             st.push(new Pair(root,currSum));
             root = root.left;
         }
         Pair p = st.pop();
         root = p.getKey();
         currSum = p.getValue();
         if(root.left == null && root.right == null ) {// leaf node
             result+= currSum;
         }
         root = root.right;
     }
        return result;
    }
}
 /*
 Time & Space complexity : O(H) accessing all the nodes through the height at max
 */  
   
   
   
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
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
   
    private int helper(TreeNode root,int currSum){
        if(root == null ) return 0; //even if root is null but stack is not empty hence keeps retriving values     //from the recursive stack
       
        //logic
        if(root.left == null && root.right == null ){
            return currSum * 10 + root.val;
        }
       
        int left = helper(root.left,currSum * 10 + root.val);
       
        int right = helper(root.right,currSum * 10 + root.val);
       
        return left + right;
    }
}

/*Recursive solution
Time and Space Complexity : O(H)
*/
