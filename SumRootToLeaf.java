// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int total=0;
    public int sumNumbers(TreeNode root) {
        DFS(root,0);
        return total;
    }
    
    public void DFS(TreeNode root,int sum){
        if(root==null) return;
        sum = sum*10 + root.val;
        if(root.left==null && root.right==null){
            total += sum;
            return;
        }
        DFS(root.left, sum);
        DFS(root.right,sum);
    }
}
