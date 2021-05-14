// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class treeFromPostIn {

    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> sMap = new HashMap<Integer, Integer>();
  
    public TreeNode helper(int in_left, int in_right) {
        
      if (in_left > in_right)
        return null;
  
      int root_val = postorder[post_idx];
      TreeNode root = new TreeNode(root_val);
  
      int index = sMap.get(root_val);
  
      // recursion 
      post_idx--;
      root.right = helper(index + 1, in_right);
      root.left = helper(in_left, index - 1);
        
      return root;
        
    }
  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      this.postorder = postorder;
      this.inorder = inorder;
        
      post_idx = postorder.length - 1;
  
      int idx = 0;
        
      for (Integer val : inorder)
        sMap.put(val, idx++);
        
      return helper(0, inorder.length - 1);
    }
    
}