//Approach-1: BruteFore Inorder traversal
//Overall Time Complexity: O(N) N->number of node
//Overall Space Complexity: O(H) H-> Height of the tree
class Solution { 
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        
        int tempSum = 0;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            //Moving left
            while(root != null){
                tempSum = tempSum * 10 + root.val;
                st.add(root);
                sum.add(tempSum);
                root = root.left;
            }
            
            root = st.pop();
            tempSum = sum.pop();
            
            //Check if the node is the leaf node
            if(root.left == null && root.right == null){
                res += tempSum;
            }
            
            root = root.right;
        }
        
        return res;
    }
}


//Approach-2: Recursion using the tempSum with starting from 0 - void function
//Overall Time Complexity: O(N) N->number of node
//Overall Space Complexity: O(H) H-> Height of the tree
class Solution {
    int res = 0;
    
    public int sumNumbers(TreeNode root) {
        checker(root, 0);
        return res;
    }
    
    public void checker(TreeNode root, int temp){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
             res += temp*10 + root.val;
        }
        
        
        
        checker(root.left, temp * 10 + root.val);
        checker(root.right, temp * 10 + root.val);
        
        
    }
}


//Approach-3: Recursion using the tempSum with starting from 0 - int function
//Overall Time Complexity: O(N) N->number of node
//Overall Space Complexity: O(H) H-> Height of the tree
class Solution {
    
    public int sumNumbers(TreeNode root) {
        return checker(root, 0);
    }
    
    public int checker(TreeNode root, int temp){
        if(root == null) return 0;
        
        temp = temp * 10 + root.val;
        
        if(root.left == null && root.right == null){
            return temp;
        }
        
        
        return checker(root.left, temp)
         + checker(root.right, temp);
        
        
    }
}