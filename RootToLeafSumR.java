//Recursive implementation of root to leaf sum

public class RootToLeafSumR {
    
    public static int sumRecursive(TreeNode root){
        return helper(root, 0, 0);
    }

    private static int helper(TreeNode node, int curSum, int total){

        //Base Case
        if(node == null) return 0;

        //Logic
        if(node.left == null && node.right == null){
            return total = curSum * 10 + node.val;
        }
        return helper(node.left, curSum * 10 + node.val, total) + helper(node.right, curSum * 10 + node.val, total);
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumRecursive(root));

    }


}
