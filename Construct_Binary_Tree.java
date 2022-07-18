// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : hashmap solution does not run


// Your code here along with comments explaining your approach


class Solution {


    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder== null || postorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);// null pointer exception
        }
        return helper(postorder, inorder, 0, postorder.length - 1);

    }
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end){
        //base case
        if(start>end) return null;
        //logic
        int rootval = postorder[index];
        index++;
        TreeNode root = new TreeNode(rootval);
        int rootindex = map.get(rootval);

        root.left = helper(postorder, inorder, start, rootindex-1);
        root.right = helper(postorder, inorder, rootindex+1, end);
        return root;
    }
}