/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumRootToLeafNodes {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        int num=0; int sum = 0; //intializing
        
        while( root != null || !st.isEmpty() ) { //outer condition
            while(root != null) { //till root is not null
                st.push(root); //pushing root inside stack
                num = num * 10 + root.val; //calculating the value
                numStack.push(num); //pushing in separate stack
                root = root.left; //changing root to root.left
            }
            root = st.pop(); //storing popped element in root
            num = numStack.pop(); //storing popped element from numStack
            
            if(root.left == null && root.right == null) {//till we reach end
                sum = sum + num; //last num + total sum till now
            }
            
            root = root.right; //continuing ahead with changing root to right
        }
        return sum;
    }
}