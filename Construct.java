// Overall Time Complexity : O(n^2) . The time taken due  to linear searches and copying in each recursive call.
// Overall Space Complexity : O(n^2) . The space complexity is 0(n) because  to repeated subarray copying and the recursion stack.
// Any problem you faced while coding this : No issues faced during implementation
// Did this code successfully run on Leetcode :Yes


import java.util.Arrays;

import javax.swing.tree.TreeNode;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
       return helper(inorder, postorder); 
    }
   private TreeNode helper ( int [] inorder, int[] postorder){
        if (postorder.length == 0){
            return null;
        }
        // root node
        int rootValue = postorder[postorder.length-1];
        TreeNode root =  new TreeNode(rootValue);
        int rootIndex = -1;
        //find the root in inorder to get the left subtree and right subtree

        for(int i = 0 ; i<inorder.length; i++){
            if(root.val== inorder[i]){
                rootIndex = i;
                break;
            }
        }

        //Mark the left subtree and right subtree in the  inorder and post order 
        int [] inorder_left = Arrays.copyOfRange(inorder, 0, rootIndex);
        int [] inorder_right = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int [] postorder_left = Arrays.copyOfRange(postorder, 0, inorder_left.length);
        int [] postorder_right = Arrays.copyOfRange(postorder, inorder_left.length, postorder.length-1);

        // recursively traverse left and right subtrees
        root.left = helper(inorder_left, postorder_left);
        root.right = helper(inorder_right, postorder_right);

        return root;
}
}