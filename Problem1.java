//space complexity : O(n)
//time complexity :o(H) where h is the height of tree
public class Problem1 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    
    private void dfs(TreeNode root, int currentSum){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            sum+=currentSum*10+root.val;
        }
        
        dfs(root.left,currentSum*10+root.val);
        dfs(root.right,currentSum*10+root.val);
    }
}
