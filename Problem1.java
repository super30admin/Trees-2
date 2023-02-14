import java.util.HashMap;
import java.util.Map;
/*
Construct Binary Tree from post and in order traversals
time: O(n)
space: O(n)

class TreeNode {
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

 */
public class Problem1 {
    static int rootIndex = 0;
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(postorder, inorder, inorderMap, 0, postorder.length-1);
    }

    static TreeNode constructTree(int []postorder,int[] inorder, Map<Integer, Integer> inorderMap, int start, int end) {
        if(start>end || rootIndex<0) return null;
        TreeNode root = new TreeNode();
        root.val = postorder[((postorder.length-1)-rootIndex++)];
        int mid = inorderMap.get(root.val);
        root.right = constructTree(postorder, inorder, inorderMap, mid+1, end);
        root.left = constructTree(postorder, inorder, inorderMap, start, mid-1);

        return root;
    }

    public static void main(String []args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,15,7,20,3});
    }
}
