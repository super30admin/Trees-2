// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
////Method 1- Using HashMap and 2 pointers and avoiding creating new array each time
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

        idx = postorder.length -1;
        //null check
        if(postorder == null || postorder.length == 0)
            return null;

        map = new HashMap<>();

        for(int i = 0 ; i< inorder.length ; i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder,int start, int end){

        //base case
        if(start > end)
            return null;

        //logic


        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);
        idx--;

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder,rootIdx+1,end);
        root.left = helper(postorder,start,rootIdx-1);

        return root;
    }
}
