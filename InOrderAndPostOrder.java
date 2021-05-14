// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We form the Tree in a recursive manner using a map to keep track of the indices in the InOrder Array.
    Further, we decrement the index of the PostOrder Array during each recursive call.
    The start and end pointers are used to define the size of the SubTree we are forming. 
    Since the PostOrder in reverse is Right, Left manner, we traverse in the same manner 
*/

class Solution {
    Map<Integer,Integer> hashMap;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        hashMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) hashMap.put(inorder[i],i);
        idx = postorder.length-1;
        return helper(postorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] postorder, int[] inorder, int start, int end){
        if (start>end) return null;
        
        int val = postorder[idx];
        idx--;
        int inIdx = hashMap.get(val);
        TreeNode root = new TreeNode(val);
        root.right = helper(postorder, inorder, inIdx+1, end);
        root.left = helper(postorder, inorder, start, inIdx-1);
        return root;
    }
}