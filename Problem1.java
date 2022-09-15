/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Problem1 {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // null check
//         if(preorder == null || preorder.length == 0) return null;

//         int rootValue = preorder[0];
//         TreeNode root = new TreeNode(rootValue);
//         int index = -1; // required to store index of root from inorder array
//         // Searching for root index in inorder array
//         for(int i = 0; i < inorder.length; i++){
//             if(inorder[i] == rootValue) index = i;
//         }

//         int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
//         int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
//         int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
//         int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

//         root.left = buildTree(preLeft, inLeft);
//         root.right = buildTree(preRight, inRight);

//         return root;

        //null check
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start>end) return null;

        // logic 
        int rootVal = preorder[idx++];
        int rootIndex = map.get(rootVal);
        // idx++;
        TreeNode root = new TreeNode(rootVal);


        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);

        return root;
    }
}