
class Solution {

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
    
    // Time complexity: O(N) N is size of array
    // Space complexity: O(H) H is the height of the tree
    // Did this code successfully run on Leetcode : Yes

    //Steps:
    /*
    1. The root node of the tree is the last element in postorder array.
    2. Based on the element in postorder array check for the same element in inorder array.
    3. Create left node as value from postorder array which has index (postStart + inIndex - inEnd - 1)
    and right node at index (postorder - 1)
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    private TreeNode helper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
     
        if(postStart < 0 || inStart > inEnd)
            return null;
        
        TreeNode node = new TreeNode(postorder[postStart]);
        
        int inIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == postorder[postStart])
                inIndex = i;
        }
        
        node.left = helper(postStart - (inEnd - inIndex + 1), inStart, inIndex - 1, inorder, postorder);
        node.right = helper(postStart - 1, inIndex + 1, inEnd, inorder, postorder);
        
        return node;
    }

    // Time complexity: O(N) N is number of nodes
    // Space complexity: O(H) H is the height of the tree
    // Did this code successfully run on Leetcode : Yes

    //Steps:
    /*
    1. As we traverse till leaf node, generate number by multiplying prev number by 1 and adding node value 
    to it.
    2. If the node is leaf node, add the number to result.
    */


    private int result = 0;
    public int sumNumbers(TreeNode root) {
        
        if(root == null)
            return 0;
        
        helper(root, 0);
        
        return result;
        
    }
    
    private void helper(TreeNode node, int num ) {
        
        if(node == null)
            return;
        
        if(node.left == null && node.right == null) {
            num = num*10 + node.val;
            result += num;
            return;
        }
        
        //logic
       
        helper(node.left, num*10 + node.val);
 
        helper(node.right, num*10 + node.val);
        
    }
}