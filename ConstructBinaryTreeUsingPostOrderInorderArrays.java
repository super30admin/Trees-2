
import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

// Approach:  Postorder traversal of binary tree is  left, right, root and Inorder traversal is left, root, right.
//Postorder last element is root and then seek the root element inorder by searching the map which  contains element and
// its position as key values. Construct the binary tree by calling recursively buildTree method to  construct both right
// and let trees
class ConstructBinaryTreeUsingPostOrderInorderArrays {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(inorder==null||postorder==null)return null;
        if(n!=postorder.length)return null;
        index = postorder.length-1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
        return constructTree(inorder, 0, n-1, postorder, map);

    }

    public TreeNode constructTree(int[] inorder, int start, int end, int[] postorder,   Map<Integer,Integer> map) {
        if(start > end) return null;

        int nodeVal = postorder[index--];
        int inorderNodeIndex = map.get(nodeVal);

        TreeNode root = new TreeNode(nodeVal);
        root.right = constructTree(inorder, inorderNodeIndex+1, end, postorder,  map);
        root.left = constructTree(inorder, start, inorderNodeIndex-1,  postorder,  map);
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
