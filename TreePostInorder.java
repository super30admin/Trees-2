// Time Complexity : O(N)
// Space Complexity : O(N_
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class TreePostInorder {
    Map<Integer,Integer> map = new HashMap<>();
    int postOrderIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==1)
            return new TreeNode(postorder[0]);
        
        int index = 0;
        for(int num : inorder)
            map.put(num,index++);
        
        postOrderIndex = postorder.length-1;
        
        return construct(postorder,0 , postorder.length-1);
    }
    
    public TreeNode construct(int[] postorder, int start, int end) {
        //System.out.println(start +" -> "+end);
        if(start>end)
            return null;
        
        TreeNode root = new TreeNode(postorder[postOrderIndex--]);
        int inIndex = map.get(root.val);
        //System.out.println(inIndex);
        
        root.right = construct(postorder, inIndex+1, end);
        root.left = construct(postorder, start, inIndex-1);
        
        return root;
    }
}
