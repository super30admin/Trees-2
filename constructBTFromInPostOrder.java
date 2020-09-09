//Time Complexity: O(n)
//Space Complexity: O(1)

public class constructBTFromInPostOrder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, inorder.length-1);
    }
    
    public static TreeNode helper(int[] inorder, int[] postorder, int start, int end, int postEnd){
        if (postEnd < 0 || end < start) 
            return null;
        int val = postorder[postEnd];
        
        //Adding root to the tree
        TreeNode root = new TreeNode(val);
        
        int index = 0;
        
        //getting the root index from the inorder array
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == postorder[postEnd]){
                index = i;
                break;
            }
        }
        //generating left sub tree
        root.left = helper(inorder, postorder, start, index-1, postEnd - end + index - 1);
        //generating right sub tree
        root.right = helper(inorder, postorder, index+1, end, postEnd -1);
        
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        System.out.println(buildTree(in, post));
    }
}