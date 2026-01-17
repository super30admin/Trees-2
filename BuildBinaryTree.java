// Time Complexity : O(N), N is the number of nodes in postorder/inorder array
// Space Complexity : O(h), H is the height of tree, that will be max number of recursion frames
//  + O(N), N number of values in inorder array that will be stored in HashMap = ~O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
// From postorder array we can identify the root node index. From the inorder array we can find the start and end index of
// left subtree. Similarly, the start and end index of right subtree. Once a root node is created, we can move to the
// next root by decrementing index.

// To find the start and end indices of the subtrees in constant time, we can store them in a map.
import java.util.HashMap;

public class BuildBinaryTree {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        int start = 0;
        int end = len-1;
        // Start the index from last as in postorder array, the root comes in the order Left --> Right --> Root.
        this.index = len-1;
        return buildBinaryTree(postorder, indexMap, start, end);
    }

    private TreeNode buildBinaryTree(int[] postorder, HashMap<Integer, Integer> indexMap, int start, int end) {
        if(index < 0 || start > end){
            return null;
        }
        int currentRoot = postorder[index--];
        int currentRootIndex = indexMap.get(currentRoot);
        // The right subtree is evaluated before as in the postorder the right node appears just before the root.
        TreeNode right = buildBinaryTree(postorder, indexMap, currentRootIndex+1, end);
        TreeNode left = buildBinaryTree(postorder, indexMap, start, currentRootIndex-1);
        return new TreeNode(currentRoot, left, right);
    }
}
