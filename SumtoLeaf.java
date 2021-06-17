/*SC - O (N) TC O(N) Preorder iterative way*/
class Solution { 
    public int sumNumbers(TreeNode root) {
        // preorder ldr
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        int ans =0;
        int currValue = 0;
       TreeNode curr =null ;
        stack.push(new Pair(root, 0));
        while(!stack.isEmpty()){
            
            Pair<TreeNode , Integer> elem = stack.pop();
            curr = elem.getKey();
            currValue = elem.getValue();
            
            currValue = currValue* 10+ curr.val;
            if (curr.left == null && curr.right == null){
                ans += currValue;
            }
           
            if (curr.right != null) {
                stack.push(new Pair (curr.right, currValue));
            }
            if (curr.left != null) {
                stack.push(new Pair (curr.left, currValue));
            }       
            
        }
        
        return ans;
        
    }
}

// Approach 2 Inorder iterative
class Solution { 
    public int sumNumbers(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        int ans =0;
        int currValue = 0;
        TreeNode curr =null ;
        
        while(!stack.isEmpty() || root != null){
            
            while(root != null){
                currValue = currValue* 10 + root.val;
                stack.push(new Pair(root, currValue)); 
                root = root.left;
            }
            Pair<TreeNode, Integer> elem = stack.pop();
            root = elem.getKey();
            currValue = elem.getValue();
            if (root.left == null && root.right ==null ){ans += currValue;}
            root = root.right; 
        }
        
        return ans;
        
    }
}


// Approach 3 Inorder recursive
/**
*/
class Solution { 
    int ans =0;
    public int sumNumbers(TreeNode root) {
       // Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
       
        helper(root, 0);
        return ans;

        
    }
    
    public void helper(TreeNode root,int  currSum){
        if (root == null) return ;
        currSum  = currSum* 10 + root.val;
        
        helper(root.left, currSum);  
        // add the sum to global ans
        if (root.left == null && root.right == null)ans += currSum;
                                                     
        helper(root.right, currSum);
    }
        
    
}
