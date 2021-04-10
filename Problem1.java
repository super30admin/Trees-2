import java.util.Arrays;

//Construct Binary Tree from Inorder and Postorder Traversal
// Time Complexity :O(n) n -length of array
// Space Complexity :O(n*n) recurion stack & for loop
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :recursion approach. We split the arrays into two array
// called left and right as per the root node. 
// We get the root node from last node of post order list
// Hence recursively we create the array and pass the function 



// Your code here along with comments explaining your approach
public class Problem1 {
    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root.val);

    }
    public static int  index;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        //recusrion
        if(postorder == null || postorder.length ==0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for(int i = 0;i< inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, postorder.length-1);
        root.left =buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
        
        
    }
}
