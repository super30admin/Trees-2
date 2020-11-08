// Time complexity: O(n) where n is the number of nodes in tree
// Space Complexity: O(n)
// Leetcode: It runs on leetcode
// Problem faced: NO






/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int root_index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        root_index = postorder.length-1;

        return helper(inorder,postorder,0,postorder.length-1);

    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end)
    {

        // System.out.println(start+" "+end+"");


        if(start>end)
        {
            return null;
        }

        TreeNode temp = new TreeNode(postorder[root_index]);


        root_index = root_index - 1;

        if(start==end)
        {
            return temp;
        }

        // int[] left = new int[inorder.length];

        // System.out.println(root_index);

        int a=0;

        for(int i=start;i<=end;i++)
        {
            if(temp.val == inorder[i])
            {
                a=i;
                break;
            }
        }

        temp.right =helper(inorder,postorder,a+1,end);
        temp.left = helper(inorder,postorder,start,a-1);



        return temp;
    }
}