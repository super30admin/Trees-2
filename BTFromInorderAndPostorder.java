// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

import java.util.HashMap;

public class BTFromInorderAndPostorder {



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

    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] postOrder, int[] inorder) {
        this.idx=inorder.length-1;
        this.map= new HashMap();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(postOrder,0,inorder.length-1);

    }

    private TreeNode helper(int[] postOrder, int start, int end) {
        if(start>end) return null;

        int rootVal=postOrder[idx];
        idx--;
        int rootIdx=map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);


        root.right= helper(postOrder,rootIdx+1, end);
        root.left=helper(postOrder, start, rootIdx-1);

        return root;

    }


    }


