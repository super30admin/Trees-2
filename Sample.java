//Problem 1 : (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach :  Using hashmap to store the inorder traversal elements and then recursively building the tree using postorder traversal
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(inorder, postorder, rootIdx + 1, end);
        root.left = helper(inorder, postorder, start, rootIdx - 1);
        return root;
    }
}

// Problem 2: (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : DFS approach to
// calculate the sum of root to leaf numbers

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
