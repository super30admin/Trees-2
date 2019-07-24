/**
 * Time Complexity: O(n^2)
 * Space Complexity : O(1) - no extra space
 * Idea:
 * 1. Get data from preorder to create new node. 
 * 2. search for data in inorder array and left part of inorder array becomes left subtree and right part becomes right subtree
 * 3. return root
 */

class InorderPostorderToBST {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    
    
    public int findInInorder(int data, int[] inorder){

        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == data)
                return i;
        }
        return -1;
    }

    static int postorderIndex=Integer.MAX_VALUE;
    // int preorderIndex = 0;
    public TreeNode buildTreeHelper(int[] postorder, int[] inorder, int inorderStart, int inorderEnd){

        if(inorderStart > inorderEnd)
            return null;
        
        // create node from postorder
        int data = postorder[postorderIndex];
        postorderIndex--;
        TreeNode newNode = new TreeNode(data);

        // no children
        if(inorderStart == inorderEnd) return newNode;
        
        //search in inorder to find index
        int inorderIndex = findInInorder(data, inorder);


        //node.left -> left side in inorder
        newNode.left = buildTreeHelper(postorder, inorder, inorderStart, inorderIndex-1);

        //node.right -> right side in inorder

        newNode.right = buildTreeHelper(postorder, inorder, inorderIndex+1, inorderEnd);

        return newNode;

    }
    public TreeNode buildTree(int[] postorder, int[] inorder) {
                
        TreeNode root = buildTreeHelper(postorder, inorder, 0, inorder.length-1);
        return root;
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
        postorderIndex = postorder.length-1;
        TreeNode root = obj.buildTree(postorder, inorder);
        obj.printInorderTraversal(root);
    }
}