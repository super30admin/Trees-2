import java.util.HashMap;

//Time complexity:O(N)
//Space Complexity:Constant
public class TreeFromPostAndInorder {
    int idx;
    HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        if(postorder.length == 0){
            return null;
        }
        idx = postorder.length - 1;
        for(int i = 0; i < inorder.length ; i++){
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int begin, int end){
        if(begin > end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[idx]);
        int rootIdx = inorderMap.get(root.val);
        idx--;

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, begin, rootIdx - 1);



        return root;

    }
}
