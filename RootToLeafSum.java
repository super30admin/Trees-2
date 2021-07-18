import java.util.Stack;

class Pair {
    TreeNode Node;
    int value;

    public Pair(TreeNode Node, int value) {
        this.Node = Node;
        this.value = value;
    }

    public TreeNode getKey() {
        return this.Node;
    }

    public int getValue() {
        return this.value;
    }
}


/*
TC : O(N) where N is the number of nodes
SC : O(logN) where logN is the height of the tree
 */

/**
 * Here, we  use preorder traversal and at every step we calculate previous Product * 10 +current Val.
 * For this, we maintain a local variable localProduct at every step and pass it to the left and right child.
 * <p>
 * If for a particular node, the left and right child are null, then we add this to the global sum.
 */
public class RootToLeafSum {


    public int sum = 0;

    public int sumNumbers_preorder_recursive(TreeNode root) {

        helper(root, 0);
        return sum;
    }


    public void helper(TreeNode root, int product) {

        int localProduct = product * 10 + root.val;
        if (root.left == null && root.right == null)
            sum += localProduct;


        if (root.left != null)
            helper(root.left, localProduct);
        if (root.right != null)
            helper(root.right, localProduct);

    }


     /*
TC : O(N) where N is the number of nodes
SC : O(logN) where logN is the height of the tree
 */

    /**
     * Here we perform iterative inorder traversal but instead of storing just the nodes in the stack, we store the TreeNode as well as the product
     * until that node in the stack. This way at every node, we check whether the left and right node are null.
     * <p>
     * If null, then we add the node's corresponding product to the final Sum
     */

    public int result = 0;

    public int sumNumbers_inorder_iterative(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Stack<Pair> stack = new Stack<>();
        int currentSum = 0;
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                currentSum = currentSum * 10 + root.val;
                stack.push(new Pair(root, currentSum));
                root = root.left;
            }

            Pair p = stack.pop();
            root = p.getKey();
            currentSum = p.getValue();
            if (root.left == null && root.right == null) {
                result += p.getValue();
            }
            root = root.right;
        }
        return result;
    }


    /*
TC : O(N) where N is the number of nodes
SC : O(logN) where logN is the height of the tree
 */

    /**
     * The approach is similar to the previous preorder recursive one. Just that instead of adding the product at leaf node to the global sum,
     * here we pass the sum of products till the leaf node to the parent nodes till we reach the root node.
     *
     * @param root
     * @return
     */
    public int sumNumbers_preorder_recursive_return_int(TreeNode root) {
        return helper_preorder_recursive_return_int(root, 0);
    }

    public int helper_preorder_recursive_return_int(TreeNode root, int currSum) {

        if (root == null) return 0;

        if (root.left == null && root.right == null)
            return currSum * 10 + root.val;

        currSum = currSum * 10 + root.val;
        int num1 = helper_preorder_recursive_return_int(root.left, currSum);
        int num2 = helper_preorder_recursive_return_int(root.right, currSum);
        return num1 + num2;

    }


}
