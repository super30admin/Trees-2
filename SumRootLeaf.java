//time complexity:O(n)
//space complexity:O(h)
class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root, 0);
        return res;
    }
    private void helper(TreeNode root, int csum)
    {
        if(root==null) return;
        csum=csum*10+root.val;
        helper(root.left,csum);//inorder traversal
        
        if(root.left==null&& root.right==null)
        {
            res+=csum;//if the node is leaf node then add 
        }
        helper(root.right, csum);
    }
}
