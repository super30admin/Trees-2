// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null||postorder.length==0||inorder.length==0){  
            return null;
        } 
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        if(postorder.length==1){
            return root;
        }
        int index=-1;
        for(int i=0;i<postorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        int[] postleft=Arrays.copyOfRange(postorder,0,index);
        int[] inleft=Arrays.copyOfRange(inorder,0,index);
        int[] postright=Arrays.copyOfRange(postorder,index,postorder.length-1);
        int[] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left=buildTree(inleft,postleft);
        root.right=buildTree(inright,postright);
        return root;
    }  
} 