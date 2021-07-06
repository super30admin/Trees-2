/*

    Time Complexity :  O(H)
    Space Complexity : O(1) recursive O(H), if using stack O(H)
    is worked n leetcode : YES

*/

public class SumOfRoottoLeafNumber{


    public int sumNumbers_recursive(TreeNode root) {
        
        return helper(root,0);
    }
    
    private int helper(TreeNode  root, int currSum){
        
        if( root == null ) return 0;
        
        if(root.left == null && root.right == null) return currSum *10 + root.val;
        return helper(root.left, currSum* 10 +  root.val ) + helper ( root.right, currSum* 10 + root.val);
        
    }

// iterative approach
    public int sumNumbers(TreeNode root) {
        
        if (root == null) return 0;
        
        int result = 0;
        int current_sum = 0;
        Stack <Pair> st = new Stack<>();
        
        while( root != null  || !st.isEmpty()){
            while (root != null){
                current_sum  = current_sum * 10 + root.val;
                st.push(new Pair(root, current_sum));
                root = root.left;
            }
            
            Pair p  = st.pop();
            root = p.getKey();
            current_sum = p.getValue();
            
            if( root.left == null && root.right == null){
                result =  result + current_sum;
            }
            root = root.right;
            
        }
        
         return result;
    }
}
