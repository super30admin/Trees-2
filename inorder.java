// TC: O(n) 
//SC: O(height)
//we use preorder to create nodes from left to right, 
//whenever we go left, we need to pass current root value as right boundary for it's whole left sub tree
//(root has no boundary, so used 3001 as valid nodes are from 1-3000, you could use Integer.MAX_VALUE), 
//so that the left sub tree creation will know when to exit to go right subtree, 
//the right bounary of right subtree is right subtree's parent's parent which was passed in.
public class inorder {
    class Solution { 
        int i, p; // i as index for inorder, p as index for preorder
        public TreeNode buildTree(int[] pre, int[] in) {
           i = p = 0;
           return dfs(pre, in, 3001);
        }
     
        private TreeNode dfs(int[] pre, int[] in, int rightBoundary) {
           if (p == pre.length || in[i] == rightBoundary) return null;
     
           TreeNode node = new TreeNode(pre[p++]);
           node.left  = dfs(pre, in, node.val);
           i++;
           node.right = dfs(pre, in, rightBoundary);
           return node;
        }
     }
}
