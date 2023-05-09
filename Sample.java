
## Problem3 (https://leetcode.com/problems/symmetric-tree/)

// Time Complexity : 0(h) because each node is visited exactly once during the depth-first search traversal.
// Space Complexity : 0(h) because the maximum number of nodes that can be present in the recursive call stack at any point in time is equal to the height of the binary tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;        
    }
    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        if (left == null || right == null) {
            isSymmetric = false;
            return;
        }
        if (left.val != right.val) {
            isSymmetric = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}


## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

// Time Complexity : 0(n) because the algorithm visits each node of the tree exactly once.
// Space Complexity : 0(n) because the algorithm uses a HashMap to store the indices of the nodes in the inorder traversal.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    private HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int root_index = map.get(rootVal);
        root.left = helper(preorder, start, root_index - 1);
        root.right = helper(preorder, root_index + 1, end);
        return root;
    }
}

## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// Time Complexity : 0(n) because each node is visited exactly once during the depth-first search traversal.
// Space Complexity : 0(h) because the maximum number of nodes that can be present in the recursive call stack at any point in time is equal to the height of the binary tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        int answer = 0;
        int currsum = 0;

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                currsum = currsum * 10 + root.val;
                sum.push(currsum);
                root = root.left;
            }
            root = s.pop();
            currsum = sum.pop();
            if (root.left == null && root.right == null) {
                answer = answer + currsum;
            }
            root = root.right;
        }
        return answer;
    }
}