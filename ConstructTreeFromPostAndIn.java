// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree as we're maintaining one auxiliary HashMap of length n
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.HashMap;
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
public class ConstructTreeFromPostAndIn {
    private HashMap<Integer, Integer> inordermap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inordermap = new HashMap<>();
        this.postIndex = postorder.length -1;
        for(int i =0; i < inorder.length; i++){
            inordermap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        //base
        if(start > end){
            return null;
        }
        int rootvalue = postorder[postIndex];
        int rootindex = inordermap.get(rootvalue);
        TreeNode root = new TreeNode(rootvalue);
        postIndex--;

        root.right = helper(postorder, rootindex+1, end);
        root.left = helper(postorder, start, rootindex-1);

        return root;
    }
}
