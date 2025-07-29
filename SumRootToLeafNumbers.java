// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is to perform a DFS traversal from root to leaf,
// building the number along the path by multiplying the accumulated sum by 10 and adding the current node's value.
// When we reach a leaf node, we add the accumulated number to the global sum.
// We reset the global `sum` variable at the start of each call to ensure accurate results across multiple test cases.



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeafNumbers{
    int sum;
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        dfs(root, 0);
        return sum;

    }

    private void dfs(TreeNode root, int currsum){
        if(root==null){
            return;
        }
        dfs(root.left, currsum * 10 + root.val);
        if(root.left == null && root.right == null){
            sum+=currsum * 10 + root.val;
            return ;
        }
        dfs(root.right, currsum * 10 + root.val);

    }

    public static void main(String[]args){
        SumRootToLeafNumbers ob1 = new SumRootToLeafNumbers();
        SumRootToLeafNumbers ob2 = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(4, 
                            new TreeNode(9, new TreeNode(5), new TreeNode(1)),
                            new TreeNode(0));
        
        int res1 = ob1.solve(root);
        int res2 = ob2.solve(root2);
        System.out.println("Sum of root to leaf numbers is: "+res1);
        System.out.println("Sum of root to leaf numbers is: "+res2);

    }
}