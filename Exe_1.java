class Solution {
    private int i;
    private int[] postorder;
    private int[] inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length-1;
        this.inorder=inorder;
        this.postorder=postorder;
        return buildTree(0, inorder.length-1);
    }
    public TreeNode buildTree(int s, int e){
        if(s>e){
            return null;
        }
        
        TreeNode n = new TreeNode(postorder[i]);
        --i;
        int ii = search(inorder,s,e,n.val);
        n.right = buildTree(ii+1, e);
        n.left = buildTree(s, ii-1);
        return n;
    }
    private int search(int[] arr,int s,int e,int x){
        for(int y=s;y<=e; ++y){
            if (arr[y]==x){
                return y;
            }
        }
        return -1;
    }
}
//tc=O(n^2)
//sc=O(n)
