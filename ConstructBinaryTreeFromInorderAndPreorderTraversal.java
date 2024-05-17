// Time Complexity: O(totalNodes^2) [recursion will take 'n' time and for every recursion there is a for loop iterating through array which will abso be 'n']
// Space Complexity: O(totalNodes^2) [recursion will take 'n' space and for every recursion there is a deep copy happening for same array so it will also be 'n']

// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

/**
 * Definition for a binary tree node.
 */
class Node {
    int val;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreeFromInorderAndPreorderTraversal {
    // Time Complexity: O(totalNodes^2) [recursion will take 'n' time and for every recursion there is a for loop iterating through array which will abso be 'n']
    // Space Complexity: O(totalNodes^2) [recursion will take 'n' space and for every recursion there is a deep copy hapening for same array so it will also be 'n']
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // null check
        if(preorder.length == 0) {
            return null;
        }

        // logic
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal); // root is ready
        int idx = -1; //this will be inorder array index where root value is

        // find rootValue index from inorder array
        for(int i = 0; i < inorder.length; i++){
            if(rootVal == inorder[i]){
                idx = i;
            }
        }

        // now make inroderLeft array and inorder right array, this will be left and right side childrens
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inorderRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        // now make preorderLeft array and preorderRight array, it will give us next root node
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length + 1, preorder.length);

        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;

    }

}
