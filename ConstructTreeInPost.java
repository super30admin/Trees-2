// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to ensure that root.right should come before  root.left

class ConstructTreeInPost {
    Map<Integer, Integer> map; //map for storing indices of inorder values
    int idx; //will decrement one by one to get next root value from preorder
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
            return null;
        map = new HashMap<Integer, Integer>();
        idx = postorder.length - 1; //root is at last in postorder
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int start, int end){

        if(start < 0 || start > end || idx < 0)
            return null;

        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal); //root index in inorder
        // right sub tree in inorder array
        root.right = helper(postorder, rootIndex + 1, end);
        // left sub tree in inorder array
        root.left = helper(postorder, start, rootIndex - 1);
        return root;
    }
}
