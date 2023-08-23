class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {

        if(root == null)
            return 0;
        System.out.println(root.val);
        helper(root,0);
        return sum;
    }

    private void helper(TreeNode root,int current)
    {

        if(root == null)
        {
            return;
        }

        if(root.left==null && root.right==null)
        {
            current=current*10+root.val;
            sum = sum+current;
        }
        else
        {

            current = current*10+root.val;
            helper(root.left,current);
            helper(root.right,current);
        }
    }
}