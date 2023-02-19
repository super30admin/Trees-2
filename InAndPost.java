import java.util.Arrays;

public class InAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0) return null;
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int idx = -1;
        for(int i=0;i<postorder.length;i++){
            if(inorder[i] == rootVal){
                idx = i;
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] inorderRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder,0,inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder,inorderLeft.length,postorder.length-1);

        root.left = buildTree(inorderLeft,postorderLeft);
        root.right = buildTree(inorderRight,postorderRight);
        return root;


    }
}
