import java.util.Stack;

class TreeNode {
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


// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * DFS recursive solution, if the node is a leaf node in tree we calculate the answer by answer = answer + sum * 10 + root.val
 * We start recurssion with sum = 0 and not root value, and make recursive calss on left and right.
 * This solution is traversal independant solution as far as we update the sum before recurssive calls
 */

class SumRootToLeaf {
    int answer;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root, 0);
        return answer;
    }
    private void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            answer = answer + sum;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}

// Time Complexity : 0(n) 
// Space Complexity : 0(h) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
/*
 * Iterative approach where we use 2 stack one from sum and another for node, usually iterative version need stacks depending upon how many parameter are considered in recurssion.
 * We push sum and node in their respective stack and iterative calculat sum and return answer. 
*/
class SumRootToLeafItr {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        int answer = 0;
        int currsum = 0;

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                currsum = currsum * 10 + root.val;
                sum.push(currsum);
                root = root.left;
            }
            root = s.pop();
            currsum = sum.pop();
            if (root.left == null && root.right == null) {
                answer = answer + currsum;
            }
            root = root.right;
        }
        return answer;
    }
}
