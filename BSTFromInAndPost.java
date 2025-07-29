// Time Complexity : O(m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// - The last element in postorder is the root of the current subtree.
// - Use a hashmap to store the indices of elements in inorder for O(1) lookup.
// - Start from the end of postorder and create nodes in reverse postorder order.
// - To maintain correct structure, recursively build the right subtree first
//   (because of postorder’s left→right→root order), then the left.
// - Use the inorder array to determine the bounds of left and right subtrees.
//
// The function uses a helper `createTree` with start and end pointers into the
// inorder array to build the subtrees recursively.



import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode (int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTFromInAndPost {
    HashMap<Integer, Integer> hmap = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder){

        if(postorder == null || postorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        for(int i = 0; i < inorder.length; i++){
            hmap.put(inorder[i], i);
        }

        idx = postorder.length - 1;
        return createTree(postorder, 0, inorder.length - 1);

    }

    private TreeNode createTree(int[] postorder, int start, int end){
        if(start > end) return null;

        int rootval = postorder[idx--];
        TreeNode root = new TreeNode(rootval);

        int rootidx = hmap.get(rootval);
        root.right = createTree(postorder, rootidx+1, end);
        root.left = createTree(postorder,  start, rootidx - 1);
        return root;


    }

}
