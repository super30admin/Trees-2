
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.HashMap;

public class ConstructBinaryTree {


  HashMap< Integer, Integer> map;
  int rInx =0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    this.map = new HashMap<>();

    for( int i=0; i <inorder.length; i ++){
      map.put(inorder[i],i);
    }

    TreeNode root = new TreeNode(preorder[0]);

    return helper(preorder, 0, inorder.length-1, 0);

  }

  public TreeNode helper(int[] preorder, int start, int end,int r ){

    if(start>end) return null ;

    int rootVal= preorder[rInx];

    rInx++;
    TreeNode root = new TreeNode(rootVal);

    r= map.get(rootVal);

    root.left = helper(preorder, start,r-1, r );
    root.right = helper(preorder, r+1, end, r );

    return root;

  }
}
