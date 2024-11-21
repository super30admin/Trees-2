
public class Problem_2 {
	
public int sumNumbers(TreeNode root) {
        
        
        if(root == null){
            return 0;
        }
        
        int prevSum = 0;
        return helper(root, 0);
        
    }
    
    private int helper(TreeNode root, int prevSum){
        
        //Base case
        
        if(root == null){
            return 0;
        }
        
        
        if(root.left == null && root.right == null){
            return prevSum*10+root.val;
        }
        
        //Logic
        int leftSum = helper(root.left, (prevSum*10+root.val));
        int rightSum = helper(root.right, (prevSum*10+root.val));
        
        return leftSum + rightSum;
    }

}
