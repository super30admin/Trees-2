// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

public class SumRootToLeafI {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int result = 0;
        int currNum = 0;
        while(root != null || !st.isEmpty()){
            while(root != null){
                currNum = currNum * 10 + root.val;
                st.push(root);
                numSt.push(currNum);
                root = root.left;
            }
            root = st.pop();
            currNum = numSt.pop();
            if(root.left == null && root.right == null){
                result += currNum;
            }
            root = root.right;
        }
        return result;
    }
}
