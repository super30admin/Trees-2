//time complexity: O(n)
//Space Complexity O(h) h = height of the tree
//Ran on leetcode and accepted 
class Solution 
{
    public int sumNumbers(TreeNode root) 
    {
        //A function to calculate the sum that takes the root and the order as input
        return sum(root, 0);
    }
    
    public int sum(TreeNode n, int order)
    {
        //If the root node itself is null return 0
        if(n == null) return 0;
        //If there is no left and right leaf of the given node
        if(n.right == null && n.left == null)
        {
            //calculate sum
          int x = order*10+n.val;//calculates the sum which is node + order * 10 
          //return x
          return x;
        }
        int x = order*10+n.val;
        //Passing order x(root) and left node to sum and order x(root) and right node to sum and adding the 2 results
        return sum(n.left, x) + sum(n.right, x);//(x*10+n.left.val) + (x*10+n.right.val)
    }
}