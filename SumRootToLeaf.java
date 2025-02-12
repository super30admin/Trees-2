class SumRootToLeaf {
    private int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }

    public void helper(TreeNode root,int cur)
    {
            if(root == null)
            return;
            
            cur = cur*10+root.val;
            if(root.left == null && root.right==null)
            {
                sum+=cur;
            }
            System.out.println("cur "+cur);
            helper(root.left,cur);
            helper(root.right,cur);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(h)