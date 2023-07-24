package BST;// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class BTFromInAndPostOrder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int postOrderIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;

        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i],i);
        }
        postOrderIdx = postorder.length-1;
        return helper(postorder, 0, postorder.length-1);
    }
    public TreeNode helper(int[] postorder, int start, int end )
    {
        if(start > end) return null;

        int rootVal = postorder[postOrderIdx];
        postOrderIdx--;

        TreeNode node = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        node.right = helper(postorder,  rootIdx+1, end);
        node.left = helper(postorder,  start, rootIdx-1);

        return node;
    }
}
