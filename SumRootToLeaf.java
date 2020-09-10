/*
 * #129. Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
  
Output: 25

Explanation:

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1

Output: 1026

Explanation:

The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

 */

/*
 * Time Complexity: O (N) -> To traverse 'N' number of nodes in a tree
 * 
 * Space Complexity w/o recursive stack: O (1)
 * 
 * Space Complexity with recursive stack: O (max depth/length of a branch) -> Since, not all nodes of a tree will be present at same time in stack, once left and right subtree of a node is traversed, it will be popped from stack
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees2;


//Definition for a binary tree node.
class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1() {}
	TreeNode1(int val) { this.val = val; }
	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
     }
 }


public class SumRootToLeaf {
	public int sumNumbers(TreeNode1 root) {
        // Call the "recurr" function initially with root=4 and curr=0
        recurr(root, 0);
        return output; // When control is returned back from "recurr" function after traversing all branches of a tree, return the output.
    }
    
    private int output = 0; // Initialize the output
    
    // Function to traverse the tree branches and compute sum of root-to-leaf numbers 
    public void recurr(TreeNode1 root, int prev){
        //Base Case
        
        if(root == null){
            return; // Do nothing 
        }
        
        /*
        * e.g: In input, 4 -> 49
        * To get 49 from 4, we do 4 * 10 + 9
        */
        int curr = prev * 10 + root.val;
        
        // If we reached the leaf node
        if(root.left == null && root.right == null){
            output += curr; // Add the previous root-to-leaf number to the current
            return; // return the control to recursive calls for left and right of root
        }
        
        // Recursive case
        // recursive call on left of current node
        recurr(root.left, curr);
        // recursive call on right of current node
        recurr(root.right, curr);
        
        /*
        * When we are done traversing all the nodes/branches of a tree
        * the recursive stack will be empty and control will be returned to "sumNumbers" function which will return the output -> sum of all root-to-leaf branches numbers
        */
    }
    
}
