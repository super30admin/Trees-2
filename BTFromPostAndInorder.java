// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.HashMap;

public class BTFromPostAndInorder {
    HashMap<Integer,Integer> hmap = new HashMap<>();
    int postorderidx ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderidx = postorder.length-1 ;
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        int end = inorder.length-1, start =0;
        return buildBTree(start, end, postorder);
    }

    public TreeNode buildBTree(int start, int end, int[] postorder){
        if(start > end ){
            return null;
        }

        int val = postorder[postorderidx--];
        TreeNode root = new TreeNode(val);
        int inorderIdx = hmap.get(val);

        root.right = buildBTree(inorderIdx+1, end, postorder);
        root.left = buildBTree(start,inorderIdx-1,postorder);
        return root;
    }
}
