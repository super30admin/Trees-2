// Time Complexity :O(n)
// Space Complexity :O(h) - height of the tree, in worst case O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class InorderPostorderBT{
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null || postorder.length == 0) return null;
        if(postorder.length == 1) return new TreeNode(postorder[0]);
        
        map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, inorder, postorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] postorder, int[] inorder, int proot, int left, int right){
        //base
        if(left > right || left < 0 || right >= postorder.length || proot < 0 || proot >= postorder.length) return null;
        
        //logic
        TreeNode node = new TreeNode(postorder[proot]);
        
        //find root in inorder
        int idx = map.get(postorder[proot]);;
        //recurse
        node.left = helper(postorder, inorder, proot-(right-idx)-1, left, idx-1);
        node.right = helper(postorder, inorder, proot-1, idx+1, right);
        return node;
    }
}