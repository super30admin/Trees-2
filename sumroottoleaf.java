/*
Time Complexity: Asymptotically O(n)
Space Complexity: O(n)
*/
class Solution {
    int ans=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }
    void helper(TreeNode root,int sum){
        if(root==null){
            return;
        }
        sum=sum*10+root.val;
        if(isLeaf(root)){
            ans+=sum;
            return;
        }
        helper(root.left,sum);
        helper(root.right,sum);
    }
    
    boolean isLeaf(TreeNode root){
        if(root.left==null&&root.right==null)return true;
        return false;
    }
}