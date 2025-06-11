import java.util.HashMap;

/*
 Space Complexity - O(N)
 Time complexity - O(N)
 Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
 */
public class InorderPostOrderBinaryTreeConsrtuction_LC_106 {

    int postIdx; //index on preorder
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        postIdx = postorder.length -1;
        return helper(inorder, postorder, map, 0, inorder.length-1);
    }
    private TreeNode helper( int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start , int end) {
        //base case
        if(start > end) return null;
        //logic
        int rootVal = postorder[postIdx];
        postIdx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(inorder,postorder, map, rootIdx +1, end);
        root.left = helper(inorder,postorder, map, start, rootIdx-1);



        return root;
    }
}

