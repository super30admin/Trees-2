//Time complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll be first checking if the postorder or inorder arrays are empty. In that case, I'll return null. Else I'll be pushing my root element from postorder array, which will be the last element in the postorder array. I'll set an index variable to -1. I'll loop through the length of the postorder array and then will find the index corresponding to the root element in the inorder array. I'll assign that index to my index variable. I'll then form the postorder arrays and inorder arrays for my left and right part of the tree and repeat the same process recursively.
//This code was executed successfully and got accepted in leetcode.

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