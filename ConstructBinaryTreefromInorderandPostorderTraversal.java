//106. Construct Binary Tree from Inorder and Postorder Traversal

// Time Complexity : O(n), where n is the number of nodes. Each node is visited once, and lookup in the HashMap is O(1).
// Space Complexity : O(n), due to the HashMap storing all inorder values, plus O(h) recursion stack where h is the height of the tree (O(n) in worst case, O(log n) for balanced tree).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach (in five sentences):

// The algorithm reconstructs the binary tree using the inorder and postorder traversal arrays. 
  // Since the last element of postorder is always the root, we use this to create the root node and move backward through the postorder array. 
  // To quickly locate a root’s position in inorder, we store each inorder value’s index in a HashMap. 
  // The inorder array is split into left and right subtrees based on the root’s position, and recursive calls are made to build the right subtree first, then the left subtree. 
  // This order ensures correctness because postorder is processed from the end (root → right → left when reversed).

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
    HashMap<Integer,Integer> map;
    int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.map = new HashMap<>();
        postOrderIdx = postorder.length-1;

        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){

        if(start > end) return null;

        int rootVal = postorder[postOrderIdx];
        int rootIdx = map.get(rootVal);
        postOrderIdx--;

        TreeNode node = new TreeNode(rootVal);

        node.right = helper(postorder,rootIdx+1,end);
        node.left = helper(postorder,start,rootIdx-1);
      
        return node;
    }   
}
