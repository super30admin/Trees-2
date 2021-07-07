package com.ds.rani.tree;

import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */

//Approach:Using inorder traversal approach,while traversing I am maining stack of visited nodes
// and sum from root to that node

//Time Complexity:o(n) where n is number of nodes
//Space Complexity: o(h) where h is height of the tree
public class SumRootToLeafNumbers {

    /**
     * find sum
     * @param root root node of tree
     * @return sum
     */
    public int sumNumbers(TreeNode root) {
        return helper( root );
    }

    /**
     *
     * @param root
     * @return
     */
    int helper(TreeNode root) {
        int result = 0;
        int sum = 0;
        //For null tree
        if (root == null)
            return result;
        //Maintain Pair of Node,sum(sum form root to that node)
        Stack<Pair> stack = new Stack<>();
        TreeNode curr = root;

        //Inorder traversal
        while (!stack.isEmpty() || curr != null) {
            //go on left
            if (curr != null) {
                sum = sum * 10 + curr.val;
                stack.push( new Pair( curr, sum ) );
                curr = curr.left;
            } else {
                //curr is null here so pop value from
                Pair pair = stack.pop();
                curr = pair.getNode();
                sum = pair.getSum();
                if (curr.left == null && curr.right == null)
                    result = result + sum;
                curr = curr.right;

            }

        }
        return result;

    }
}

/**
 * TreeNode class
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Pair {
    TreeNode node;
    int sum;

    Pair(TreeNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getSum() {
        return sum;
    }
}
