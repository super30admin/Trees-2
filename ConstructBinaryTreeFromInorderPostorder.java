// Time Complexity : O(N) N-> No of Nodes in tree
// Space Complexity : O(N) N-> No of Nodes in tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    int postIndex;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0 ; i<inorder.length ; i++)
            map.put(inorder[i],i);

        postIndex = inorder.length-1;
        return helper(inorder, postorder , 0 , inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder , int start , int end) {
        if(start>end) return null;

        TreeNode root = new TreeNode(postorder[postIndex--]);
        if(start == end)
            return root;

        int index = map.get(root.val);

        root.right = helper(inorder, postorder , index+1 , end);
        root.left = helper(inorder, postorder , start , index-1);

        return root;
    }
}