//Time complexity: O(n) as we traverse every node in the binary tree once
//Space Complexity: O(h) where h is the height or depth of the binary tree
//ran on leet code: yes
// any problem encountered: No

public class SumToLeafNode {
    public int sumNumbers(TreeNode root){
        return dfs(root, 0);

    }

    private int dfs(TreeNode root, int currentSum){

        // bass case
        if(root == null) return 0;

        // update the current sum at the root value

        currentSum = currentSum*10 + root.val;

        // check if we have reached the leaf node, if yes then return the currentSum
        if(root.left ==null && root.right ==null){
            return currentSum;
        }
        // recursively call the left and right children
        int leftNode = dfs(root.left, currentSum);
        int rightNode = dfs(root.right, currentSum);

        return leftNode + rightNode;


    }

    public static void main (String[] args){
        SumToLeafNode solution = new SumToLeafNode();

        // Creating a test tree:
        //       4
        //      / \
        //     9   0
        //    / \
        //   5   1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Expected output: 1026
        // Explanation: The two root-to-leaf paths are 1->2 and 1->3, which represent numbers 12 and 13.
        // Their sum is 495 + 491 +40 = 1026.
        int result = solution.sumNumbers(root);
        System.out.println("Total sum of root-to-leaf numbers: " + result);
    }

    }
