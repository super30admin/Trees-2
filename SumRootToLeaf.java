/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: created a global variable to hold the sum of all the paths.
// Recursive solution's break condition is if root is null or root doesn't have
// any children. In this case, we add the currSum to the sum.
// If root has child nodes, we iterate over them recursively.
// class Solution {


//     public int sumNumbers(TreeNode root) {

//         return sumNumbers(root, 0);

//     }

//     private int sumNumbers(TreeNode node , int num)
//     {
//         //PREORDER
//         if(node == null)
//         {
//             return 0 ;
//         }

//         int currNum = num*10 + node.val;

//         if(node.left == null && node.right == null)
//         {
//             return currNum;
//         }

//        return  sumNumbers(node.left, currNum)+
//         sumNumbers(node.right , currNum);
//     }
// }

class Pair{
    private TreeNode node;
    private int num;

    Pair(TreeNode node , int num)
    {
        this.node = node;
        this.num = num;
    }

    public TreeNode getNode()
    {
        return node;
    }

    public int getNum()
    {
        return num;
    }
}
class Solution{

    public int sumNumbers(TreeNode root)
    {
        int sum = 0;
        int num = 0;
        Stack<Pair> stack = new Stack<>();
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(new Pair(root , num * 10 + root.val ));
                root = root.left;
            }


            Pair pair = stack.pop();
            root = pair.getNode();

            //process left child
            if (root.left == null && root.right == null)
            {
                sum += (pair.getNum() * 10+ root.val);
            }
            num = pair.getNum();
            root = root.right;

        }
        return sum;
    }
}