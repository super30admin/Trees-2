//time complexity:O(n)
//space complexity:O(h)
public class SumRootLeaf {
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
        int sum;
        public int sumNumbers(TreeNode root)
        {
            if(root==null)
            {
                return 0;
            }
            sum=0;
            dfs(root,0 );
            return sum;
        }
        private void dfs(TreeNode root,int curr)
        {
            if(root==null)
            {
                return;
            }
            if(root.left==null && root.right==null)
            {
                sum=sum+curr*10+root.val;
            }
            dfs(root.left,curr*10+root.val);
            dfs(root.right,curr*10+root.val);
        }
        public static void main(String[] args)
        {
            SumRootLeaf obj = new SumRootLeaf();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            System.out.println(obj.sumNumbers(root));

        }
    }

