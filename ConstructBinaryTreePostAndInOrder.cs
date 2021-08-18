using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class ConstructTreeFromPostOrderAndInOrderLC
    {
        //Time Complexity: O(n)
        //Space Complexity: O(h)
        //Definition of a binary tree node
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            public TreeNode() { }
            public TreeNode(int val) { this.val = val; }
            public TreeNode(int val, TreeNode left, TreeNode right)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        Dictionary<int, int> map;
        int idx;
        public TreeNode BuildTreeOptimized(int[] inorder, int[] postorder)
        {
            if (inorder == null || inorder.Length == 0)
            {
                return null;
            }
            map = new Dictionary<int, int>();
            idx = postorder.Length - 1;
            for (int i = 0; i < inorder.Length; i++)
            {
                map.Add(inorder[i], i);
            }
            return helperOptimzed(postorder, 0, postorder.Length - 1);
        }

        private TreeNode helperOptimzed(int[] postorder, int start, int end)
        {
            //base
            if (start > end)
            {
                return null;
            }
            //logic
            int rootVal = postorder[idx];
            idx--;
            TreeNode root = new TreeNode(rootVal);
            int rootIdx = map[rootVal];
            root.right = helperOptimzed(postorder, rootIdx + 1, end);
            root.left = helperOptimzed(postorder, start, rootIdx - 1);
            return root;
        }

        public TreeNode BuildTree(int[] inorder, int[] postorder)
        {
            if (inorder == null || inorder.Length == 0)
            {
                return null;
            }
            int idx = postorder.Length - 1;
            int rootVal = postorder[idx];
            TreeNode root = new TreeNode(rootVal);
            int index = -1;
            for (int i = 0; i < inorder.Length; i++)
            {
                if (inorder[i] == rootVal)
                {
                    index = i;
                    break;
                }
            }
            int c = 0;
            int[] inorderLeft = null;//end is not included
            int[] inorderRight = null;
            int[] postorderLeft = null;
            int[] postorderRight = null;
            for (int i = 0; i < index; i++)
            {
                inorderLeft[c] = inorder[i];
                c++;
            }
            c = 0;
            for (int i = index + 1; i < inorder.Length; i++)
            {
                inorderRight[c] = inorder[i];
                c++;
            }
            c = 0;
            for (int i = 0; i < index ; i++)
            {
                postorderLeft[c] = postorder[i];
                c++;
            }
            c = 0;
            for (int i = index; i < postorder.Length -1; i++)
            {
                postorderRight[c] = postorder[i];
                c++;
            }
            //int[] inorderLeft = Arrays.CopyofRange(inorder, 0, index);
            //int[] inorderRight = Arrays.CopyofRange(inorder, index + 1, inorder.Length);
            //int[] postorderLeft = Arrays.CopyofRange(postorder, 0, index);
            //int[] postorderRight = Arrays.CopyofRange(postorder, index, postorder.Length - 1);
            root.left = BuildTree(inorderLeft, postorderLeft);
            root.right = BuildTree(inorderRight, postorderRight);
            return root;
        }
    }
}
