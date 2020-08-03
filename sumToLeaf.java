//Time complexity: O(number of nodes)
//Space Complexity: O(height of tree)
//executed on leetcode: yes

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

//---------------------------- Iterative Solution

// we are defining a class Pair since we need to store both root and sum upto that point in the stack
/**
class Solution {
class Pair
{
    TreeNode root;
    int current_sum;
    public Pair(TreeNode root, int current_sum)
    {
        this.root=root;
        this.current_sum=current_sum;
    }
    public TreeNode getRoot()
    {
        return root;
    }
    public int getCurrentSum()
    {
        return current_sum;
    }
}
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0; //if tree is empty
        Stack<Pair> stack = new Stack<Pair>();
        int total = 0;
        int current_sum = 0; //sum upto that root node
        while(!stack.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                current_sum = (current_sum*10) + root.val;
                stack.push(new Pair(root,current_sum));
                root=root.left;
            }
            Pair p = stack.pop();
            /** this is a mistake as we are adding extra current sum values while traversing, we need to add current_sum to total only when we are at leaf nodes
            current_sum = p.getCurrentSum();
            System.out.println("current_sum"+current_sum);
            total+= current_sum;
             System.out.println("total"+total);
            root = p.getRoot();
            System.out.println("root"+root.val);
            **/
/**
            root=p.getRoot();
            current_sum = p.getCurrentSum(); // if we remove this line of code, current_sum wont get updated properly and you will get wrong total
            if(root.left==null && root.right==null)
            {
                total = total + p.getCurrentSum();
                System.out.println("total="+total);
            }
            root=root.right;
        }
        return total;
    }
}
**/

//--------------recursive solution

class Solution {
    
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0; //if tree is empty
        return helper(root,0);
    }
    public int helper(TreeNode root,int current_sum)
    {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return current_sum*10+root.val;  
        //if we return only current_sum, it will return the value upto the previous node of the root
        return helper(root.left,current_sum*10+root.val) + helper(root.right,current_sum*10+root.val); 
    }
}


