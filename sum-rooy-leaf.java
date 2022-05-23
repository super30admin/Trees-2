//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes
public int sumNumbers(TreeNode root) {
        if(root == null)
        return 0;

        return dfs(root, 0, 0);
        }

public int dfs(TreeNode node, int num, int sum){
        if(node == null) return sum;

        num = num*10 + node.val;

        // leaf
        if(node.left == null && node.right == null) {
        sum += num;
        return sum;
        }

        // left subtree + right subtree
        sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
        return sum;
        }