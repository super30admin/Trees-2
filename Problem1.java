// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Problem1 {
    HashMap<Integer, Integer> map;
    int idx;


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || inorder.length ==0 || postorder.length==0) return null;
        map = new HashMap<>();
        for(int i =0; i<inorder.length; i++){

            map.put(inorder[i],i);
        }
        idx = postorder.length-1;
        return helper(inorder, postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        //base
        if(start>end) return null;

        //logic
        TreeNode root = new TreeNode(postorder[idx--]);
        int rootIdx = map.get(root.val);

        root.right = helper(inorder, postorder, rootIdx+1, end);
        root.left = helper(inorder, postorder,start, rootIdx-1);

        return root;
    }
}