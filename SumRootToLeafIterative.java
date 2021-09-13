package Trees2;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import Trees1.TreeNode;

import java.util.Stack;

// Your code here along with comments explaining your approach
public class SumRootToLeafIterative {
    public int sumNumbers(TreeNode root) {
        int total = 0;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int sum = 0;
        while(root != null || !st1.isEmpty()){
            while(root != null){
                sum = sum*10 + root.val;
                st1.add(root);
                st2.add(sum);
                root = root.left;
            }
            root = st1.pop();
            sum = st2.pop();
            if(root.left == null && root.right == null){
                total += sum;
            }
            root = root.right;
        }
        return total;
    }
}
