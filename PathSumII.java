// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
import java.util.*;
public class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        
        if(root == null)
        {
            return result;
        }
        
        helper(root,0,targetSum,new ArrayList<>());
        return result;
    }
    
    private  void helper(TreeNode root, int currSum, int targetSum, List<Integer> path)
    {
        if(root == null)
        {
            return;
        }
        
        currSum = currSum + root.val;
        
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum)
            {
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left,currSum,targetSum,new ArrayList<>(path));
        helper(root.right,currSum,targetSum,new ArrayList<>(path));
        
        path.remove(path.size()-1);
    }
}
