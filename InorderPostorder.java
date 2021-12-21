// Approach 
// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// We use the postorder to get the root value
// we use inorder to determine the left and right children
// we make changes to the arrays and pass them to the recursive functions

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0)
            return null;
        int rootidx = -1;
        int rootVal = postorder[postorder.length - 1];
        System.out.println(rootVal);
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i])
                rootidx = i;
        }
        System.out.println(rootidx);
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inorderright = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);
        int[] postorderleft = Arrays.copyOfRange(postorder, 0, rootidx);
        int[] postorderright = Arrays.copyOfRange(postorder, rootidx, postorder.length - 1);
        root.right = buildTree(inorderright, postorderright);
        root.left = buildTree(inorderleft, postorderleft);

        return root;
    }
}

// Approach
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// We use the postorder to get the root value
// we use inorder to determine the left and right children
// Instead of making changes to the arrays we pass the index and use the Hashmap
// for efficient look up
class Solution {
    HashMap<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0)
            return null;
        map = new HashMap<>();
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);

    }

    public TreeNode helper(int[] postorder, int start, int end) {
        if (start > end)
            return null;
        int rootVal = postorder[idx];
        idx--;

        TreeNode root = new TreeNode(rootVal);
        int rootidx = map.get(rootVal);
        root.right = helper(postorder, rootidx + 1, end);
        root.left = helper(postorder, start, rootidx - 1);

        return root;
    }
}