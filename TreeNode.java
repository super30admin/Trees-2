//TC will be O(n) where n is the number of nodes
//SC will be O(h) where is the height of the tree

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SumRootLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        inorder(root, 0);
        return sum;
    }


    private void inorder(TreeNode root, int currSum){
        //base
        if(root == null){
            return;
        }

        //logic
        inorder(root.left, currSum * 10 + root.val);
        if(root.left == null && root.right == null){
            sum = sum + currSum * 10 + root.val;
        }
        inorder(root.right, currSum * 10 + root.val);
    }


}

