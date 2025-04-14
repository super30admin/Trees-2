import java.util.Stack;

/*
This approach uses recursive and we are passing currSum as 0
Time COmplexity -> O(N)
Space Complexity -> O(H)
*/

class Solution1 {
    int sum;

    public int sumNumbers(TreeNode root) {
        sumLeaf(root, 0);
        return sum;
    }

    private void sumLeaf(TreeNode root, int currSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum = sum + currSum * 10 + root.val;
        }
        sumLeaf(root.left, currSum * 10 + root.val);
        sumLeaf(root.right, currSum * 10 + root.val);
    }
}
/*
This approach uses recursive and we are passing currSum as 0
Time COmplexity -> O(N)
Space Complexity -> O(H)
*/

class Solution2 {

    public int sumNumbers(TreeNode root) {
        return sumLeaf(root, 0);
    }

    private int sumLeaf(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }
        int case1 = sumLeaf(root.left, currSum * 10 + root.val);
        if (root.left == null && root.right == null) {
            return currSum * 10 + root.val;
        }
        int case2 = sumLeaf(root.right, currSum * 10 + root.val);
        return case1 + case2;
    }
}
/*
This approach uses recursive and we are passing currSum as 4
Time COmplexity -> O(N)
Space Complexity -> O(H)
*/

class Solution3 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumLeaf(root, root.val);
    }

    private int sumLeaf(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        } 
        if (root.left == null && root.right == null) {
            return currSum;
        }
        int case1 = 0;
        int case2 = 0;
        if (root.left != null) {
            case1 = sumLeaf(root.left, currSum * 10 + root.left.val);
        }
        if (root.right != null ) {
            case2 = sumLeaf(root.right, currSum * 10 + root.right.val);
        }
        return case1 + case2;
    }
}

/*
This approach uses iterative  and we are passing currSum as 0
Time COmplexity -> O(N)
Space Complexity -> O(H) + O(H) We are using two stacks
*/
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> currSum = new Stack<>();
        int curr = 0;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                curr = curr * 10 + root.val;
                currSum.push(curr);
                root = root.left;
            }

            root = s.pop();
            curr = currSum.pop();
            if (root.left == null && root.right == null) {
                sum = sum + curr;
            }
            root = root.right;
        }
        return sum;
    }
}
