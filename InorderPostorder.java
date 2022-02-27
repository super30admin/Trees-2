// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> store = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            store.put(inorder[i],i);;
        }
        //postorderend,inStart,inEnd,inorder,postorder,map
        return helper(postorder.length-1,0,inorder.length-1,inorder,postorder,store);
    }
    
    public TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder,HashMap<Integer, Integer> store){
        if(postEnd < 0 || inStart>inEnd){
            return null;
        }
        //last end in postorder will be root
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        //get the root in inorder array
        inIndex = store.get(root.val);
        //left subtree
        root.left = helper(postEnd+inIndex-inEnd-1, inStart, inIndex-1, inorder, postorder,store);
        //right subtree
        root.right = helper(postEnd-1,inIndex+1,inEnd,inorder,postorder,store);
        
        return root;
    }
}