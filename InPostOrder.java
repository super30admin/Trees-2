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

// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


class InPostOrder {
  int pidx;
  int[] postorder;
  int[] inorder;
  HashMap<Integer, Integer> hmap = new HashMap<>();


  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;
    pidx = postorder.length - 1;

    // build a hashmap to store value and its index
    int idx = 0;
    for (Integer val : inorder)
      hmap.put(val, idx++);
    return helper(0, inorder.length - 1);
  }
    
     public TreeNode helper(int left, int right) {
    if (left > right) return null; // check if no elements
    int root_val = postorder[pidx];  // select pidx element as a root 
    TreeNode root = new TreeNode(root_val);


    int index = hmap.get(root_val);     // root splits inorder list into left and right subtrees
    pidx--; // decrement pindx
    // build right subtree
    root.right = helper(index + 1, right);
    // build left subtree
    root.left = helper(left, index - 1);
    return root;
  }
}