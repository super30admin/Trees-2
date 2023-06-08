// Time Complexity:           O(n)
// Space Complexity:          O(n+h)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
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

class PostInToBinaryTree {
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        for(int i =0; i<inorder.length; i++)                                                 // storing all inorder elements' order
            map.put(inorder[i],i);
        return build(postorder, 0, inorder.length-1);
       
// // ******************** Another method ******************** 
//         // Base case
//         if(postorder.length == 0) return null;

//         // getting indexes of root node in preorder and inorder
//         int rootVal = postorder[postorder.length - 1];
//         int rootIndIn = -1;
//         for(int i=0; i<inorder.length; i++) {
//             if(inorder[i] == rootVal) {
//                 rootIndIn = i;
//                 break;
//             }
//         }

//         // left and right subarrays for recursion
//         int[] postLeft = Arrays.copyOfRange(postorder, 0, rootIndIn);
//         int[] postRight = Arrays.copyOfRange(postorder, rootIndIn, postorder.length-1);
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndIn);
//         int[] inRight = Arrays.copyOfRange(inorder, rootIndIn+1, inorder.length);

//         // Recursion
//         TreeNode root = new TreeNode(rootVal);
//         root.left = buildTree(inLeft, postLeft);
//         root.right = buildTree(inRight, postRight);

//         return root;
    }
    private TreeNode build(int[] postorder, int start, int end) {
        if(start > end)
            return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);                                // creating new node to be added in a tree(new temp root)

// ******************** Not need to handle these cases ********************          
//         if(root == null)
//             return null;
//         if(start == end)                                                                     // leaf node
//             return root;

        int index = map.get(root.val);

        root.right = build(postorder, index+1, end);                                         // creating right child subtree
        root.left = build(postorder, start, index-1);                                        // creating left child subtree

        return root;
    }
}
