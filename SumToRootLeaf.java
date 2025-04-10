
// TC:- O(N * h) - as we are creating an array list at each element.
// SC:-  O(N * h) + O(h) - for recursive stack
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        //base case
        if(root == null) return;

        List<Integer> temp = new ArrayList<>(path);
        currSum += root.val;
        temp.add(root.val);
       

        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(temp);
            }
        }

        helper(root.left, targetSum, currSum, temp);

        helper(root.right, targetSum, currSum, temp);
    }
}