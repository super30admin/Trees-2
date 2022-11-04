// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //Approach2 TC:O(n) SC:O(n)
    
    HashMap<Integer,Integer> hm  = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null|| inorder.length == 0 || postorder.length == 0) return  null;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        idx = postorder.length-1;
        
        return helper(inorder,postorder, 0, postorder.length-1);
    }
    
    
    public TreeNode helper(int[] inorder,int[] postorder, int start, int end){
        //base
        if(idx<0 || start>end) return null;
        int rootVal = postorder[idx];
        int rootId = hm.get(rootVal);
        idx--;
        TreeNode root = new TreeNode(rootVal);

        if(start == end) return root;
        root.right = helper(inorder,postorder,rootId+1,end);
        root.left = helper(inorder,postorder,start, rootId-1);
        return root;
        
    }
    // Approach 1 TC: O(n^2) SC: O(n^2)
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         if(postorder == null || inorder == null|| inorder.length == 0 || postorder.length == 0) return  null;
//         int i = 0;
//         //base
//         int rootVal = postorder[postorder.length-1];
//         TreeNode root = new TreeNode(rootVal);
        
//         //logic
//         while(rootVal != inorder[i]){
//             i++;
//         }
//         int rootId = i;
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootId);
//         int[] inRight = Arrays.copyOfRange(inorder,rootId+1,inorder.length);
//         int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
//         int[] postRight = Arrays.copyOfRange(postorder,rootId, postorder.length-1);
//         root.left = buildTree(inLeft,postLeft);
//         root.right = buildTree(inRight,postRight);
//         return root;
//     }
}