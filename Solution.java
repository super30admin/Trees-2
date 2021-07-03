/**
 * 
 */
package LC1006_BT_Inorder_Postorder;

import java.util.Arrays;




/**
 * @author neha
 *
 */
public class Solution {

	
public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode(int x) 
	     { 
	    	 val = x; 
	    	 }
	     
	 }
	static TreeNode root; 
	

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 )
        {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length -1]);
        int index = -1;
        //Finding the root from the inorder array
        for(int i=0; i<inorder.length;i++)
        {
            if(inorder[i] == root.val)
            {
                index = i;
                break;
            }
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder,0,index);
        int[] postRight = Arrays.copyOfRange(postorder,index,postorder.length-1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
	
	void printInorder(TreeNode node) 
	{ 
	    if (node == null) 
	        return; 

	    /* first recur on left child */
	    printInorder(node.left); 

	    /* then print the data of node */
	    System.out.print(node.val + " "); 

	    /* now recur on right child */
	    printInorder(node.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution Tree = new Solution();
		int[] postorder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
		TreeNode Binary_tree = Tree.buildTree(inorder,postorder);
		System.out.println("The Inorder Tree Traversal is");
		Tree.printInorder(Binary_tree);


	}

}
