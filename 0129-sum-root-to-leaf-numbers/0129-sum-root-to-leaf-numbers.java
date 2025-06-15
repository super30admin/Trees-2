/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
Approach:
This problem involves summing all numbers formed by root-to-leaf paths in a binary tree.
Each path represents a number formed by concatenating node values (from root to leaf).
We perform a depth-first-traversal(dfs), passing the number formed so far as we traverse down.
At each node, we multiply the currentnumber by 10 and add the node's value.
Once we reach a leaf node(both children are null), we return the number formed.
For non-leaf nodes, we recursively compute the sum from left and right subtrees.
The final resultis the sum of all root-to-leaf numbers.

Time Complexity:O(n), where n is the number of nodes in the tree
We visit every node exactly once.

Space Complexity: O(h), where h is the height of the tree.
This is the recursive stack space and used in depth-first traversal

*/

//Definition for a binary tree node.
public class TreeNode{
    int val;//value of the node
    TreeNode left;//left child
    TreeNode right;//right child

    TreeNode(){} //default constructor

    TreeNode(int val) {//constructor with value
        this.val =val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right){//Construct with value, left and right children
        this.val = val;
        this.left = left;
        this.right = right;

    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        //Start DFS with the root node and initial current number as 0
        return helper(root,0);
    }

    private int helper(TreeNode root, int currNum){
        //Base case: If current number is null, return 0, no number to contribute
        if(root == null) return 0;

        //Update the current number by shifting digits left(*10) and adding current node's value
        currNum = currNum*10 + root.val;

        //If w ehave reached a leaf node(no left or right child), return the number formed so far
        if(root.left == null && root.right == null){
            return currNum;
        }

        //Recursively calculate the sum from the left and right subtrees
        int left = helper(root.left, currNum); //DFS on left subtree
        int right = helper(root.right, currNum); //DFS on right subtree

        //Return the total sum from both subtrees
        return left+right;        
    }
}