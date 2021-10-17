//TC:O(n)
//SC:O(n+height)
//successfully ran on leetcode
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
        private HashMap<Integer,Integer> hashMap;
        private int postIndex;

        public TreeNode buildTree(int[] inorder, int[] postorder)
        {
            if(postorder==null ||inorder==null)
                return null;

            hashMap=new HashMap<>();
            postIndex=postorder.length-1;

            for(int x=0;x<inorder.length;x++)
            {
                hashMap.put(inorder[x],x);
            }
            return buildTreeHelper(inorder,postorder,0,inorder.length-1);
        }
        private TreeNode buildTreeHelper(int[] inorder,int[] postorder,int inStart,int inEnd)
        {
            if(inStart>inEnd)
                return null;

            TreeNode root=new TreeNode(postorder[postIndex]);
            postIndex--;

            int index=hashMap.get(root.val);

            root.right=buildTreeHelper(inorder,postorder,index+1,inEnd);
            root.left=buildTreeHelper(inorder,postorder,inStart,index-1);

            return root;
        }
    }
