//Time: O(n)
//Space: O(h)
//Did it successfully run on leetcode: Yes

class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        //helper function to return sum
        return  helper(root, 0);
    }

    public int helper(TreeNode root, int currSum){
        //
        if(root == null) return 0;
        //calculate current Sum
        currSum = currSum*10 + root.val;
        // if leaf node return sum
        if(root.left == null && root.right==null){
            return currSum;
        }
        //Root to leaf sum of left sub tree
        int left = helper(root.left, currSum);
        //Root to leaf sum of right sub tree
        int right = helper(root.right, currSum);
        // return Root to leaf sum of left and right sub tree
        return left+right;
    }