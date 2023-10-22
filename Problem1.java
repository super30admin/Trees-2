// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int pix = postorder.length-1;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(pix,0,pix,postorder);
    }
    private TreeNode helper(int pix,int ileft,int iright,int[] postorder){
        int current = postorder[pix];
        TreeNode root = new TreeNode(current);
        int mid = map.get(current);
        if(ileft < mid)
            root.left = helper(pix-(iright-mid+1),ileft,mid-1,postorder);
        if(iright > mid)
            root.right = helper(pix-1,mid+1,iright,postorder);
        return root;
    }
}