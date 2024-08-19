//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.HashMap;

public class InOrderPostOrderTraversal {
    int postorderIndex;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;

        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) return null;
        int rootVal = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        postorderIndex--;
        root.right = helper(postorder, index + 1, right);
        root.left = helper(postorder, left, index - 1);
        return root;
    }
}
