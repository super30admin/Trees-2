// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we traverse the tree in BFS manner and reach the left most node, in doing so we keep on increasing the sum and also the 
//push the sum accordingly into the stack.
// for processing the elements in right side the stack is popped and the right sub tree is processed.
// only for the leaf nodes the currSum is noted and added



// Your code here along with comments explaining your approach


import java.util.Stack;

public class SumFromRootToLeaf {
    public static int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int currNum = 0;
        int result = 0;
        
        while(root != null || !st.isEmpty()) {
            while(root != null){
                currNum = currNum*10 + root.val;
                st.push(root);
                numStack.push(currNum);
                root = root.left;
            }
            root = st.pop();
            currNum = numStack.pop();
            if(root.left == null && root.right == null)
                result+=currNum;
            root = root.right;
        }
        
        return result;
        
    }
    public static void main(String argsp[]) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));

    }
    
    
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

