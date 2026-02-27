// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Sample {
    // Time Complexity : O(n)
    // Space Complexity : O(h)
    // Did this code successfully run on Leetcode : yes
    public int sumNumbers(TreeNode root) {
        return helperSum(root, 0);
    }
    private int helperSum(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }
        currSum = currSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currSum;
        }

        return helperSum(root.left, currSum) + helperSum(root.right, currSum);
    }







    // Time Complexity : O(n)
    // Space Complexity : O(h)
    // Did this code successfully run on Leetcode : yes

    HashMap<Integer, Integer> map = new HashMap<>();
    int postorderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return helperTree(postorder, 0, postorderIdx);
    }
    public TreeNode helperTree(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = postorder[postorderIdx];
        postorderIdx--;
        TreeNode root = new TreeNode(rootVal);

        int inorderIdx = map.get(rootVal);

        root.right = helperTree(postorder, inorderIdx + 1, right);
        root.left  = helperTree(postorder, left, inorderIdx - 1);

        return root;
    }
}