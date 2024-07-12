// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root , int currNum){
        if(root == null) return ;
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null){
            result += currNum;
        }
        helper(root.left, currNum);
        
        helper(root.right, currNum);
    }
}

//--------------------------------------------------------------------
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
    int Idx ;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       this.map = new HashMap<>();
       this.Idx = postorder.length-1;

       for (int i = 0; i < inorder.length; i++) {
         map.put(inorder[i], i);

       }
       return helper(postorder , 0 , inorder.length-1);

       
    }

    private TreeNode helper(int[] postorder, int start, int end){
        if(start > end) return null;
        int rootVal = postorder[Idx];
        Idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right =helper(postorder, rootIdx +1, end );
        root.left =helper(postorder,start , rootIdx -1 );
       
        return root;

    }
}


