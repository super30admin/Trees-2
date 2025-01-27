// In this problem, we are maintaining a currSum at each node(which is just proper integer eg. node 4 currSum is 4 and when go from 
// node 4 to node 9, currSum is the integer formed i.e. 49). Then whenever we are at leaf node, calculate actual sum

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Recursive implementation
class Solution {
    // Declare a total sum variable, that will be updated whenever we are at any
    // leaf node, forming proper integer from root to leaf(eg. 495 or 491 or 40)
    int sum;

    public int sumNumbers(TreeNode root) {
        // Base case - if the root is null, that means no sum
        if (root == null) {
            return 0;
        }
        // Call the recursive function with root and currSum as the parameters; currSum
        // will maintain integer formed at each node(eg. 4 or 49 etc.)
        dfs(root, 0);
        // Return total sum
        return sum;
    }

    private void dfs(TreeNode root, int currSum) {
        // Base case
        if (root == null) {
            return;
        }
        // Make the left recursive call, and also update the currSum, as per the node
        // values
        dfs(root.left, currSum * 10 + root.val);
        // Make the right recursive call, and also update the currSum, as per the node
        // values
        dfs(root.right, currSum * 10 + root.val);
        // Check if it is leaf node, then update our total sum variable by adding
        // currSum to it
        if (root.left == null && root.right == null) {
            sum = sum + (currSum * 10 + root.val);
            return;
        }
    }
}

// In above solution even if we write the if-check (of leaf node and calculating
// the sum) between the left and right call or before both
// the calls, it will work, because this problem is traversal dependant. As long
// as we are correctly computing the currentsum for each node, it will work
// correctly, no matter the order.

// Below is the different way of writing the above code, time and space
// complexity remains same
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }
        int case1 = dfs(root.left, currSum * 10 + root.val);
        int case2 = dfs(root.right, currSum * 10 + root.val);
        if (root.left == null && root.right == null) {
            return currSum * 10 + root.val;
        }
        return case1 + case2;
    }
}

// In above solution also even if we write the if-check (of leaf node and
// calculating
// the sum) between the left and right call or before both
// the calls, it will work.

// Below is the different way of writing the above code, time and space
// complexity remains same
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return currSum * 10 + root.val;
        }
        return dfs(root.left, currSum * 10 + root.val) + dfs(root.right, currSum * 10 + root.val);
    }
}

// Iterative implementation:
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Declare a total sum variable, that will be updated whenever we are at any
        // leaf node, forming proper integer from root to leaf(eg. 495 or 491 or 40)
        int sum = 0;
        // Declare two stacks, one for storing root and other for storing currSum at
        // each node
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> currSum = new Stack<>();
        // currNum is our currSum that will be added to the stack
        int currNum = 0;
        // Check if root not null or stack not empty
        while (root != null || (!s.isEmpty())) {
            // Check if root not null, that means traverse left till we are at the end or
            // leaf
            while (root != null) {
                // keep on pushing root and currSum to the stacks
                s.push(root);
                currNum = currNum * 10 + root.val;
                currSum.push(currNum);
                // Go on left
                root = root.left;
            }
            // Once we are at end, do pop from both stacks and store it
            root = s.pop();
            currNum = currSum.pop();
            // Check if the node is the leaf node, if yes, compute sum
            if (root.left == null && root.right == null) {
                sum = sum + currNum;
            }
            // Make the right recursive call
            root = root.right;
        }
        return sum;
    }

}