import java.util.Stack;

public class SumRootLeaf3 {
    // **** Using an iterative approach ****
    // TC - O(n) -> n is the number of nodes in a tree
    // SC - O(h) -> h is the height of the tree
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        int sum = 0, num = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        // Inorder traversal - LDR operation
        while(root != null || !nodeStack.isEmpty()) {
            // L - keep on going to the left subtree
            while(root != null) {
                nodeStack.push(root);
                num = num * 10 + root.val;
                numStack.push(num);
                root = root.left;
            }

            // D - operate on the node
            root = nodeStack.pop();
            num = numStack.pop();

            // Check if the current root node is a leaf node or not
            if(root.left == null && root.right == null) sum += num;

            // R - traverse the right subtree
            root = root.right;
        }


        return sum;
    }
}
