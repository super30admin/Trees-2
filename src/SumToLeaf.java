import javax.swing.tree.TreeNode;
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// go till leaf and store value in ans
public class SumToLeaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //global variable with void
        int max=0;
        public int sumNumbers1(TreeNode root) {
            sum1(root, 0);
            return max;
        }
        public void sum1(TreeNode root, int val) {
            if (root == null) return;
            if (root.left == null && root.right == null) max += val * 10 + root.val;
            if (root.left != null)
                sum1(root.left, val * 10 + root.val);
            if (root.right != null)
                sum1(root.right, val * 10 + root.val);

        }

 // go left + right
// Loval Variable with int
        public int sumNumbers2(TreeNode root) {
            return sum2(root, 0);
        }
        public int sum2(TreeNode root, int s)
        {
            if(root.left==null && root.right==null)
            {
                System.out.println("sum "+ s);
                return s* 10 + root.val;
            }

            System.out.println(root.val + " s "+ s);

            //logic
            int left =0, right =0;
            if(root.left!=null)
                left = sum2(root.left, s*10+root.val) ;
            if( root.right!=null)
                right = sum2(root.right, s*10+root.val);

            return left+right;
    }

}
