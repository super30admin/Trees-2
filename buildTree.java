// Time Complexity : O(n)
// Space Complexity :O(n) 
class Solution {
    HashMap<Integer,Integer> hm;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder==null || preorder==null || inorder.length==0) return null;
        hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        
        return recurse(preorder,inorder,0,inorder.length-1);
    }
    
    private TreeNode recurse(int[] preorder, int[] inorder, int start, int end){
        //base case
        if(start>end){
            return null;
        }
        //logic
        int rootVal=preorder[idx++];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=hm.get(rootVal);
        root.left=recurse(preorder,inorder,start,rootIdx-1);
        root.right=recurse(preorder,inorder,rootIdx+1,end);
        return root;
        
    }
}