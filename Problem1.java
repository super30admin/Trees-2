class Solution {
    HashMap<Integer,Integer>map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0)
        {
            return null;
        }
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++)
        {
            map.put(inorder[i],i);
        }
        this.idx = postorder.length-1;
        return CreateTree(inorder,postorder,0,inorder.length-1);
    }

    private TreeNode CreateTree(int[] inorder,int[] postorder,int start,int end){
        if(start>end){
            return null;
        }
         
        int rootValue = postorder[this.idx];
        this.idx--;

        TreeNode node = new TreeNode(rootValue);
        int rootIdx = map.get(rootValue);
        node.right = CreateTree(inorder,postorder,rootIdx+1,end);
        node.left = CreateTree(inorder,postorder,start,rootIdx-1);
       
        return node;
    }
}
