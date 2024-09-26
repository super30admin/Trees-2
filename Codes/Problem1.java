/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
*   Time Complexity - O(n)
*   Space Complexity - Without Recursive Stack - O(n)
*                      With Recursive Stack - O(n + maxDepth)
*/
class Solution {
    int[] inorder;
    int[] postorder;
    Map<Integer,Integer> map;
    int p_idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap<>();
        this.inorder = inorder;
        this.postorder = postorder;

        int count=0;

        for(int x : inorder){
            map.put(x,count++);
        }

        this.p_idx = postorder.length-1;

        return helper(0,this.p_idx);


    }

    private TreeNode helper(int l_idx,int r_idx){

        if(l_idx > r_idx){
            return null;
        }
        TreeNode root = new TreeNode(this.postorder[this.p_idx--]);
        int idx = map.get(root.val);
        root.right = helper(idx+1,r_idx);
        root.left = helper(l_idx,idx-1);
        return root;
    }

}