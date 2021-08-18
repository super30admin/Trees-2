using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class SumToLeafLC
    {
        //Time Complexity: O(n)
        //Space Complexity: O(h)
        //Definition of a binary tree node
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            TreeNode() { }
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        int sum;
        public int SumNumbers(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }
            helper(root, 0);
            return sum;
            //return helperWithLocalVariable(root, 0, 0); 
        }

        private void helper(TreeNode root, int currSum)
        {
            //base
            if (root == null)
            {
                return;
            }
            //logic
            currSum = currSum * 10 + root.val;
            helper(root.left, currSum);
            if (root.left == null && root.right == null)
            {
                sum += currSum;
            }
            helper(root.right, currSum);      
        }
        private int helperWithLocalVariable(TreeNode root, int currSum, int sum)
        {
            //base
            if (root == null)
            {
                return 0;
            }
            //logic
            currSum = currSum * 10 + root.val;
            if (root.left == null && root.right == null)
            {
                sum += currSum;
                return sum;
            }
            return helperWithLocalVariable(root.left, currSum, sum) + helperWithLocalVariable(root.right, currSum, sum);
        }

        class Pair
        {
            TreeNode node;
            int currSum;


            public Pair(TreeNode node, int currSum)
            {
                this.node = node;
                this.currSum = currSum;
            }

            public TreeNode getKey()
            {
                return this.node;
            }

            public int getValue()
            {
                return this.currSum;
            }
        }

        public int SumNumbersIteration(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }
            int sum = 0, currSum = 0;
            Stack<Pair> s = new Stack<Pair>();
            while (root != null || s.Count != 0)
            {
                while (root != null)
                {
                    currSum = currSum * 10 + root.val;
                    s.Push(new Pair(root, currSum));
                    root = root.left;
                }
                Pair p = s.Pop();
                root = p.getKey();
                currSum = p.getValue();
                if (root.left == null && root.right == null)
                {
                    sum += currSum;
                }
                root = root.right;
            }
            return sum;
        }
        public int SumNumbersWithInBuiltPair(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }
            int sum = 0, currSum = 0;
            Stack<Tuple<TreeNode, int>> s = new Stack<Tuple<TreeNode, int>>();
            while (root != null || s.Count != 0)
            {
                while (root != null)
                {
                    currSum = currSum * 10 + root.val;
                    s.Push(new Tuple<TreeNode, int>(root, currSum));
                    root = root.left;
                }
                Tuple<TreeNode, int> p = s.Pop();
                root = (TreeNode)p.Item1;
                currSum = (int)p.Item2;
                if (root.left == null && root.right == null)
                {
                    sum += currSum;
                }
                root = root.right;
            }
            return sum;
        }
    }
}
