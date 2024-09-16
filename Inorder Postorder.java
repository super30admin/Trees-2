// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h) and h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length==0)
            return null;
        map =  new HashMap<>();
        idx = postorder.length-1;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, 0, postorder.length-1);
    }
    private TreeNode helper(int[]postorder, int start, int end){
        if(start>end)
            return null;
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx-1);
        return root;
    }
}
}