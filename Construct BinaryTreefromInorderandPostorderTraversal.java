import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
 }
class Solution {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base
        if(preorder.length == 0) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(map, 0, inorder.length-1, preorder);

    }

    private TreeNode helper(HashMap<Integer, Integer> map, int start, int end, int[] preorder)
    {
        //base
        if(start > end) return null;

        //logic
        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(map, start, rootIdx-1, preorder);
        root.right = helper(map, rootIdx+1, end, preorder);

        return root;
    }
}
