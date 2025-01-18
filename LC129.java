/*
 * TC: O(n) - because of every node visit.
 * SC: O(n) - worst case stack space.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC129 {
    int ans;
    private void recurse(TreeNode root, int val){
        if(root ==null) return;
        recurse(root.left, (val*10) + root.val);
        recurse(root.right, (val*10) + root.val);
        if(root.left==null && root.right==null){
            ans += (val*10)+root.val;
        }
    }
    public int sumNumbers(TreeNode root) {
        recurse(root, 0);
        return ans;
    }
}
