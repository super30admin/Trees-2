// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class BinaryTree {
    HashMap<Integer, Integer> map = new HashMap();
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0)
            return null;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return traverse( preorder, 0, preorder.length-1);
    
    }
    private TreeNode traverse(int[] preorder, int start, int end){
        if(start>end)
            return null;
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root  = new TreeNode(rootVal);
        root.left=traverse(preorder, start, rootIdx-1);
        root.right = traverse(preorder, rootIdx+1,end);
        return root;
    }


}