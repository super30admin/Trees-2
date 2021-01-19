// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we will use inorder array to find where all the roots are, and go through
//the postorder array. In the inorder array the left and right of a root rep. the left and right
//sub trees, so we recursively keep finding the roots until we get to leaf nodes, and make a TreeNode at each root.
//We will start from the end of the postorder array since the beginning root is there.


public class BuildTreePost {
    HashMap<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;


        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length-1, postorder.length -1);


    }

    public TreeNode helper(int[] postorder, int start, int end, int idx){
        //base
        if(start > end) return null;

        //logic

        //create the node
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);

        //index in inorder (left of it is left tree and right is right tree)
        int root_index = mp.get(rootVal);

        //do right first (postorder is left,right,root) - already covered root, have           //to go backwards
        root.right = helper(postorder, root_index+1, end, idx-1);
        root.left = helper(postorder, start, root_index - 1, idx - (end - root_index) - 1);
        return root;





    }
}










class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int currSum){
        //base
        if(root == null) return;
        //logic
        currSum = currSum * 10 + root.val;

        if(root.left == null && root.right == null){
            result += currSum;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);


    }
}