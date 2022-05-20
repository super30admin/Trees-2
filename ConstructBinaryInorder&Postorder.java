// Time Complexity : O(h) - height of tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart>inEnd || postStart>postEnd){
            return  null;
        } 
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int index=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==root.val){//you iterate through and check if preorder value is same as inorder
                index = i;//if so you store in index
                System.out.println(i);
                break;
            }
        }
        //you use the index to decide the left root and right root
        root.left = helper(inorder,inStart,index-1,postorder,postStart,postStart+index-inStart-1);
        root.right = helper(inorder,index+1,inEnd,postorder,postStart+index-inStart,postEnd-1);
        
        return root;
    }
}