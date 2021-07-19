//time n
//space n

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
// postorder = [9,15,7,20,3]
// inorder = [9,3,15,20,7]


class Solution {

    int postindex;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        for(int i=0 ; i<inorder.length ; i++) map.put(inorder[i],i);

        postindex = inorder.length-1;

        return helper(inorder, postorder , 0 , inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder , int start , int end)
    {
        if(start>end) return null;

        TreeNode root = new TreeNode(postorder[postindex--]);

        if(start == end) return root;

        int index = map.get(root.val);

        //right first bcz the new head that we've recieved from decrementing postorder index is head of right tree bcz order L R ROOT
        root.right = helper(inorder, postorder , index+1 , end);
        root.left = helper(inorder, postorder , start , index-1);

         return root;
    }
}
