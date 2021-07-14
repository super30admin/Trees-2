// Time complexity: O(N), where N is the number of nodes in the tree.
// Space complexity: O(N)

import java.util.*;

class Solution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // postorder - left, right, root
    // inorder - left, root, right
    
    int index;
    HashMap<Integer, Integer> inorderMap = new HashMap<>(); 
    public TreeNode helper(int[] postorder, int low, int high) {
        if(low <= high) {
            int val = postorder[index--];
            int valIndex = inorderMap.get(val);
            // root
            TreeNode root = new TreeNode(val);
            // right tree
            root.right = helper(postorder, valIndex + 1, high);
            // left tree
            root.left = helper(postorder, low, valIndex-1);
            return root; 
        }
        return null; 
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // maintaing an index for the postorder array.
        index = postorder.length - 1;
        // putting elements in a map since there are no duplicates and it takes O(1) lookup time.  
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i); 
        }
        return helper(postorder, 0, inorder.length-1); 
    }
}