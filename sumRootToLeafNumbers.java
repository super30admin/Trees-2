//time complexity: O(n)
//space complexity: O(h)
//where n is the number of elements in tree. h is the height tree

class SumRToLSolution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        int pathSum = 0;
        
        return findSum(pathSum, root);
    }
    
    public static int findSum(int pathSum, TreeNode root)
    {
        if(root == null)
            return 0;
        
        pathSum = pathSum*10 + root.val;
        if (root.left == null && root.right == null)
            return pathSum;
      
        return findSum(pathSum, root.left)+findSum(pathSum, root.right);
            
    }

}