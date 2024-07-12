public class SumRootToLeaf {
    static int sum;

    public static int sumNumbers(TreeNode root) {
        sumRecursion(root, 0); //pass 0 as initial currentSum
        return sum;
    }

    static void sumRecursion(TreeNode root, int current) {
        if(root == null) return;

        current = current*10 + root.val; //calculating current as 10th decimal and adding the root to get current sum

        sumRecursion(root.left, current); //recursion over left child
        sumRecursion(root.right, current); //recursion over right child

        if(root.left == null && root.right == null) { //If this is a leaf node
            sum += current; // Add the current until leaf to the sum
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println("Sum from root to leaf is: " + sumNumbers(root));
    }
}