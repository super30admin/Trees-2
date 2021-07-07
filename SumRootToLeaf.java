/*
Author: Akhilesh Borgaonkar
Problem: LC 129. Sum Root to Leaf Numbers Traversal (Trees-2)
Approach: Using iterative approach here. Maintaining a stack to track the next TreeNode in the sequence and the sum of the node values until its 
    parent. Whenever a child node is found then add the sum of value until parent and current node and add it to the total sum. 
Time Complexity: O(n) where n is number of total nodes in the Binary Tree.
Space complexity: O(log h) where h is height of the binary tree at any given time.
LC verified.
*/

import javafx.util.Pair;
class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode currNode = curr.getKey();
            Integer currVal = curr.getValue();
            
            if(currNode != null){
                if(currNode.left == null && currNode.right == null){
                    sum += currVal*10 + currNode.val;
                }
                stack.push(new Pair(currNode.left, 10*currVal + currNode.val));
                stack.push(new Pair(currNode.right, 10*currVal + currNode.val));
            }
        }
        return sum;
    }
}