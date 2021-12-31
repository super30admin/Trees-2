// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/\*\*problem 1

T.C:O(n)S.C:O(n)





class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null)
            return null;
        map = new HashMap<>();
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) {
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

/* Problem 2: T.C is o(H) and S.C o(H) H is height of the tree */

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
    int sum;
    public int sumNumbers(TreeNode root) {
    if(root == null) return 0;
    helper(root,0);
    return sum;
        
    }
    
    private void helper(TreeNode root,int curSum)
    {
        if (root == null)
        { 
            return;
        }
    
    helper(root.left,10 * curSum + root.val);
    helper(root.right,10*curSum+root.val);
        
    if (root.left == null && root.right == null)
    {
        sum=sum + curSum * 10 + root.val;
    }
        
    }
}