public class SumRootToLeaf {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;

    }
    private void helper(TreeNode root,int currNum){
        if(root == null) return;
        currNum = currNum*10 + root.val;
        System.out.print(root.val);
        System.out.println(currNum);
        if(root.left == null && root.right == null){
            result+=currNum;
        }
        helper(root.left,currNum);
        helper(root.right,currNum);
    }
}
