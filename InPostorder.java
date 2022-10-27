
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class InPostorder {

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
        public int preIndex;
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            preIndex = postorder.length - 1;
            this.preorder = postorder;
            this.inorder = inorder;
            for (int i= 0 ; i <= inorder.length - 1; ++i){
                map.put(inorder[i], i);
            }
            return buildTree(0, preorder.length -1);

        }

        public TreeNode buildTree(int start, int end){

            if(start > end){
                return null;
            }

            TreeNode node = new TreeNode(preorder[preIndex]);
            preIndex--;

            if(start == end) return node;

            int index = this.getindex(node.val);
            node.right = buildTree(index + 1, end);
            node.left = buildTree(start, index-1);
            return node;
        }

        public int getindex( int ele){
            return map.get(ele);
        }
    }
