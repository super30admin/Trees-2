//TC: O(n)
//SC:O(n)
//works in leetcode
//last element in the postorder array is the root
//use decrementer to make nodes
//use inorder to determine the relationship of node. Left subtree and right subtree is created and assigned.
public class BinaryTreeFromInOrderAndPostOrderTraversal {
    private static int postorderIndex;
    private static int[] postorder,  inorder;
    private static Map<Integer, Integer> postorderMap;


    public static  TreeNode buildTree(int[] postorder1, int[] inorder1) {
        postorderIndex=postorder1.length-1;
        postorder= postorder1;
        inorder=inorder1;
        postorderMap = new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            postorderMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length-1);
    }

    private static TreeNode buildTree(int inOrderStart, int inOrderEnd){

        //base
        if(inOrderStart > inOrderEnd)
            return null;

        //recursion
        TreeNode node = new TreeNode(postorder[postorderIndex]);
        postorderIndex--;

        int inorderIndex = getIndex(node.val);
        node.right = buildTree(inorderIndex+1, inOrderEnd);
        node.left = buildTree(inOrderStart, inorderIndex-1);

        return node;

    }

    private static int getIndex(int element){
        return postorderMap.get(element);
    }



    public static void main(String [] args){
        int [] postorder = {9,15,7,20,3};
        int [] inorder = {9,3,15,20,7};
        TreeNode tree =  buildTree(postorder, inorder);
        System.out.println(tree.val);
    }
}
