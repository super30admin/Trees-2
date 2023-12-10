// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.Arrays;

class Sample {

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    if(preorder.length ==0 && inorder.length== 0) return null;

    TreeNode root = new TreeNode();
    root.val = preorder[0];

    int r= 0;
    for (int i=0; i<inorder.length; i++){
      if(root.val== inorder[i]){
        r=i;
      }
    }

    int[] lIn = Arrays.copyOfRange(inorder,0,r);
    int[] rIn = Arrays.copyOfRange(inorder,r+1,inorder.length);
    int[] lPr = Arrays.copyOfRange(preorder,1,lIn.length+1);
    int[] rPr = Arrays.copyOfRange(preorder,lIn.length +1,preorder.length);

    root.left=buildTree(lPr,lIn);
    root.right=buildTree(rPr,rIn);

    return root;

  }
}