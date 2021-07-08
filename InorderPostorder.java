// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was trying to construct the left side first and then right subtree but it appears we have to construct the right side first due to postorder array configuration.
/* Your code here along with comments explaining your approach: We are given inorder and postorder array => the last value of postorder array is root value.
Store the inorder array into a hashmap to maintain a relationship of element and index to have O(1) fetch in future. Create the tree node with
root value initially, fetch the root value index from the inorder hashmap store. Similarly, fetch all the node value indices as per you reach the nodes one by one.
Inorder array always tells us that the elements before root are left subtree and the elements after root are right subtree, and we know the root index. So we know that 
from 0 to index-1 is the left subtree, and from index+1 till the end is the right subtree. Recursively, fetch the nodes from the right subtree first index + 1 to end,
and then 0 to index -1 since its postorder traversal, the right subtree would be accesible in the postorder array to construct it first. Similarly,
recursively, divide the arrays in subarrays and perform the previous steps reptetively till postorder gets < 0.
*/
class Solution {
    int inPost;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0, inEnd = inorder.length-1;
        HashMap<Integer, Integer> store = new HashMap<>();
        for(int i = 0; i < inorder.length;i++){         
            store.put(inorder[i], i);                       // Map of inorder elements to its indices
        }
        
        inPost = postorder.length-1;                        // Root
        return constructTree(inorder, postorder, inStart, inEnd, store);
    }
    private TreeNode constructTree(int[] inorder, int[] postorder, int inStart, int inEnd,  HashMap<Integer, Integer> store){
        
        if(inPost < 0 || inStart > inEnd){return null;}                 // break condition
        TreeNode node = new TreeNode(postorder[inPost--]);              // Construct the nodes using the postorder array
        int index = store.get(node.val);                                // Fetch the inorder index
        node.right = constructTree(inorder, postorder, index+1, inEnd, store);          // Construct the right subtree first
        node.left = constructTree(inorder, postorder, inStart, index-1, store);             // Construct the left subtree recursively
        return node;
    }
}