/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 106. Construct Binary Tree from Inorder and Postorder Traversal
Time Complexity: O(n^2)
Space Complexity: O(n)
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length-1]);

        int index = -1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        int[] post_left = Arrays.copyOfRange(postorder, 0, index);
        int[] post_right = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] in_right = Arrays.copyOfRange(inorder, index+1, inorder.length);

        root.left = buildTree(in_left, post_left);
        root.right = buildTree(in_right, post_right);

        return root;
    }
}


/* 106. Construct Binary Tree from Inorder and Postorder Traversal
Time Complexity: O(n)
Space Complexity: O(n)
 */

class Solution {
    int post_index;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> index_map = new HashMap<>();

    public TreeNode helper(int in_left, int in_right){
        if(in_left > in_right)
            return null;

        TreeNode root = new TreeNode(postorder[post_index]);

        int search_index = index_map.get(root.val);

        post_index--;

        root.right = helper(search_index+1, in_right);
        root.left = helper(in_left, search_index-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        post_index = postorder.length - 1;

        int index = 0;
        for(Integer num: inorder)
            index_map.put(num, index++);

        return helper(0, inorder.length-1);
    }
}