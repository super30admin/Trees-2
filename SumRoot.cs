using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class SumRoot
    {
        /*
         * T.C: O(N) since traversing all the nodes
         * S.C: O(h) where h is hight of tree, at a time only max h element will be there in the stack
         */
        int sum = 0;
        public int SumNumbers(TreeNode root)
        {
            if (root == null)
                return 0;

            //helper(root, 0);

            //return sum;

            return helper1(root, 0);

        }


        //recursion with the help of global variable

        private void helper(TreeNode root, int CurrSum)
        {
            if (root == null)
            {
                return;
            }

            if (root.left == null && root.right == null)
            {
                sum = sum + CurrSum * 10 + root.val;
            }

            helper(root.left, CurrSum * 10 + root.val);
            helper(root.right, CurrSum * 10 + root.val);
        }


        //recursion returning the final result

        private int helper1(TreeNode root, int CurrSum)
        {
            if (root == null)
            {
                return 0;
            }

            if (root.left == null && root.right == null)
            {
                return CurrSum * 10 + root.val;
            }

            int case1 = helper1(root.left, CurrSum * 10 + root.val);
            int case2 = helper1(root.right, CurrSum * 10 + root.val);

            return case1 + case2;
        }


        }
}
