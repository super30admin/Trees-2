import java.util.HashMap;

public class ConstructTree {
    HashMap<Integer, Integer> map;
    int idx; //preorder idx
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = inorder.length-1 ;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder,0, inorder.length-1);

    }

    private TreeNode helper(int[] postorder, int start, int end){
        //base
        if(start > end) return null;
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);

        int rIdx = map.get(root.val);
        root.right = helper(postorder, rIdx+1, end);
        root.left = helper(postorder, start, rIdx - 1);


        return root;
    }
}
