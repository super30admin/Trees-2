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

//TC: O(n)
//SC: O(n)

class Solution {

  public int preIndex;
  int[] preorder;
  int[] inorder;
  HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] preorder) {
    this.preorder = preorder;
    this.preIndex = preorder.length-1;
    this.inorder = inorder;
    for(int i=0; i<inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return solve(preorder, 0, inorder.length-1);
  }

  private TreeNode solve(int[] preorder, int start, int end) {


    // base case:
    if(start > end)
      return null;



    // recursion:
    TreeNode node = new TreeNode(preorder[preIndex]);
    int idx = map.get(preorder[preIndex]);
    preIndex--;
    node.right = solve(preorder, idx+1, end);
    node.left = solve(preorder, start, idx-1);

    return node;
  }
}



