// Time Complexity : O(n) n=number of elements in the inorder array
// Space Complexity : O(n) n = number of elements in the HashMap
// Did this code successfully run on Leetcode : Yes

// Approach: The root is taken from the last element of postorder array.
// Left and right subtree of the current root is at the start to index-1 of the root
// and index+1 to end of the inorder array respectively.

class Solution {
    
    HashMap<Integer,Integer> map;
    int index;
    
    public TreeNode helper(int[] postorder, int start, int end) {
        if(start>end) return null;
        int inIdx = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        root.right = helper(postorder,inIdx+1,end);
        root.left = helper(postorder,start,inIdx-1);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        if(inorder.length==0) return null;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(postorder,0, inorder.length-1);
    }
}