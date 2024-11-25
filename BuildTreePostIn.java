import java.util.Arrays;

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n)
 * Logic: intuition - the last element in the post order array will be the root of the tree. after identifying the root
 *         node, check the index of that element in the inorder array, the elements to the left of the index will
 *         signify the left sub tree elements and the elements to the right of the index will signify the elements of the
 *         right sub tree. copy the elements left to the root element index in inorder array to a different array and
 *         perform similar operation to copy the elements to the right of the root element to another array. Create similar
 *         arrays for post order left and post order right. recursively call the build tree function for left sub tree and
 *         right sub tree by passing in the inorder and psotorder sub arrays and after the recursive call is done return the
 *         root
 *
 */
public class BuildTreePostIn {
    public class TreeNode {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0){
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;

        for(int i = 0; i< inorder.length; i++){
            if(rootVal == inorder[i]){
                rootIndex = i;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, postorder.length - 1);


        root.right = buildTree(inRight, postRight);
        root.left = buildTree(inLeft, postLeft);

        return root;

    }
}

