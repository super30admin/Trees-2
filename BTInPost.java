import java.util.*;

//TC: O(N^2) N - number of nodes 
//SC: O(N) N- number of nodes

//postorder traversal has root as the last element. We will find the index of that element in inorder array.
//The root in inorder array, divides array into left and right subtree.
//We repeat the process of finding subsequent roots of left n right trees from postorder array.

public class BTInPost {

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        
        if(postorder == null || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = -1;
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[postorder.length - 1]){
                index = i;
                break;
            }
        }
       
        int[] pLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] pRight = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        int[] iLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] iRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(pLeft, iLeft);
        root.right = buildTree(pRight, iRight);
        
        return root;
    }

    public static void printInorder(TreeNode root){

            if(root == null) return;
            printInorder(root.left);
            System.out.println(root.val);
            printInorder(root.right);
        }


    public static void main(String[] args){
        int[] pre = {9, 15, 7, 20, 3};
        int[] in = {9,3,15,20,7};
        TreeNode root = buildTree(pre,in);
        printInorder(root);

    }


}
