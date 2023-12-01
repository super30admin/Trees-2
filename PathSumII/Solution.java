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

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using backtracking, removing the last element at each stage so that we don't have to create a copy everytime. If a specific path is
 * our result, then copy it to a new list and add it to the result. Copying to a new list is necessary, or else it can modify the list
 * later since the List data structure is pass by reference
  */
class Solution {

    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();
        path = new ArrayList<>();

        helper(root, targetSum, 0);

        return result;
    }

    private void helper(TreeNode root, int targetSum, int sum) {

        if(root == null) return;

        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(sum == targetSum)
                result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        helper(root.left, targetSum, sum);
        helper(root.right, targetSum, sum);

        path.remove(path.size()-1);
    }
}


/**
 * Passing a new list at every recursive call. All elements of current list are copied to new list
 */
/*
// Time Complexity : O(n^2)
// Space Complexity : O(n)
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {

        if(root == null) return;

        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(sum == targetSum)
                result.add(path);
            return;
        }

        helper(root.left, targetSum, sum, new ArrayList<>(path));
        helper(root.right, targetSum, sum, new ArrayList<>(path));
    }
}*/
