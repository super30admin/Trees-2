// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//Use recrussion to find root  and then left and right child, and repeat until tree is drawn
import javax.swing.tree.TreeNode;

public class ConstructBinaryTreeFromPostOrderAndInorderTraversal {

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {

            int inStart = 0;
            int inEnd = inorder.length-1;
            int postStart = 0;
            int postEnd = postorder.length-1;

            return builder(inStart, inEnd, postStart, postEnd, inorder, postorder);
        }

        public TreeNode builder(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder){
            if(inStart > inEnd || postStart > postEnd) return null;

            //root value
            int rootValue = postorder[postEnd];
            TreeNode root = new TreeNode(rootValue);

            //find left and right nodes
            int k = 0;
            for (int i = 0; i < inorder.length; i++) {
                if(inorder[i] == rootValue){
                    k=i;
                    break;
                }
                
            }

            root.left = builder(inStart, k-1, postStart, postStart + k-(inStart+1), inorder, postorder);
            root.right = builder(k+1, inEnd, postStart+k-inStart, postEnd-1, inorder, postorder);

            return root;
        }
    }

}
