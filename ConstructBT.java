/*
106. Construct Binary Tree from Inorder and Postorder Traversal - MEDIUM
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

TC: O(n) - all elements in the post/in order array
SC: O(h)+O(n) ~ O(n) - stack space + new arrays

Approach: The last element in the postorder traversal is the root of the tree.
All elements to the left of this node in inorder forms the left subtree,
and all elements to the right of this node in inorder forms the right subtree.
Recurse till all elements in the array are visited
*/

public class ConstructBT {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSum(root, 0);
    }
    
    public int getSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int currSum = sum*10 + root.val;
        
        if (root.left == null && root.right == null) {
            return currSum;
        }
        
        return getSum(root.left, currSum) + getSum(root.right, currSum);
    }
}
