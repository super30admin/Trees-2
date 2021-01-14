/**
 * Time complexity - O(n)
 * Space complexity - O(n+h)
 */
class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end)
    {
        if(start>end)
            return null;

        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int ridx = map.get(rootVal);
        root.right = helper(inorder, postorder, ridx+1, end);
        root.left = helper(inorder, postorder,start,ridx-1);

        return root;
    }
}