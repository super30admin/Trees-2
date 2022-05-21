// Time Complexity : O(N)
// Space Complexity : O(H) H=height of the Tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int sum =0;
        int currNum = 0;
        while(root !=null || !st.isEmpty()) {
            while(root!=null){
                st.push(root);
                currNum = currNum*10 + root.val;
                numSt.push(currNum);
                root = root.left;
            }
            root  = st.pop();
            currNum = numSt.pop();
            if(root.left == null && root.right == null)
                sum+=currNum;
            root = root.right;
        }
        return sum;
    }
}
