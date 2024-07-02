// Time Complexity : O(2n) => O(n) => As we are using 2 stacks to store n nodes and the current num values
// Space Complexity : O(h) => As we are using an additional stack to store the nodes which can go up to the height 'h' of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: This solution uses iterative way where we have 2 stacks one which holds the node and the 2nd stack is used to store the value of current num upto that point.
We calculate sum of left nodes by multiplying the current num*10 and adding the current root value which is then pushed into the stack. For all the leaf nodes thatn finally add the current sum to the sum defined class level
 */

class Solution {
    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }

        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> currentNum = new Stack<>();
        int num = 0;
        int sum = 0;
        while(root != null || !s.isEmpty()){

            while(root != null){
                num = num*10 + root.val;
                s.push(root);
                currentNum.push(num);
                root = root.left;
            }

            root = s.pop();
            num = currentNum.pop();
            if(root.left == null && root.right == null){
                sum = sum + num;
            }

            root = root.right;
        }

        return sum;
    }

}