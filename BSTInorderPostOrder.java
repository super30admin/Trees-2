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
class Solution {
    HashMap <Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap <>();
        for (int i = 0;i < inorder.length;i++){
            map.put (inorder[i],i);
        } 
        return buildTree (inorder, postorder,0, inorder.length-1, 0, postorder.length-1);
    }
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd){
            return null;
        }
        int head = postorder[postEnd];
        //find that head in inOrder
        int inorderPos = -1;
            inorderPos = map.get(head);
        int leftTreeSize = inorderPos - inStart;
        TreeNode tHead = new TreeNode (head);
        int leftinStart = inStart;
        int leftinEnd  = inorderPos -1;
        int leftposStart = postStart;
        int leftposEnd = postStart+leftTreeSize-1;
        tHead.left = buildTree (inorder, postorder, leftinStart,leftinEnd,leftposStart,leftposEnd);
        int rightinStart = inStart+leftTreeSize+1;
        int rightinEnd = inEnd;
        int rightposStart = postStart+leftTreeSize;
        int rightposEnd = postEnd -1; 
        tHead.right = buildTree(inorder, postorder, rightinStart,rightinEnd,rightposStart,rightposEnd);
        return tHead;
    }
        
}