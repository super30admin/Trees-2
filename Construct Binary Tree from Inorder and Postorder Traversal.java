/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// T: O(N)
// S: O(N)

// Beata 93% of the Leetcode submissions


// take the last element in postorder array as the root, find the position of the root in the inorder array; 
// then locate the range for left sub-tree and right sub-tree and do recursion. Use a HashMap to record the index of 
// root in the inorder array.


class Solution {
    
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        for(int i = 0; i < inorder.length; i++){
            
            map.put(inorder[i], i);
        }
        
        return buildTree(postorder, postorder.length - 1, 0, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd){
        
        if(postStart < postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postStart]);
        
        int rootInInorder = map.get(postorder[postStart]);
        
        int numDiff = rootInInorder - inStart;
        
        root.left = buildTree(postorder, postEnd + numDiff - 1, postEnd, inorder, inStart, rootInInorder - 1);
            
        root.right = buildTree(postorder, postStart - 1, postEnd + numDiff, inorder, rootInInorder + 1, inEnd);
        
        return root;
    }
}


//Itreative Solution

// The core idea is: Starting from the last element of the postorder and inorder array, we put elements from postorder array to a stack and each one is the right child 
// of the last one until an element in postorder array is equal to the element on the inorder array. Then, we pop as many as elements we can from the stack and decrease 
// the mark in inorder array until the peek() element is not equal to the mark value or the stack is empty. Then, the new element that we are gonna scan from postorder array 
// is the left child of the last element we have popped out from the stack.



public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) return null;
    int ip = inorder.length - 1;
    int pp = postorder.length - 1;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    TreeNode root = new TreeNode(postorder[pp]);
    stack.push(root);
    pp--;
    
    while (pp >= 0) {
        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
            prev = stack.pop();
            ip--;
        }
        TreeNode newNode = new TreeNode(postorder[pp]);
        if (prev != null) {
            prev.left = newNode;
        } else if (!stack.isEmpty()) {
            TreeNode currTop = stack.peek();
            currTop.right = newNode;
        }
        stack.push(newNode);
        prev = null;
        pp--;
    }
    
    return root;
}