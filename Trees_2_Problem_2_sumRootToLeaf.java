//Time Complexity : O(n) (We'll be traversing through the whole tree once)
//Space Complexity : O(1) (Stack space because of the recursion which maximum will be h (height of the tree))
//Runs successfully on leetcode
//Problem : No problem

//We will be reaching each leaf nodes and add its sum to the global variable


public class Trees_2_Problem_2_sumRootToLeaf {
    int total = 0 ;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return total;
    }
    public void helper(TreeNode root,int sum)
    {
        if(root == null) return;

        sum = sum * 10 + root.val;
        if(root.left == null && root.right ==null )
        {
            total = total + sum;
        }


        helper(root.left,sum);
        helper(root.right,sum);
    }
}
