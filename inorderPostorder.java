//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //postorder= Left right root
        //inorder= left root right
        //base case
        if(postorder==null || inorder==null || postorder.length==0)return null;
        //taking the root node
        int rootV=postorder[postorder.length-1];
        //to store the root of our tree
        TreeNode root=new TreeNode(rootV);
        //then take the index of root in inroder
        int rootIndex=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootV){
                rootIndex=i;
                break;
            }
        }
        //an array for inorder left, taking the values from 0th index to index before the root index as left subtree; as well as right subtree; same for postorder
        int[] postorderL=Arrays.copyOfRange(postorder,0,rootIndex);         
        int[] postorderR=Arrays.copyOfRange(postorder,rootIndex,postorder.length-1);
        int[] inorderL=Arrays.copyOfRange(inorder,0,rootIndex);
        int[] inorderR=Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
        //building left and right side of the tree
        root.left=buildTree(inorderL,postorderL);
        root.right=buildTree(inorderR,postorderR);
        return root; 
    }
}