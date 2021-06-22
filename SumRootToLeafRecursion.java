package Trees2;

/*      Time complexity : o(n) - n is the number of elements in tree
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
