import java.util.HashMap;

import javax.swing.tree.TreeNode;
// Idea is to find the root in postorder traversal and based on it, find the right sub tree and left sub tree.
// This finding of right sub tree and left sub tree is optimised by using HashMap
// Once the node is built, we recursively build left and right sub trees.

//Time Complexity:O(n)
//Space Complexity:O(n)
public class constructBtrees {
        int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<inorder.length;i++)
      {
        map.put(inorder[i],i);
      }  
      this.idx = postorder.length-1;
      return traversal(postorder,0,postorder.length-1,map);
    }

    private TreeNode traversal(int[] postorder, int start, int end, HashMap<Integer,Integer> map)
    {
        if(start>end) return null;
        System.out.println(start+","+end+","+idx);
        int rootVal = postorder[idx];
        idx--;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.right = traversal(postorder, rootIdx+1,end,map);
        root.left = traversal(postorder, start, rootIdx-1, map);
        

        return root; 
    }
}
