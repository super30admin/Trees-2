package Trees2;

import java.util.Arrays;
import java.util.Stack;

public class question46_sumRootToLeafNumbers {

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

    /*
        Time Complexity: O(n)
        Time Complexity: O(h); h - height of tree
    */

    class Pair {
        TreeNode node;
        int value;
        Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
        public TreeNode getKey() {
            return this.node;
        }
        public int getValue() {
            return this.value;
        }
    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            int result = 0;
            int currSum = 0;
            if(root == null) return result;
            Stack<Pair> stack = new Stack<>();
            while(root != null || !stack.isEmpty()) {
                while(root != null) {
                    currSum = currSum * 10 + root.val;
                    stack.push(new Pair(root, currSum));
                    root = root.left;
                }
                Pair p = stack.pop();
                root = p.getKey();
                currSum = p.getValue();
                if(root.left == null && root.right == null) result += currSum;
                root = root.right;
            }
            return result;
        }
    }


    /*
        Recursion
            Time Complexity: O(n)
            Space Complexity: O(h); h: height of the tree
    */
    int result = 0;
    public int sumNumbers1(TreeNode root) {
        if(root == null) return 0;
        helper1(root, 0);
        return result;
    }
    private void helper1(TreeNode root, int currSum) {
        //Base Case
        if(root == null) return;

        //Logic
        currSum = 10 * currSum + root.val;
        helper1(root.left, currSum);
        if(root.right == null && root.left == null) result += currSum;
        helper1(root.right, currSum);
    }

    /*
        Recursion: Here we are not inserting the leaf into the stack,
        we will return the value once we reach the leaf node.
            Time Complexity: O(n)
            Space Complexity: O(h); h: height of the tree
    */

    public int sumNumbersRec(TreeNode root) {
        if(root == null) return 0;
        return helper2(root, 0);

    }
    private int helper2(TreeNode root, int currSum) {
        //Base Case
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 10 * currSum + root.val;

        //Logic
        currSum = 10 * currSum + root.val;
        int case1 = helper2(root.left, currSum);
        // stack.pop() is occuring here
        // if(root.right == null && root.left == null) result += currSum;
        int case2 = helper2(root.right, currSum);

        return case1 + case2;
    }

    public static void main(String[] args) {

    }
}
