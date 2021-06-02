package Tree1;

/*S30 Big N Problem #46 {Medium} - https://www.youtube.com/watch?v=UTFiBQuayBw
   
   You are given a binary tree which has digits from 0-9 at each node and each root-to-leaf path could be represented by a number.
    we can understand it as we have root-to-leaf path as 1->2->3 then it represents a number 123. you have to give the total sum of all the root-to-leaf numbers. 
    when i say i mean the node with no children.

Example 1:
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1

Output: 1026

Explanation:

The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.

Therefore, sum = 495 + 491 + 40 = 1026.
Source Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
        -------------------------------------------------------------------------------------------------------
        Time complexity : o(n) - n is the number of elements in tree
        space complexity: o(h) - Height of the tree. At any given time,there will H nodes inside my recursive stack.
        Did this code run successfully in leetcode : yes
        problems faces : no
        */

public class SumRootToLeafRecursion {
    
         int currentSum =0;
         int result = 0;

        public int sumNumbers(TreeNode root) 
        {
            
            inorder(root,currentSum);
            return result;
        }
        
        public void inorder(TreeNode root,int currentSum)
        {
         
            if(root == null) return ;
            
            currentSum = currentSum*10 + root.val;

            if(root.left == null && root.right == null)  {
                result += currentSum;
            }
          
           inorder(root.left,currentSum);
           
           inorder(root.right,currentSum); 
           // the current sum going here in method inorder(root.right,currentSum)  not same as goin in inorder(root.left,currentSum);
           // only after all the left nodes are recursively executed the method inorder(root.right,currentSum) is called
        }


    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
