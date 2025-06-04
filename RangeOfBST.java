//Range of BST - Void based Non conditional Recursion
class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag =true;
        helper(root, null, null);
        return flag;
        
    }

    private void helper(TreeNode root, Integer low, Integer high){
        //base
        if(root == null) return;

        //logic
        //breach
    
        if((low != null && root.val <= low) || (high != null && root.val >= high)){ // this check is at preorder level
            flag= false;
        }

       
        helper(root.left, low, root.val);
        //st.pop();
        helper(root.right, root.val, high);
        //st.pop();
    }
}

//Range of BST - Void based Conditional Recursion
class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag =true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer low, Integer high){
        //base
        if(root == null) return;

        //logic
        //breach
    
        if((low != null && root.val <= low) || (high != null && root.val >= high)){ // this check is at preorder level
            flag= false;
        }
        if(flag){       //conditional recursion
            helper(root.left, low, root.val);
        }

        helper(root.right, root.val, high);

    }
}