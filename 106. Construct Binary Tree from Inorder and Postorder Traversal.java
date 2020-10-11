class Solution {//class time and space of O(n)
    int pre_index ;
    int[] inorder;
    int[] postorder; 
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inorder = inorder ;
    this.postorder = postorder;
    this.pre_index = postorder.length-1;
    //creating hmap for inorder val and indices
    int idx =0 ;
    for(int val: inorder){
        map.put(val,idx++);
    }
   return helper(0,inorder.length-1);
  }
    private TreeNode helper(int left, int right){
        //Base case 
        if(inorder.length == 0)
            return null;
        if(left> right)
            return null;
        int root_val = postorder[pre_index--];
        int index = map.get(root_val);
        TreeNode root = new TreeNode(root_val);
        root.right = helper(index+1, right);
        root.left = helper(left,index-1);
        return root;
    }
}