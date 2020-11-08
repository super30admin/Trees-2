/**
 * Time Complexity: O(n)
 * Space Complexity : O(n) - an extra map to store items
 * Leetcode: Yes
 * Idea:
 * 1. Get data from preorder to create new node. 
 * 2. search for data in inorder array using a map and left part of inorder array becomes left subtree and right part becomes right subtree
 * 3. return root
 */
import java.util.*;
class InorderPostorderToBST {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        
    }
    
    public TreeNode helper(int[] inorder, int inStart,int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer,Integer> map){
        //Base Case
        if(inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        // formula 
        int postOrderIndexFromFormula = postStart+rootIdx-inStart -1;
        TreeNode rootLeft = helper(inorder, inStart, rootIdx-1, postorder, postStart, postOrderIndexFromFormula, map);
        TreeNode rootRight = helper(inorder, rootIdx+1, inEnd, postorder, postOrderIndexFromFormula+1, postEnd - 1,map);
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }

    public TreeNode treeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, HashMap<Integer, Integer> map){
        
        
        if(inorderStart > inorderEnd || postorderStart > postorderEnd) return null;

        TreeNode newNode = new TreeNode(postorder[postorderEnd]);

        int rootIndex = map.get(newNode.val);
        int postorderStartFormula = postorderStart+rootIndex-inorderStart-1;
        newNode.left = treeHelper(inorder, postorder, inorderStart, rootIndex-1, postorderStart, postorderStartFormula, map);
        newNode.right = treeHelper(inorder, postorder, rootIndex+1, inorderEnd, postorderStartFormula+1, postorderEnd-1, map);
        
        return newNode;


    }
    public TreeNode inPostToBST(int[] inorder, int[] postorder){
        
        // put inorder to map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

       return treeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, map);
        
        //return null;
    }


    public void printInorderTraversal(TreeNode root){

        if(root == null) return;
        printInorderTraversal(root.left);
        System.out.print(root.val + " ");
        printInorderTraversal(root.right);

    }

    public static void main(String[] args){
        System.out.println("InorderToBST");
        InorderPostorderToBST obj = new InorderPostorderToBST();
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        //TreeNode root = obj.buildTree(inorder, postorder);
        TreeNode root = obj.inPostToBST(inorder, postorder);
        obj.printInorderTraversal(root);
    }
}