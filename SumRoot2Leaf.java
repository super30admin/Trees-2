//Time Complexity O(n)
//Space Complexity O(h)
//Leetcode tested

public class SumRoot2Leaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root,int num){
        if(root==null) return;
        num=num*10+root.val;
        helper(root.left,num);
        if(root.left==null && root.right==null){
            sum+=num;
        }
        helper(root.right,num);
    }
}
