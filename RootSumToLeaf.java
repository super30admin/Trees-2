// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we maintain a global variable for the current sum at each node. We then add all those sum when we reach a leaf node.
//We perform recursion of left side first and then right. 
public class RootSumToLeaf {
    int currSum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return currSum;
    }
    private void helper(TreeNode root, int currNum){
        //base
        if(root == null)return;

        //logic
        currNum = currNum*10+ root.val;
        if(root.left == null && root.right == null){
            currSum += currNum;
        }
        helper(root.left,currNum);
        helper(root.right,currNum);
    }
}

//int based recursion
class Solution {
    int currSum;
    public int sumNumbers(TreeNode root) {
        currSum = 0;
        return helper(root,0);
    }
    private int helper(TreeNode root, int currNum){
        //base
        if(root == null) return 0;

        //logic
        currNum = currNum*10+ root.val;
        if(root.left == null && root.right == null){
            currSum += currNum;
        }
        int left = helper(root.left,currNum);
        int right = helper(root.right,currNum);

        return currSum;
    }
}

//iterative solution
class Solution2 {
    public int sumNumbers(TreeNode root) {
       Stack<TreeNode> st = new Stack<>();
       Stack<Integer> numSt = new Stack<>();

       int currNum = 0;
       int currSum = 0;

        while(root!= null || !st.isEmpty()){
            while(root!= null){
                currNum = currNum*10 + root.val;
                st.push(root);
                numSt.push(currNum);
                root=root.left;
            }
            root= st.pop();
            currNum = numSt.pop();
            if(root.left == null && root.right == null){
                currSum += currNum;
            }
            root = root.right;
        }
        return currSum;
    }
}