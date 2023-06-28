//Time Complexity: O(N) where n is the number of nodes
//Space complexity: COnstant
public class SumOfRootToLeaf {
    int pathSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        preorder(root, 0);
        return pathSum;
    }

    private void preorder(TreeNode root, int sum){
        if(root == null){
            return ;
        }

        sum= sum*10 + root.val;

        if(root.left == null && root.right == null){
            pathSum+=sum;
        }
        preorder(root.left, sum);
        preorder(root.right, sum);
    }
}
