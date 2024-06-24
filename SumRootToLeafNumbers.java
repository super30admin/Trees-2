//Approach - recursive
//time - O(n), space - O(h)
class SumRootToLeafNumbers {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            sum = sum + num * 10 + root.val;
        }

        helper(root.left, num*10+root.val);

        helper(root.right, num*10+root.val);
    }
}
