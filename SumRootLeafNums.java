// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class SumRootLeafNums {
    public int sumNumbers(TreeNode root) {
        return calcSum(root, 0, 0);
    }

    public int calcSum(TreeNode root, int num, int sum){
        if(root==null){
            return 0;
        }

        num = num*10 +root.val;
        if(root.left == null && root.right == null){
            sum += num;
            return sum;
        }

        int rsum = calcSum(root.left, num, sum);
        int lsum = calcSum(root.right, num, sum);

        return rsum+lsum;
    }
}
