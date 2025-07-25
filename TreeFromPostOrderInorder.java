// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : create a map for inorder nodes and their index. In post order we know that we visit left subtree, right
/// subtree and then root. So last element in postorder is the root, find it's index in inorder map and recursively
/// call the helper function of start to rootIdx-1 (this will be root's left subtree) and then rootIdx to end
///  (root's right subtree)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        idx = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1, map);
    }
    public TreeNode helper(int postorder[], int start, int end, HashMap<Integer, Integer> map)
    {
        if(idx<0 || start>end){
            return null;
        }
        System.out.println(idx+" "+postorder[idx]);
        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map.get(rootVal);
        System.out.println(rootVal+" "+rootIdx+" "+start+" "+end+" "+(idx+1));
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, 1+rootIdx, end, map);
        root.left = helper(postorder, start, rootIdx-1, map);
        
        return root;
    }
}