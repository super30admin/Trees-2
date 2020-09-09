// Time Complexity : O(n*2)
// Space Complexity : O(n*2) including recursive stack, else O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//We find root node from postorder last element
//loop through inorder to find the root, so all the elements left of root form left subtree and right of root form right subtree
//we build 4 arrays, 2 left and right for both inorder and postorder and recursively go till the leaf nodes to build tree
//return root in the last

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0) return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(root.val==inorder[i]){
                index=i;
                break;
            }
        }
        int leftsize=index;
        int[] leftIn = Arrays.copyOfRange(inorder,0,index);
        int[] rightIn= Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] leftPost = Arrays.copyOfRange(postorder, 0,leftsize);
        int[] rightPost = Arrays.copyOfRange(postorder, leftsize,postorder.length-1);
        
        root.left = buildTree(leftIn,leftPost);
        root.right = buildTree(rightIn, rightPost);
        
        return root;
    }
}