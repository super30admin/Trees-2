import java.util.*;

public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        SumRootToLeafNumbers.TreeNode left;
        SumRootToLeafNumbers.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    int sum;
    public int sumNumbers(TreeNode root) {
    /*

    TC:O(n)
    SC:O(height) -> O(n)

    */
        if(root==null) return 0;
        sum=0;
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int currSum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            currSum=currSum*10+root.val;
            sum+=currSum;
            return;
        }
        dfs(root.left,currSum*10+root.val);
        dfs(root.right,currSum*10+root.val);
    }
}
