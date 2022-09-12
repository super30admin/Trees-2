/* Time Complexity:O(N)
Space Complexity:O(N)
*/
class Solution
{
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return postOrIn(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode postOrIn(int[] post,int psi,int pei,int[] in,int isi,int iei){
        if(isi>iei){
            return null;
        }
        
        int idx=isi;
        while(in[idx]!=post[pei]){
            idx++;
        }
        
        int tel=idx-isi;
        TreeNode root=new TreeNode(post[pei]);
        
        root.left=postOrIn(post,psi,psi+tel-1,in,isi,idx-1);
        root.right=postOrIn(post,psi+tel,pei-1,in,idx+1,iei);
        
        return root;
    }
}
