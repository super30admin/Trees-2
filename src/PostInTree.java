import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



public class PostInTree {
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
        int ind ;
        Map<Integer, Integer> map;
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

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            ind = postorder.length -1;
            map = new HashMap<>();
            if(postorder == null ||postorder.length ==0 || inorder.length ==0) return null;
            for(int i=0; i < inorder.length;i++) {
                map.put(inorder[i], i);
            }
            TreeNode root = helper(postorder, inorder, 0, postorder.length-1);

            return root;
        }
        private TreeNode helper(int[] postorder, int[] inorder, int start, int end ){
            if(start > end){
                return  null ;
            }
            int rootinx = postorder[ind];
            TreeNode root = new TreeNode(rootinx);
            ind--;
            int rootIdx = map.get(root.val);
            TreeNode right = helper(postorder, inorder, rootIdx+1, end);
            TreeNode left = helper(postorder, inorder, start, rootIdx-1);

            root.left = left;
            root.right = right;
            return root;
        }
    }

}
