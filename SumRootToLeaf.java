//TC: O(n)
//SC: O(h)
//approach: preorder traversal

public class SumRootToLeaf {
    int sum =0 ;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode root, int currentSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            currentSum = currentSum*10 + root.val;
            sum += currentSum;
        }
        dfs(root.left, currentSum*10 + root.val);
        dfs(root.right, currentSum*10 + root.val);
    }
}

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
