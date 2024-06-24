import java.util.HashMap;
import java.util.Map;

//Time - O(n)
//SPace - O(n)
public class BinaryTreeFromInorderPostorder {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0 || inorder.length!=postorder.length){
            return null;
        }
        idx = postorder.length-1;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recurse(postorder, 0, inorder.length-1);
    }
    private TreeNode recurse(int[] postorder, int start, int end) {
        if(idx < 0){
            return null;
        }
        System.out.println("idx : "+idx);
        if(start > end) {
            return null;
        }

        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx--;
        int rootIdx = map.get(rootVal);
        root.right = recurse(postorder, rootIdx+1, end);
        root.left = recurse(postorder, start, rootIdx-1);
        return root;
    }
}

