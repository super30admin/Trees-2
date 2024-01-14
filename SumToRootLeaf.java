import java.util.Stack;

/** Recursion */
// Time Complexity : O(n) n is number of nodes in binary tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

/** Iterative */
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N
public class SumToRootLeaf {
    
     int result = 0;
    public int sumNumbers(TreeNode root) {
        //helper(root, 0);
        //return result;
        //return helper(root, 0);
        return helper(root);
    }

    // recursion way void
    /*public void helper(TreeNode root, int currNum)
    {
        //base
        if(root == null)
            return;

        currNum = currNum*10 + root.val  ;
        if(root.left == null && root.right == null)
        {
            result = result+currNum;
        }
        helper(root.left,currNum);
        helper(root.right,currNum);  

    }*/

    //recursion way int
    public int helper(TreeNode root, int currNum)
    {
        //base
        if(root == null)
            return 0;

        currNum = currNum*10 + root.val  ;
        if(root.left == null && root.right == null)
        {
           return currNum;
        }
       
        return helper(root.left,currNum) + helper(root.right,currNum);
        

    }
     // iterative way
    public int helper(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int result = 0;
        int currNum = 0;
       
        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
                stack.push(root);
                 currNum = currNum * 10 + root.val;
                num.push(currNum);
                root = root.left;
            }
           root = stack.pop();
           currNum = num.pop();
           if(root.left == null && root.right == null)
           {
               result = result+currNum;
           }
           root = root.right;
        }
        return result;
        

    }
    public static void main(String [] args)
    {
        SumToRootLeaf bst = new SumToRootLeaf();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Function call
        System.out.println(bst.sumNumbers(root));
    }
}
