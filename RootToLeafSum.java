/**

LeetCode: 129. Sum Root to Leaf Numbers

https://leetcode.com/problems/sum-root-to-leaf-numbers/
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Collabedit: http://collabedit.com/8j6tv

This question is an application of preorder traversal

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    int totalSum = 0;
    
    
    public int sumNumbers(TreeNode root) 
    {
        //computeSumRecursive(root, 0);
        
        computeSumIterative(root);
        
        return totalSum;
    }
    
    private void computeSumRecursive( TreeNode root, int currentSum)
    {
        if(root == null) return;
        
        if( root.left == null && root.right == null )
        {
            totalSum  = totalSum + currentSum*10 + root.val;
            return;
        }
        
        computeSumRecursive(root.left, currentSum*10 + root.val);
        computeSumRecursive(root.right, currentSum*10 + root.val);
    
    }
    
    private void computeSumIterative(TreeNode root)
    {
        Stack<Pair> stack = new Stack<>();
        int currentSum = 0;
        
        while( root!=null || !stack.isEmpty() )
        {
            while(root != null)
            {
                currentSum = currentSum*10 + root.val;
                stack.push(new Pair(currentSum, root));
                
                root = root.left;
            }
            
            
            Pair pair = stack.pop();
            
            currentSum = pair.sum;
            TreeNode current = pair.node;
            
            if( current.left == null && current.right == null)
            {
                totalSum = totalSum + currentSum;
            }
            
            root = current.right;
        
        }
    }
}
class Pair
{
    public int sum;
    public TreeNode node;
    
    public Pair(int sum, TreeNode node)
    {
        this.sum = sum;
        this.node = node;
    }
}










