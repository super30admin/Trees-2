class Solution {
    int postIndex;
    HashMap<Integer, Integer> map ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length -1;
         map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, 0, postorder.length-1);   
    }
    
    private TreeNode helper(int[] postorder, int left, int right){
        if(left > right)
            return null;
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        postIndex--;
        root.right = helper(postorder, map.get(rootVal)+1,right);
        root.left = helper(postorder, left, map.get(rootVal)-1);
        return root;
    }
}



class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //null case
        int n = postorder.length-1;
        if(postorder == null || postorder.length == 0) return null;
        int rootval = postorder[n];
        TreeNode root = new TreeNode(rootval);
        //find root in inorder
        int index = -1;
        for(int i=0; i< inorder.length;i++){
            if(inorder[i] == rootval){
                index = i;
                break;
            }
        }
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder,index,  n);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] postLeft = Arrays.copyOfRange(postorder, 0,index);
        //recurssive
        root.right = buildTree(inRight, postRight);
        root.left = buildTree(inLeft, postLeft);
        return root;
    }
}
