//Time Complexity: O(n)
//Space Complexity: O(h), h is the height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

//Iterative solution
class Solution {
 
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> currNumSt = new Stack<>();
        int result = 0;
        int currNum = 0;
        while(root!=null || !st.isEmpty()){
            while(root != null){
                currNum = currNum * 10 + root.val;
                st.push(root);
                currNumSt.push(currNum);
                root = root.left;
            }
            //st.pop();
            root = st.pop();
            currNum = currNumSt.pop();
            if( root.left == null && root.right == null){
                result += currNum;
            }
            root = root.right;
        }
        return result;
    }
}
/* Recursive solution
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int currNum){
        //base
        if(root == null) return;
        //logic
        helper(root.left, currNum * 10 + root.val);
        if(root.left == null && root.right == null){
            result += currNum *10 + root.val;
        }
        helper(root.right, currNum * 10 + root.val);
        
    }
}
*/