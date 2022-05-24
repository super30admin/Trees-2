//Construct Binary Tree from Inorder and Postorder Traversal
//Time Complexity : O(N)
//Space Complexity : O(N)
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
public TreeNode buildTree(int[] inorder, int[] postorder) {
  return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
}

private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
      int postStart) {
  if (postStart < 0 || inStart < inEnd)
      return null;
  
  //The last element in postorder is the root.
  TreeNode root = new TreeNode(postorder[postStart]);
  
  //find the index of the root from inorder. Iterating from the end.
  int rIndex = inStart;
  for (int i = inStart; i >= inEnd; i--) {
      if (inorder[i] == postorder[postStart]) {
          rIndex = i;
          break;
      }
  }
  //build right and left subtrees. Again, scanning from the end to find the sections.
  root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
  root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
  return root;
}
}


//Sum Root to Leaf Numbers
//Time Complexity : O(N)
//Space Complexity : O(H)
class Solution2 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return sum;
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root, int curr){
        if(root==null) return;
        // if it is a leaf
        if(root.left==null && root.right==null){
            //add to previous sum and value of the root
            sum=sum+curr*10+root.val;
            return;
        }
        //if not left move to leaf and keep updating current sum
        helper(root.left,curr*10+root.val);
        helper(root.right,curr*10+root.val);
    }
}