class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root==null){
            return 0;
        }


        helper(root,0);
        return sum;
    }

    void helper(TreeNode root,int num){
        num = num*10+root.val;
        if (root.left!=null){
            helper(root.left,num);
        }
        if (root.right!=null){
            helper(root.right,num);
        }

        if (root.right==null&&root.left==null){
            sum+=num;
        }

    }

}
SC:O(n)
TC:O(n)
