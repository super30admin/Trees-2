// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer,Integer> map;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /* Base Case */
        if(preorder.length==0 && inorder.length==0 || preorder.length!=inorder.length)
            return null;
        
        /* Keep Track of Inorder Node and Index */
        map=new HashMap<>();
        preorderIndex=0;
        
        /* Put Values in Map */
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        /* Recurse */
        return helper(preorder,inorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        /* Base Case */
        if(preorderIndex==preorder.length || start>end)
            return null;
        
        /* Find Root in Inorder */
        int rootElement=preorder[preorderIndex];
        int inorderRootIndex=map.get(rootElement);
        
        /* Logic */
        
        TreeNode node=new TreeNode(rootElement);
        preorderIndex++;
        
        /* Recurse */
        
            /* Recurse Left */
        node.left=helper(preorder,inorder,start,inorderRootIndex-1);
        
            /* Recurse Right */
        node.right=helper(preorder,inorder,inorderRootIndex+1,end);
        
        
        return node;
    }
}