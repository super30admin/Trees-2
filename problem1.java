// Problem1 - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// Time Complexity : O(n) [Optimized Solution]
// Space Complexity : O(n) [Optimized Solution]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially struggled with optimized solution

public class problem1 {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0 , inorder.length-1);
        
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start>end) return null;
        
        //logic
        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1,end);
        return root;
    }
}
