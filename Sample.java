// Time Complexity : O(n) where n is number of nodes as we need to process each node once and Hashmap operations are O(1)
// Space Complexity : O(n) for hashmap and recursion stack in worst case where n is number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed class tutorial


// Your code here along with comments explaining your approach
// We will first create a hashmap to store the indices of the elements in the inorder array for quick access. Then we will use helper function to recursively 
// construct the tree. Start from the last element of the postorder array as the root and then we will use the inorder array from hashmap to determine the subtree
// boundries. For each root node we will recursively construct its right and left subtrees by slicing the inorder array accordingly. 
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
    HashMap<Integer, Integer> map;
    int idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length - 1;

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        
        if(start > end) {
            return null;
        }
        
        int rootVal = postorder[idx];
        idx--;

        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

       return root;
    }
}



// Time Complexity : O(n) where n is number of nodes as will traverse through all the nodes in the tree
// Space Complexity : O(h) where h is the height of the tree for the recursive call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed class tutorial which in worst case scenario could be n.


// Your code here along with comments explaining your approach
// In this solution we can traverse the tree recursively where we will pass along the current calculated number formed by the path from the root to the current 
// node. Then we will apply the leaf check where we can check if we have reached the leaf node or not. If we have reached a leaf node we can return the current 
// calculated number. For non-leaf nodes we can recursively calculate the sum for left and right subtrees and return their sum.

import java.util.Currency;/**
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
    // int result;
    public int sumNumbers(TreeNode root) {

        return helper(root, 0);

        // return result;
        
    }

    private int helper(TreeNode root, int currNum) {

        if(root == null) {
            return 0;
        }

        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null) {
            // result = result + currNum;
            return currNum;
        }

        int left = helper(root.left, currNum);

        int right = helper(root.right, currNum);

        return left + right;

    }
}