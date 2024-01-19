//Accepted on LT
// So the idea is to just go till end of till leaf and add it up in toal.
class Solution {
    int total;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return total;
        
    }
    public void helper(TreeNode root,int cr){
        //base
        if(root==null) return;

        //logic
        cr = cr*10 + root.val;
        if(root.left == null && root.right==null){
            total = total + cr;
        }
        helper(root.left,cr);
        helper(root.right,cr);
    }
}