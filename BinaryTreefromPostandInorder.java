// Time Complexity :  O(N) worst time building a skewed tree
// Space Complexity : O(N) - HashMap
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
   HashMap<Integer, Integer> map;
   int index;
   public TreeNode buildTree(int[] inorder, int[] postorder) {
       map = new HashMap();
       if(postorder.length == 0 || inorder.length == 0){
           return new TreeNode();
       }
       for(int i = 0; i < inorder.length; i++){
           map.put(inorder[i],i);
       }
       index = postorder.length - 1 ;
       //TreeNode root = new TreeNode(postorder[postorder.length - 1]);
       return helper(inorder, postorder,0, inorder.length - 1);
       
   }
   private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
       if(start > end) return null;
       
       int rootval = postorder[index];
       TreeNode root = new TreeNode(rootval);
       int rootidx = map.get(rootval);
       index--;
       root.right = helper(inorder, postorder, rootidx + 1, end);
       root.left = helper(inorder, postorder, start, rootidx - 1);
       
       return root;
   }
}class BinaryTreefromPostandInorder {
    
}
