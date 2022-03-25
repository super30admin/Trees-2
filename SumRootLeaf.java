// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
The intuition is to take sum till each individual node and store along with it. Thus 2 local variables: root and number
Do inorder traversal and if reached leaves, add the num to the sum.
 */

import java.util.Stack;

public class SumRootLeaf {
    public class TreeNode {
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
    int sum;
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        //base
        if(root == null) return 0;

        //logic
        int num = 0;
        while(!stack.isEmpty() || root != null){
            while(root!=null){
                stack.push(root);
                num = num*10 + root.val;
                numStack.push(num);
                root = root.left;
            }
            root = stack.pop();
            num = numStack.pop();
            if(root.right == null && root.left == null){
                sum += num;
            }
            root = root.right;
        }
        return sum;

        //recursive
        //base
        /*if(root == null) return 0;
        inorderSum(root, 0);
        return sum;*/
    }

    //recursive
    /*private void inorderSum(TreeNode root, int num){
        //base
        if(root == null) return;

        //logic
        num = num*10 + root.val;
        inorderSum(root.left, num);
        //st.pop, root is fixed but num is changing, local to a node
        //works for both inorder or postorder or preorder
        if(root.left == null && root.right == null){
            sum += num;
        }
        inorderSum(root.right, num);
    }*/
}
