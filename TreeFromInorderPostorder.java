import java.util.HashMap;
//tc = o(n) visit all nodes
// sc = o(n) hashmap
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
    int idx;
    private TreeNode helper(HashMap<Integer,Integer> map,int[] postorder,int start,int end){
        if(start >end )return null;
        int rootVal = postorder[idx--];
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        System.out.println(root.val);
        root.right = helper(map,postorder,rootIdx+1,end);
        root.left = helper(map,postorder,start,rootIdx-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int start = 0;
        int end = inorder.length-1;
        idx = postorder.length-1;
        return helper(map,postorder,start,end);
    }
}