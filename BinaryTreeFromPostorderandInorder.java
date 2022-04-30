import java.util.HashMap;
import java.util.Map;
//Time Complexity: O(N)
//Space Complexity: O(N) O(N) for map and O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class BinaryTreeFromPostorderandInorder {
    int idx;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || postorder.length == 0){
            return null;
        }

        map = new HashMap<>();
        idx = postorder.length - 1;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }


        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end){

        //base
        if(start > end){
            return null;
        }

        //logic

        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }
}
