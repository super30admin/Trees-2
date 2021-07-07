//Time complexity:O(n)
//Space Complexity:O(n)

class Solution {
    int i;
    Map<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i=postorder.length-1;
        for(int j=0;j<postorder.length;j++){
            map.put(inorder[j],j);
        }
        return helper(inorder,postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] inorder,int[] postorder,int start,int end){
        if(start>end || i<0){
            return null;
        }
        TreeNode root=new TreeNode(postorder[i]);
        int idx=map.get(root.val);
        i--;
        
        root.right=helper(inorder,postorder,idx+1,end);
        root.left=helper(inorder,postorder, start,idx-1);
        return root;
    }
}