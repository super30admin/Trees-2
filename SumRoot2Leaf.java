// Time Complexity : O(n) — visit each node once
// Space Complexity : O(h) — recursion stack (h = tree height)
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) DFS carrying the number formed so far (currNum).
// 2) At each node: currNum = currNum*10 + node.val.
// 3) If leaf, add currNum to result; otherwise recurse left and right.


public class SumRoot2Leaf {
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int currNum){
        if(root == null) return;

        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null){
            result = result + currNum;
        }

        dfs(root.left, currNum);
        dfs(root.right, currNum);
    }
}
