/*
    L.C 129. Sum Root to Leaf Numbers

    Approach: DFS - Pre Order traversal -> (Root left right)

    Working:
        declare a global sum variable to hold the sum whe a leaf not is encountered

        dfs(root, 0 -> currentNumber)

            check if root id NULL
                return;
            check if root left and right  is null //indicate the leaf node
                sum = sum + (currentNumber*10+root.val)
            //traverse to left node
            dfs(root.left, currentNumber*10+root.val)
            //traverse to right node
            dfs(root.right, currentNumber*10+root.val)
        return sum

    Time Complexity : O(n)
    Space Complexity: O(h) //the max elements in the stack while traversal
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumRootToLeaf {

    int sum = 0;
    public int sumNumbers(TreeNode root) {

        if(root == null) {
            return 0;
        }

        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int currNum) {

        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            sum = sum+currNum*10+root.val;
            return;
        }
        dfs(root.left, currNum*10+root.val);
        dfs(root.right, currNum*10+root.val);

    }


}
