import java.util.HashMap;
import java.util.Map;

public class BinTree_from_in_and_postOrder {
    // Time: O(n), Space: O(n)
    Map<Integer, Integer> inMap = new HashMap();
    int postIndex;
    int postorder[];
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorder = postorder;
        postIndex = postorder.length-1;

        for (int i = 0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(0, inorder.length-1);
    }

    TreeNode helper(int left, int right) {

        if (left > right) return null;
        System.out.println("left = "+left+" right = "+right+" postIndex = "+postIndex);
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(left, inMap.get(rootVal)-1);

        root.right = helper(inMap.get(rootVal)+1, right);

        return root;
    }
}
