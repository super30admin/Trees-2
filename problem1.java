// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:

/*
 * Approach:
 * 1. We are given the preorder and inorder traversal arrays of a binary tree.
 * 2. Our goal is to reconstruct the binary tree using these arrays.
 * 3. We use the property that the first element in the preorder array is always
 *    the root of the tree or subtree we are constructing.
 * 4. We use a HashMap to store the indices of the elements in the inorder array
 *    for quick lookup. This allows us to find the root's index in the inorder array in O(1) time.
 * 5. We recursively construct the left and right subtrees using the preorder and inorder arrays.
 * 6. We increment the `idx` variable to keep track of the current element in the preorder array.
 */

import java.util.Arrays;
import java.util.HashMap;

// Your code here along with comments explaining your approach
public class problem1 {
     public class TreeNode {
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
  HashMap<Integer, Integer> map;
     int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.idx=0;
        this.map=new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);


    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start>end) return null;
        int rootVal=preorder[idx];
        idx++;
        int rootIdx= map.get(rootVal);

        TreeNode root= new TreeNode(rootIdx);
        root.left=helper(preorder, start, rootIdx-1);
        root.right=helper(preorder, rootIdx+1, end);
        return root;
    }

}
