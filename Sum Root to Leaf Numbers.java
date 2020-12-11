/*
# Iterative
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        result = curSum = 0
        stack = []
        while root is not None or len(stack) > 0:
            while root is not None:
                curSum = curSum * 10 + root.val
                stack.append((root, curSum))
                root = root.left
            
            root, curSum = stack.pop()
            
            if root.left is None and root.right is None:
                result += curSum
            
            root = root.right
        return result


# Recursive
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root is None:
            return 0

        def helper(root, curSum, result):
            if root is None:
                return 0

            if root.left is None and root.right is None:
                result = result + curSum * 10 + root.val
                return result

            return helper(root.left, curSum * 10 + root.val, result) + helper(root.right, curSum * 10 + root.val, result)

        return helper(root, 0, 0)



// Iterative		
class Solution {
    class Pair{
        TreeNode node;
        int value;
        
        public Pair(TreeNode n, int v){
            this.node = n;
            this.value = v;
        }
        
        public TreeNode getKey(){
            return node;
        }
        public int getValue(){
            return value;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int result = 0, curSum = 0;
        Stack<Pair> s = new Stack<>();
        while (root != null || !s.isEmpty()){
            while (root != null){
                curSum = curSum * 10 + root.val;
                s.push(new Pair(root, curSum));
                root = root.left;
            }
            
            Pair p = s.pop();
            root = p.getKey();
            curSum = p.getValue();
            
            if (root.left == null && root.right == null){
                result += curSum;
            }
            
            root = root.right;
        }
        
        return result;   
		
    }
}



// Recursive with base condition taken cared by global variable
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    
    private int helper(TreeNode root, int curSum){
        if (root == null){
            return 0;
        }
        
        helper(root.left, curSum * 10 + root.val);
        
        if (root.left == null && root.right == null){
            result = result + curSum * 10 + root.val; // we are doing this again as recursive call will have "curSum * 10 + root.val" value and when recursion unwinds we will have to compute again
        }
            
        helper(root.right, curSum * 10 + root.val);
        return 0;
    }
}

// Recursive with base condition taken cared by condition in the function itself
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int curSum){
        if (root == null){
            return;
        }
        
        helper(root.left, curSum * 10 + root.val);
        
        if (root.left == null && root.right == null){
            result = result + curSum * 10 + root.val; // we are doing this again as recursive call will have "curSum * 10 + root.val" value and when recursion unwinds we will have to compute again
        }
            
        helper(root.right, curSum * 10 + root.val);
        
    }
}


*/

// Time Complexity : O(n) where n is height of tree which could be all nodes if tree is right or left skewed
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I calculated the number by multiplying 10 and adding itself and passing
// to the recursive call. I do this for left and right tree and add them and then return

class Solution {
    
    public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
        return helper(root, 0, 0);
    }
    
    private int helper(TreeNode root, int curSum, int result){
        if (root == null){
            return 0;
        }
        
        if (root.left == null && root.right == null){
            result = result + curSum * 10 + root.val;
            return result;
        }
            
        return helper(root.left, curSum * 10 + root.val, result) + helper(root.right, curSum * 10 + root.val, result);
        
    }
}