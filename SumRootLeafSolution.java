// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Did an iterative in-order traversal used one more stack to keep track of num
public class SumRootLeafSolution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        int num = 0;

        //Stack - 1 to keep track of TreeNode.
        Stack<TreeNode> s = new Stack<>();
        
        //Stack - 2 to keep track of nums.
        Stack<Integer> nums = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                num = num * 10 + root.val;
                nums.push(num);
                root = root.left;
            }
            root = s.pop();
            num = nums.pop();
            if(root.left == null && root.right == null) {
                sum += num;
            }
            root = root.right;
        }
        return sum;
    }
}
