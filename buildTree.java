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
public class Solution {

Map<Integer, Integer> indexMap = new HashMap();

int currentIndex = 0;

public TreeNode buildTree(int[] inorderTraversal, int[] postorderTraversal) {
    if(inorderTraversal.length == 0 || postorderTraversal.length == 0){
        return null;
    }
    currentIndex = postorderTraversal.length - 1;
    for(int i=0; i<inorderTraversal.length; i++){
        indexMap.put(inorderTraversal[i], i);
    }
    return helper(inorderTraversal, postorderTraversal, 0, inorderTraversal.length-1);
}

private TreeNode helper(int[] inorderTraversal, int[] postorderTraversal, int left, int right) {
    if(currentIndex < 0 || left > right){
        return null;
    }
    int rootIndex = indexMap.get(postorderTraversal[currentIndex--]);
    TreeNode currentNode = new TreeNode(inorderTraversal[rootIndex]);
    if(left == right){
        return currentNode;
    }
    currentNode.right = helper(inorderTraversal, postorderTraversal, rootIndex+1, right);
    currentNode.left = helper(inorderTraversal, postorderTraversal, left, rootIndex-1);
    return currentNode;
}

}
