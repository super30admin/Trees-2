import java.util.HashMap;

//TC-O(N)^2 and SC-O(N). If hashmap is used  TC-O(N)
public class ConstrustBTFromInorderPostOrder {
    int idx;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build a map for quick lookup of inorder index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        idx=postorder.length-1;
        return helper(inorder,postorder,0,postorder.length-1);

    }
    public TreeNode helper(int[] inorder, int[] postorder,int start,int end){
        if(start>end) return null;


        // Get the root value from the postorder array
        int rootVal = postorder[idx--];

        // Create the root node
        TreeNode root = new TreeNode(rootVal);

        int rootIdx=0;

        // Get the index of the root value in the inorder array from the map
        rootIdx = inorderMap.get(rootVal);

        //get the root position in the inorder
        //     for (int i = start; i <= end; i++) {
        //      if (inorder[i] == rootVal) {
        //          rootIdx = i;
        //          break;
        //      }
        //  }
        // Recursively build the right subtree (because we're going from right to left in postorder)
        root.right = helper(inorder, postorder, rootIdx + 1, end);

        // Recursively build the left subtree
        root.left = helper(inorder, postorder, start, rootIdx - 1);

        return root;
    }
    public class TreeNode {
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
}


