// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Definition for a binary tree node.
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

class Solution {
    HashMap<Integer, Integer> map; // global variable hashmap to store index of inorder elements
    int idx; // index counter of preorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>(); // initialise hashmap
        idx = 0; 
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // creating the hashmap and putting values of inorder
        }
        return recurse(preorder, 0, inorder.length - 1);
    }

    private TreeNode recurse(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        } // recursion got exhausted

        int rootVal = preorder[idx]; // getting the value of root, current node which we are working with
        idx++; // increment idx
        TreeNode root = new TreeNode(rootVal); // creating a tree node
        int rootIdx = map.get(rootVal); // getting index of that newly created node
        root.left = recurse(preorder, start, rootIdx - 1); // recursive function for left
        root.right = recurse(preorder, rootIdx + 1, end); // recursive function for right

        return root;
    }
}