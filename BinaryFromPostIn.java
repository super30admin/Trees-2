/**
 * The time complexity for the worst case is O(N^2) where the tree is completely skewed and we need to go the end of inorder array to get root.
 * The space complexity for the worst case is O(N)
 *
 * Here the intuition is we have the root at the end of postorder. Search for the root in inorder through which we can find the division of left
 * and right subtree
 *
 * Yes, the solution passed all the test cases in leetcode.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int postLength = postorder.length;
        if(postLength==0){return null;}


        int root_index = postLength-1;

        TreeNode root = new TreeNode(postorder[root_index]); int index = -1;

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==postorder[root_index]){
                index = i;
                break;
            }
        }

        int[] leftIn = Arrays.copyOfRange(inorder,0,index);
        int[] leftPost = Arrays.copyOfRange(postorder,0,index);

        root.left = buildTree(leftIn,leftPost);

        int[] rightIn = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] rightPost = Arrays.copyOfRange(postorder,index,inorder.length-1);

        root.right = buildTree(rightIn,rightPost);

        return root;
    }
}