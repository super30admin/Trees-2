// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// approach: took a hashmap to save the elements in order and fetch then O(1). created a helper function,
// took the last element as the root as it is postorder.took two pointers,start,end, moved to the right node keeping the end as same and start as root+1,
//then move to the left node keeping start as same and end as rootidx-1;

// Your code here along with comments explaining your approachx

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
    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx=inorder.length-1;
        this.map=new HashMap<>();
        for(int i=0;i<=inorder.length-1;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);

        
    }
    public TreeNode helper(int[] preorder, int start,int end)
    {
        if(start>end) return null;
        int rootval=preorder[idx];
        idx--;

        int rootidx=map.get(rootval);
        TreeNode root=new TreeNode(rootval);
        root.right=helper(preorder,rootidx+1,end);
        root.left=helper(preorder,start,rootidx-1);
        return root;

    }
}