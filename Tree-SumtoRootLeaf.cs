using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(N) 
    // Space Complexity :O(H) - height of tree
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Based on class
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class SumtoRootLeaf
    {
        int totalSum = 0;
        public int SumNumbers(TreeNode root)
        {
            PreOrder(root, 0);
            return totalSum;
        }

        //pre - order recursion
        public void PreOrder(TreeNode root, int currentNumber)
        {
            if (root != null)
            {
                if (root.left == null && root.right == null)
                {
                    totalSum += currentNumber * 10 + root.val;
                }

                PreOrder(root.left, currentNumber * 10 + root.val);
                PreOrder(root.right, currentNumber * 10 + root.val);
            }
        }

        //in - order recursion
        public void InOrder(TreeNode root, int currentNumber)
        {
            if (root != null)
            {
                InOrder(root.left, currentNumber * 10 + root.val);
                if (root.left == null && root.right == null)
                {
                    totalSum += currentNumber * 10 + root.val;
                }
                InOrder(root.right, currentNumber * 10 + root.val);
            }
        }

        //post - order recursion
        public void PostOrder(TreeNode root, int currentNumber)
        {
            if (root != null)
            {
                PostOrder(root.left, currentNumber * 10 + root.val);
                PostOrder(root.right, currentNumber * 10 + root.val);
                if (root.left == null && root.right == null)
                {
                    totalSum += currentNumber * 10 + root.val;
                }
                
            }
        }

        //iterative
        public int PreOrderIterative(TreeNode root)
        {
            Stack<KeyValuePair<TreeNode, int>> stack = new Stack<KeyValuePair<TreeNode, int>>();
            int totalSum = 0;
            int currentNumber = 0;

            if (stack == null)
                stack = new Stack<KeyValuePair<TreeNode, int>>();
            stack.Push(new KeyValuePair<TreeNode, int>(root, 0));

            while (stack != null)
            {
                KeyValuePair<TreeNode, int> p = stack.Pop();

                root = p.Key;
                currentNumber = p.Value;
                if (root != null)
                {
                    currentNumber = currentNumber * 10 + root.val;
                    if (root.left == null && root.right == null)
                    {
                        totalSum += currentNumber;
                    }
                   else
                    {
                        stack.Push(new KeyValuePair<TreeNode, int >(root.left, currentNumber));
                        stack.Push(new KeyValuePair<TreeNode, int>(root.right, currentNumber));
                    }
                }
            }
            return totalSum;
        }
    }
}

