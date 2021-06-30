// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        map = new HashMap<>();
        index = postorder.length -1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder,int start,int end){
        if(index < 0 || start > end) return null;
        
        int rootIdx = map.get(postorder[index--]);
        int rootval = inorder[rootIdx];
        
        TreeNode root = new TreeNode(rootval);
        
        if(start == end) return root;
        
        root.right = helper(inorder, postorder, rootIdx+1, end);
        root.left = helper(inorder, postorder, start, rootIdx-1);
        
        
        return root;
    }
}