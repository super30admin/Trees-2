// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BSTfromInPostOrder {
    class Solution {
        private HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int in = inorder.length, post = postorder.length;

            for(int i = 0; i < in; i++){
                map.put(inorder[i], i);
            }

            return helper(postorder, 0, post-1, inorder, 0, in-1);
        }

        private TreeNode helper(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd){
            if(postStart > postEnd || inStart > inEnd){
                return null;
            }

            TreeNode root = new TreeNode(postorder[postEnd]);

            int rootIdxIn = map.get(root.val);
            int rootLeftEls = rootIdxIn - inStart;

            root.left = helper(postorder, postStart, postStart + rootLeftEls - 1, inorder, inStart, rootIdxIn-1);

            root.right = helper(postorder, postStart + rootLeftEls, postEnd-1, inorder, rootIdxIn+1, inEnd);

            return root;
        }
    }
}
