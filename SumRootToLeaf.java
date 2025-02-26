public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode curr,int total){
        if(curr == null) return 0;
        if(curr.right == null && curr.left == null) return total*10 + curr.val;
        return sum(curr.left,total*10 + curr.val) + sum(curr.right,total*10 + curr.val);
    }
}
