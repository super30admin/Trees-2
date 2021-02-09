// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    Map<Integer, Integer> map = new HashMap();
    int pIdx;
    int[] inorder;
    int[] postorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.inorder = inorder;
        this.postorder = postorder;
        
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        pIdx = postorder.length-1;
        
        return helper(0,inorder.length - 1);
    
    }
    
    TreeNode helper(int start, int end) {
        

        // return condition
        if(start>end) return null;
        
        // pick up pIdx element as a root
        int root_val = postorder[pIdx];
        TreeNode root = new TreeNode(root_val);
        
        // root splits inorder list
        // into left and right subtrees
        // Get index of root
        int idx = map.get(root_val);
        
        // build left and right
        pIdx--;
        root.right= helper(idx+1, end);
        root.left = helper(start, idx-1);
        
        
        //return root
        return root;
    }
    
}
