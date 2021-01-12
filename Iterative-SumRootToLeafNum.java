//Problem 46 : Sum Root to Leaf Numbers
// Time Complexity : O(N), N stands for number of nodes
// Space Complexity : O(H), H stands for height of the tree, in worst case it can be O(N) if it is a skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Iterative : As it is similar to the preorder traversal, I implemented it using stack. Here as I have to calculate the sum root to leaf, so I created a class called RootSumPair, where I'm maintaning the node and the sum for each node so that I can calculate the sum when ever the node is popped and then pushing that sum to the stack along with the next node. Whenever there is a leaf node(a node with no children), then I'm adding the sum to the totalSum which is the global variable.

Here while iterating over stack I'm inserting right node first then left because stack uses a concept of LIFO and I wanted to calculate the sum for left node first.
*/

import java.util.*;

class Solution46Iterative {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    class RootSumPair{
        private TreeNode root;
        private int sum;
        RootSumPair(TreeNode root,int sum){
            this.root = root;
            this.sum = sum;
        }
     }     

    private Integer totalSum;
    public int sumNumbers(TreeNode root) {

        if(root==null){
            return 0;
        }

        totalSum =0;
        iterativePathSum(root);
        
        return totalSum;
    }
    
    
    private void iterativePathSum(TreeNode root){
        
        Stack<RootSumPair> stack = new Stack<>();
        stack.push(new RootSumPair(root,0));
        
        while(!stack.isEmpty()){
            RootSumPair rootSumPair = stack.pop();
            
            rootSumPair.sum = rootSumPair.sum*10+rootSumPair.root.val;
            
            if(rootSumPair.root.right!=null){
                stack.push(new RootSumPair(rootSumPair.root.right,rootSumPair.sum));
            } 
            
            if(rootSumPair.root.left!=null){
                stack.push(new RootSumPair(rootSumPair.root.left,rootSumPair.sum));
            }
            
            if(rootSumPair.root.left==null && rootSumPair.root.right==null){
                totalSum += rootSumPair.sum;
            }   
        }
        
    }
}