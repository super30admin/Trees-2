// ITERATIVE
public class RootToLeafNum1 {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int curSum = 0, result = 0;
        
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                curSum = curSum*10+root.val;
                st.push(root);
                numSt.push(curSum);
                root = root.left;
            }
            root = st.pop();
            curSum = numSt.pop();
            
            if(root.left==null && root.right==null) result+=curSum;
            root = root.right;
        }
        return result;
    }
}

// RECURSIVE
public class RootToLeafNum2 {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root, int curSum){
        if(root==null) return 0;
        
        curSum = curSum*10+root.val;
        //leaf node
        if(root.left==null && root.right==null) return curSum;
        
        return helper(root.left, curSum)+helper(root.right, curSum);
    }
}

// Time Complexity - O(n)  [n-number of nodes in the tree]
// Space Complexity - O(h) [h-height of the tree]
