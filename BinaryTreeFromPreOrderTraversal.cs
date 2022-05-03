using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class BinaryTreeFromPreOrderTraversal
    {
        int idx;
        Dictionary<int, int> map = new Dictionary<int, int>();
        public TreeNode BuildTree(int[] preorder, int[] inorder)
        {

            for (int i = 0; i < inorder.Length; i++)
            {
                map.Add(inorder[i], i);
            }

            TreeNode head = construct(preorder, 0, preorder.Length - 1);

            return head;

        }

        private TreeNode construct(int[] preorder, int start, int end)
        {
            if (start > end)
                return null;

            int rootVal = preorder[idx];

            TreeNode root = new TreeNode(rootVal);

            idx++;

            int rootIdx = map[rootVal];

            root.left = construct(preorder, start, rootIdx - 1);
            root.right = construct(preorder, rootIdx + 1, end);

            return root;

        }
    }
}
