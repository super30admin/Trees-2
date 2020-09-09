//Time Complexity: O(n^2)
//Space Complexity: O(n*n)with recursive stack - creating array size n for each tree node
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.Arrays;

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

public class Problem44 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0 || inorder.length==0)
            return null;

        //root is the last element in postorder 
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = -1;

        //finding root in inorder
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val)
                index = i;
        }



        //finding left part in both inorder and postorder
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        //finding right part in both inorder and postorder
        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, postorder.length-1);


        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;

    }
}