//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode helper(int []inorder,int si,int ei,int[] postorder,int ps,int pe){
        if(si>ei)
            return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int idx=si;
        while(idx<inorder.length && inorder[idx]!=postorder[pe])
            idx++;
        int count=idx-si;
        root.left=helper(inorder,si,idx-1,postorder,ps,ps+count-1);
        root.right=helper(inorder,idx+1,ei,postorder,ps+count,pe-1);
        return root;

    }
}
