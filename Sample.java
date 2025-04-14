// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



//Sum Root to Leaf Numbers

TC:O(N)
SC:O(1)
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
    int sum=0;
    public int sumNumbers(TreeNode root) {

        if (root == null){
            return 0;
        } else {
            calculateSum(root, 0);
        }
        return sum;
    }
    private void calculateSum(TreeNode root, int currentsum) {
        if (root == null) { //for one child
            return;
        }
        if (root.left == null && root.right == null) {
            currentsum = currentsum*10 + root.val;
            sum =sum +currentsum;
            return;
        } 
        if (root != null) {
            currentsum = currentsum*10 + root.val;
            calculateSum(root.left, currentsum);
            calculateSum(root.right, currentsum);
        }
    }
}

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
    int idx=0;
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx=postorder.length-1;
        for (int i=0;i<inorder.length;i++) {
            m.put(inorder[i],i);
        }
        TreeNode root = createTree(postorder, 0, postorder.length-1);

        return root;
    }

    private TreeNode createTree(int[] postorder, int start, int end) {
        
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[idx]);
        int rootindex = m.get(postorder[idx]);
        idx--;
        root.right=createTree(postorder, rootindex+1, end);
        root.left = createTree(postorder, start, rootindex-1);
        return root;
    }
}
