// Time Complexity: O(n)
// Space Complexity: O(h)

// Bottom Up approach
public class SumRootToLeafNo {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return sum;
       
        return dfs(root, 0);
    }
    
    
    private int dfs(TreeNode root, int currSum)
    {
        // base case
        if(root == null)
            return 0;
        
        // logic
        currSum = currSum * 10 + root.val;
        if(root.left == null && root.right == null)
        {
            return currSum;
        }
   
        return dfs(root.left, currSum) + dfs(root.right, currSum);
    }
}


// DFS approach
public class SumRootToLeafNo {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return sum;
        dfs(root, 0);
        return sum;
    }
    
    
    private void dfs(TreeNode root, int currSum)
    {
        // base case
        if(root == null)
            return;
        
        currSum = currSum * 10 + root.val;
        if(root.left == null && root.right == null)
        {
            sum += currSum;
            return;
        }
         // recursive
        dfs(root.left, currSum);
        dfs(root.right, currSum);
    }
}
